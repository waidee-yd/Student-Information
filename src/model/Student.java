package model;

import java.util.ArrayList;

public class Student {

    public static int idCounter = 1;
    public static ArrayList<ArrayList<String>> table = new ArrayList<>();

    protected String last;
    protected String middle;
    protected String first;

    protected String studentID;


    public Student() {

    }

    public void setID(int method) {

    }

    public void setLast(String lastName) {
        this.last = lastName;
    }

    public void setMiddle(String middleName) {
        this.middle = middleName;
    }

    public void setFirst(String firstName) {
        this.first = firstName;
    }

    public String getID() {
        return this.studentID;
    }
}
