package tma.api.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope("prototype")
@Entity(name = "Student")
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected int id;

    @Column(name = "student_name")
    protected String name;

    @Column(name = "birth_year")
    protected String yearBirth;

    @Column(name = "gender")
    protected String gender;

    @Column(name = "gpa")
    protected float gpa;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)  
    @JoinColumn(name="student_id")
    protected Set<Subject> subjects;

    @Autowired
    public Student() {}

    public Student(String name, String yearBirth, String gender) {
        this.name = name;
        this.yearBirth = yearBirth;
        this.gender = gender;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYearBirth() {
        return this.yearBirth;
    }

    public void setYearBirth(String yearBirth) {
        this.yearBirth = yearBirth;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public float getGpa() {
        return this.gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = calculateGPA();
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
        this.calculateGPA();
    }

    public void addSubject(Subject subject) {
        this.subjects.add(subject);
    }

    public float calculateGPA(){
        if (this.subjects.size() == 0){
            this.gpa = -1;
            return -1;
        }
            
        this.gpa = 0;
        for (Object subject:this.subjects) {
            Subject sub = new Subject();
            sub = (Subject) subject;
            this.gpa += sub.getMark();
        }

        this.gpa = this.gpa/(float)this.subjects.size();
        double gpa_mark = (double) Math.round(this.gpa * 100) / 100;
        this.gpa = (float) gpa_mark;
        
        return this.gpa;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                " | Name: " + name +
                " | Year of birth: " + yearBirth +
                " | Gender: " + gender +
                " | GPA: " + gpa;
    }
}
