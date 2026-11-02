package controller;

import java.util.Scanner;

public class counterHandler{
    public static int method = 1;

    Scanner input = new Scanner(System.in);

    public void init() {
        display();
        int choice = userInput();
        exe(choice);
    }

    private void display() {
        System.out.println("==Change Method==");
        System.out.println("1. Standard Counter");
        System.out.println("2. Regular Expression Counter");
        System.out.println("0. Back");
        System.out.print("Enter your choice: ");
    }

    private void exe(int choice) {
        switch (choice) {
            case 0:
                break;
            case 1:
                method = 1;
                break;
            case 2:
                method = 2;
                break;
            default:
                System.out.println("Invalid Choice!");
                break;
        }
    }

    private int userInput() {
        while (!input.hasNextInt()) {
            System.out.println("Invalid Input! Enter a number.");
            input.next();
            display();
        }
        return input.nextInt();
    }

}
