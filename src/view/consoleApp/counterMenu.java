package view.consoleApp;

import java.util.Scanner;

import model.Handler;

public class counterMenu {

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
                Handler.method = 1;
                break;
            case 2:
                Handler.method = 2;
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
