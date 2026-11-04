package model;

import java.util.ArrayList;

public class Student {

    //Data Handler
    public static int idCounter = 1;
    public static ArrayList<ArrayList<String>> table = new ArrayList<>();

    //Data Variable
    protected String last;
    protected String middle;
    protected String first;

    protected String studentID;

    //Constructor
    public Student() {

    }

    //Setters
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

    //Getters
    public String getID() {
        return this.studentID;
    }
}
