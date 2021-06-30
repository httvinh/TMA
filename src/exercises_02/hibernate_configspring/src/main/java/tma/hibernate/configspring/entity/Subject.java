package tma.hibernate.configspring.entity;

public class Subject {
    protected int id;
    protected String name;
    protected float mark;
    protected Student student;

    public Subject() {}

    public Subject(String name, float mark) {
        this.name = name;
        this.mark = mark;
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

    public float getMark() {
        return this.mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }

    public Student getStudent() {
        return this.student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    
    public String toString() {
        return "\n\t| Subject: " + name + " | Mark: " + mark;
    }
}