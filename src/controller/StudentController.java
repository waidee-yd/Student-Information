package controller;

import model.Handler;
import model.Student;

import java.time.Year;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class StudentController extends Student {

    Scanner input = new Scanner(System.in);

    @Override
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

    public void getData() {
        for (ArrayList<String> strings : table) {
            for (String string : strings) {
                System.out.print(string + " |\t");
            }
            System.out.println();
        }
    }

}
