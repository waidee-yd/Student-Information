package model;

import controller.studentController;

public class Student {

    public static int idCounter = 1;

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

    public String getName() {

        return this.last + this.middle + this.first;
    }

    public String getID() {
        return this.studentID;
    }
}
