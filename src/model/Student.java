package model;

import java.time.Year;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {

    Scanner input = new Scanner(System.in);

    public static int idCounter = 1;
    public static ArrayList<ArrayList<String>> table = new ArrayList<>();

    protected String last;
    protected String middle;
    protected String first;

    protected String studentID;


    public Student() {

    }

    public void setID(int method) {
        if (method == 1) {
            Year currYear = Year.now();
            this.studentID = currYear + "-" +String.format("%05d",idCounter) + "-MN-0";
            idCounter++;
        } else {
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

    public void setData() {
        ArrayList<String> row = new ArrayList<>();

        System.out.print("Enter Last Name: ");
        this.setLast(input.nextLine());

        System.out.print("Enter Middle Name: ");
        this.setMiddle(input.nextLine());

        System.out.print("Enter First Name: ");
        this.setFirst(input.nextLine());

        setID(Handler.method);

        row.add(getID());
        row.add(this.last);
        row.add(this.middle);
        row.add(this.first);

        table.add(row);

        System.out.println("Student record successfully saved to table!");

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

    public void getData() {
        for (ArrayList<String> strings : table) {
            for (String string : strings) {
                System.out.print(string + " |\t");
            }
            System.out.println();
        }
    }
}
