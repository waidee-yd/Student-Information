package controller;

import java.util.Scanner;

public abstract class ConsoleController {

    protected Scanner input = new Scanner(System.in);
    protected boolean running = true;

    protected void display() {

    }

    protected void exe(int a) {

    }

    public void start() {
        while (running) {
            display();
            int choice = userInput();
            exe(choice);
        }
        input.close();
    }

    protected int userInput() {
        while (!input.hasNextInt()) {
            System.out.println("Invalid Input! Enter a number.");
            input.next();
            display();
        }
        return input.nextInt();
    }


}
