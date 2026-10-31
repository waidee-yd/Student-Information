package model;

import java.time.Year;

public class Student {

    private static int idCounter = 1;

    protected String last;
    protected String middle;
    protected String first;

    private String studentID;

    public Student() {

    }

    public void setID() {
        Year currYear = Year.now();
        this.studentID = currYear + " - " +String.format("%05d",idCounter) + " - MN - 0";;
        idCounter++;
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
