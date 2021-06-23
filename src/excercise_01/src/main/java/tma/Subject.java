package tma;

public class Subject {
    protected String name;
    protected String id;
    protected float mark;

    public Subject(String name, String id, float mark) {
        this.name = name;
        this.id = id;
        this.mark = mark;
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


    public float getMark() {
        return this.mark;
    }


    public void setMark(float mark) {
        this.mark = mark;
    }

    
    public String toString() {
        return "Subject name: " + name + "\n"
                + "ID: " + id + "\n"
                + "Mark: " + mark + "\n"
                + "---------------------------";
    }
}
