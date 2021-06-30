package tma.hibernate.annotations.util;

import java.util.Set;
import java.util.List;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.hibernate.boot.Metadata;  
import org.hibernate.boot.MetadataSources;  
import org.hibernate.boot.registry.StandardServiceRegistry;  
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import tma.hibernate.annotations.entity.*;

@Component
@Scope("prototype")
public class ManagerStudent {

    @Autowired
    public ManagerStudent() {}

    StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
    Metadata metadata = new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();
    SessionFactory factory = metadata.getSessionFactoryBuilder().build();

    // Print students list
    public void showStudent(Student student, Set<Subject> subjects) {
        System.out.println(student);
        for (Subject subject_i:subjects) {
            System.out.println(subject_i);
        }

        System.out.println("----------------------------------------------------------------------");
    }

    // Read student list form database
    public void listStudent() {
        Session session = factory.openSession();

        String query_string = "SELECT s FROM Student s";
        List<Student> students = session.createQuery(query_string, Student.class).getResultList();

        for (Student student_i:students) {
            showStudent(student_i, student_i.getSubjects());
        }

        session.close();
    }

    // Find student in database
    public boolean findStudent(int student_id) {
        Session session = factory.openSession();
        Student student = session.get(Student.class, student_id);

        if (student == null) {
            return false;
        }

        showStudent(student, student.getSubjects());

        session.close();

        return true;
    }

    // Insert an student in the database
    public void addStudent(String name, String year, String gender, Set<Subject> subjects) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        Student student = new Student(name, year, gender);
        student.setSubjects(subjects);
        student.calculateGPA();

        session.persist(student);

        transaction.commit();

        System.out.println("============================INSERT SUCCESS============================");
        showStudent(student, subjects);

        session.close();       
    }

    // Update a student information
    public void updateStudent(Integer student_id, String name, String year, String gender, Set<Subject> subjects) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        Student student = session.get(Student.class, student_id);
        Set<Integer> throw_subjects = new HashSet<Integer>();

        for (Subject subject_i : student.getSubjects()) {
            System.out.println(subject_i);
            System.out.println(subject_i.getId());
            throw_subjects.add(subject_i.getId());
        }

        student.setName(name);
        student.setYearBirth(year);
        student.setGender(gender);
        student.setSubjects(subjects);
        session.update(student);

        for (int id_i : throw_subjects) {
            Subject subject = session.get(Subject.class, id_i);
            System.out.println(subject);
            session.delete(subject);
        }
    
        transaction.commit();

        System.out.println("============================UPDATE SUCCESS============================");

        session.close();
    }

    // Delete a student in database
    public void deleteStudent(Integer student_id) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        Student student = session.get(Student.class, student_id);
        session.delete(student);

        transaction.commit();

        System.out.println("============================DELETE SUCCESS============================");

        session.close();  
    }

    // Find students with the highest GPA
    public void maxGPA() {
        Session session = factory.openSession();

        String query_string = "FROM Student S WHERE S.gpa = (SELECT max(S.gpa) FROM Student S)";
        List<Student> students = session.createQuery(query_string, Student.class).getResultList();

        for (Student student_i:students) {
            showStudent(student_i, student_i.getSubjects());
        }

        session.close();
    }

    // Find students with the lowest GPA
    public void minGPA() {
        Session session = factory.openSession();

        String query_string = "SELECT s FROM Student s WHERE s.gpa = (SELECT min(s.gpa) FROM Student s)";
        List<Student> students = session.createQuery(query_string, Student.class).getResultList();

        for (Student student_i:students) {
            showStudent(student_i, student_i.getSubjects());
        }

        session.close();
    }
}
