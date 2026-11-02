package view.consoleApp;

import model.Handler;
import model.Console;

public class counterMenu extends Console {

    @Override
    public void start() {
        display();
        int choice = userInput();
        exe(choice);
    }

    protected void display() {
        System.out.println("==Change Method==");
        System.out.println("1. Standard Counter");
        System.out.println("2. Regular Expression Counter");
        System.out.println("0. Back");
        System.out.print("Enter your choice: ");
    }

    protected void exe(int choice) {
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

}
