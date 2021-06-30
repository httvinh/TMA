package tma.hibernate.configspring.entity;

import java.util.Set;

public class Student {
    private int id;
    protected String name;
    protected String yearBirth;
    protected String gender;
    protected Set<Subject> subjects;
    protected float gpa;

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
        return this.calculateGPA();
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
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

    public String toString() {
        return "ID: " + id +
                " | Name: " + name +
                " | Year of birth: " + yearBirth +
                " | Gender: " + gender +
                " | GPA: " + gpa;
    }
}