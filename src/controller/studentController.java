package controller;

import model.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class studentController extends Student {

    ArrayList<ArrayList<String>> table = new ArrayList<>();

    Scanner input = new Scanner(System.in);

    public void setData() {
        ArrayList<String> row = new ArrayList<>();

        System.out.print("Enter Last Name: ");
        this.setLast(input.nextLine());

        System.out.print("Enter Middle Name: ");
        this.setMiddle(input.nextLine());

        System.out.print("Enter First Name: ");
        this.setFirst(input.nextLine());

        setID();

        row.add(this.last);
        row.add(this.middle);
        row.add(this.first);
        row.add(getID());

        table.add(row);

        System.out.println("Student record sucessfullly saved to table!");

    }

    public void getData() {
        for (int i = 0; i < table.size(); i++) {
            for (int j = 0; j < table.get(i).size(); j++) {
                System.out.print(table.get(i).get(j) + "\t");
            }
            System.out.println();
        }
    }

}
