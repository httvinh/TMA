package tma;

import java.util.List;
import java.util.ArrayList;

public class Student {
    protected String name;
    protected String id;
    protected String year_of_birth;
    protected String gender;
    protected float gpa;
    protected List<Subject> subject_list;

    public Student(String name, String id, String year_of_birth, String gender) {
        this.name = name;
        this.id = id;
        this.year_of_birth = year_of_birth;
        this.gender = gender;
        this.gpa = -1;
        this.subject_list = new ArrayList<>();
    }


    public String getName() {
        return this.name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getID() {
        return this.id;
    }


    public void setID(String id) {
        this.id = id;
    }


    public String getYearOfBirth() {
        return this.year_of_birth;
    }


    public void setYearOfBirth(String year_of_birth) {
        this.year_of_birth = year_of_birth;
    }


    public String getGender() {
        return this.gender;
    }


    public void setGender(String gender) {
        this.gender = gender;
    }


    public float getGPA() {
        return this.gpa;
    }


    public void setGPA(float gpa) {
        this.gpa = gpa;
    }


    public void addSubject(Subject subject) {
        this.subject_list.add(subject);
    }


    public float calculateGPA(){
        if (this.subject_list.size() == 0){
            this.gpa = -1;
            return -1;
        }
            
        this.gpa = 0;
        for (Subject subject:this.subject_list) {
            this.gpa += subject.getMark();
        }

        this.gpa = this.gpa/(float)this.subject_list.size();
        return this.gpa;
    }


    public String toString() {
        return "Student name: " + name + "\n"
                + "ID: " + id + "\n"
                + "Year of birth: " + year_of_birth + "\n"
                + "Gender: " + gender + "\n"
                + "GPA: " + gpa + "\n"
                + "-------------------------------";
    }


    public void showInfor() {
        System.out.println("*******************************");
        System.out.println(this.toString());
        System.out.println("----------SUBJECT LIST----------");
        this.subject_list.forEach(subject -> System.out.println(subject.toString()));
    }
}
