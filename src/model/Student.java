package model;

import java.time.Year;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {

    //Data Handler
    public static int idCounter = 1;
    public static ArrayList<ArrayList<String>> table = new ArrayList<>();

    //Data Variable
    protected String last;
    protected String middle;
    protected String first;
    protected String email;
    protected String studentID;
    protected String course;

    protected String[] courseList = {
            "Bachelor of Science in Computer Science",
            "Bachelor of Science in Information Technology",
            "Bachelor of Science in Industrial Engineering",
            "Bachelor of Science in Civil Engineering",
            "Bachelor of Science in Chemical Engineering",
            "Bachelor of Science in Electrical Engineering",
            "Bachelor of Science in Mechanical Engineering",
            "Bachelor of Science in Architecture"
    };

    //Constructor
    public Student() {

    }

    //Setters

    public void setLast(String lastName) {
        this.last = lastName;
    }

    public void setMiddle(String middleName) {
        this.middle = middleName;
    }

    public void setFirst(String firstName) {
        this.first = firstName;
    }

    public void setEmail(String studentEmail) { this.email = studentEmail; }

    public void setCourse(String studentCourse) { this.course = studentCourse; }

    public void setID(int method) {
        if (method == 1) {
            //Standard method of counter
            Year currYear = Year.now();
            this.studentID = currYear + "-" +String.format("%05d",idCounter) + "-MN-0";
            idCounter++;
        } else {
            //Regular expression method of counter
            if (table.isEmpty()) {
                Year currYear = Year.now();
                this.studentID = currYear + "-00001-MN-0";
            } else {
                ArrayList<String> lastRow = table.getLast();

                String lastID = lastRow.getFirst();

                Pattern pattern = Pattern.compile("^\\d{4}\\s*-\\s*(\\d{5})");
                Matcher matcher = pattern.matcher(lastID);

                if (matcher.find()) {
                    String counterPart = matcher.group(1);
                    idCounter = Integer.parseInt(counterPart) + 1;
                }

                Year currYear = Year.now();
                this.studentID = currYear + "-" + String.format("%05d", idCounter) + "-MN-0";
                idCounter++;
            }
        }

    }

    //Setting the data in the array
    public void setData() {
        ArrayList<String> row = new ArrayList<>();

        row.add(this.studentID);
        row.add(this.last);
        row.add(this.first);
        row.add(this.middle);
        row.add(this.email);
        row.add(this.course);

        table.add(row);

        System.out.println("Student record successfully saved to table!");

    }

    //Getters

    public String getStudentID() { return this.studentID; }
    public String getLast() { return this.last; }
    public String getMiddle() { return this.middle; }
    public String getFirst() { return this.first; }
    public String getEmail() { return this.email; }
    public String getCourse() { return this.course; }

    public void getData() {
        for (ArrayList<String> strings : table) {
            for (String string : strings) {
                System.out.print(string + " |\t");
            }
            System.out.println();
        }
    }
}
