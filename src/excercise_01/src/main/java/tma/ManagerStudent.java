package tma;

import java.util.List;
import java.util.ArrayList;

public class ManagerStudent {
    protected List<Student> students_list;

    public ManagerStudent() {
        this.students_list = new ArrayList<>();
    }


    public void addStudent(Student student) {
        this.students_list.add(student);
    }


    public void maxGPA() {
        List<Student> max_list = new ArrayList<>();
        float max = 0;

        for(Student student : students_list) {
            max = (max < student.gpa) ? student.gpa : max; 
        }

        for(Student student : students_list) {
            if(max == student.gpa) {
                max_list.add(student);
            }
        }

        max_list.forEach(student -> System.out.println(student.toString()));
    }


    public void minGPA() {
        List<Student> min_list = new ArrayList<>();
        float min = 9999;

        for(Student student : students_list) {
            min = (min > student.gpa) ? student.gpa : min; 
        }

        for(Student student : students_list) {
            if(min == student.gpa) {
                min_list.add(student);
            }
        }

        min_list.forEach(student -> System.out.println(student.toString()));
    }


    public void showStudents() {
        this.students_list.forEach(student -> System.out.println(student.toString()));
    }

}
