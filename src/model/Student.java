package model;

import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {

    StudentDataAccess studentDataAccess = new StudentDataAccess();

    //Data Variable
    protected String studentID;
    protected String last;
    protected String first;
    protected String middle;
    protected String course;
    protected String email;

    public String[] courseList = {
            "-- Select Course --",
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
        Arrays.sort(courseList);
    }

    public Student(String id, String lname, String fname, String mname, String cour, String em) {
            this.studentID = id;
            this.last = lname;
            this.first = fname;
            this.middle = mname;
            this.course = cour;
            this.email = em;
            Arrays.sort(courseList);
    }

    //Setters

    public void setLast(String lastName) {
        this.last = lastName;
    }
    public void setFirst(String firstName) {
        this.first = firstName;
    }
    public void setMiddle(String middleName) {
        this.middle = middleName;
    }
    public void setCourse(String studentCourse) { this.course = studentCourse; }
    public void setEmail(String studentEmail) { this.email = studentEmail; }

    public void generateID(int method) {
        StudentDataAccess dataAccess = new StudentDataAccess();
        ArrayList<Student> studentsList = dataAccess.getAllStudent();

        Student lastStudent = studentsList.getLast();
        String lastID = lastStudent.getStudentID();

        Year currYear = Year.now();

        int idCounter = 1;

        if (method == 1) {
            //Standard method of counter
            if (studentDataAccess.getAllStudent().isEmpty()) {
                System.out.println("Empty!");
                this.studentID = currYear + "-" + String.format("%05d",idCounter) + "-MN-0";
            } else {
                String numPart = lastID.substring(5,10); //2026-00001-MN-0
                idCounter = Integer.parseInt(numPart) + 1;
                this.studentID = currYear + "-" + String.format("%05d",idCounter) + "-MN-0";
                idCounter++;
            }

        } else {
            //Regular expression method of counter
            if (studentDataAccess.getAllStudent().isEmpty()) {
                this.studentID = currYear + "-00001-MN-0";
            } else {

                Pattern pattern = Pattern.compile("^\\d{4}\\s*-\\s*(\\d{5})");
                Matcher matcher = pattern.matcher(lastID);

                if (matcher.find()) {
                    String counterPart = matcher.group(1);
                    idCounter = Integer.parseInt(counterPart) + 1;
                }

                this.studentID = currYear + "-" + String.format("%05d", idCounter) + "-MN-0";
                idCounter++;
            }
        }

    }

    //Getters

    public String getStudentID() { return this.studentID; }
    public String getLast() { return this.last; }
    public String getMiddle() { return this.middle; }
    public String getFirst() { return this.first; }
    public String getCourse() { return this.course; }
    public String getEmail() { return this.email; }
}
