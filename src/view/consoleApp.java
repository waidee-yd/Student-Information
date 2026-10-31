package view;

import java.util.Scanner;
import controller.studentController;

public class consoleApp {

    Scanner input = new Scanner(System.in);
    boolean running = true;

    studentController controller = new studentController();

    public void start() {
        while (running) {
            display();
            int choice = userInput();
            exe(choice);
        }
        input.close();
    }

    private void display() {
        System.out.println("\t== Student Information ==");
        System.out.println("1. Input Record");
        System.out.println("2. View Record");
        System.out.println("3. Search Record");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");

    }

    private int userInput() {
        while (!input.hasNextInt()) {
            System.out.println("Invalid Input! Enter a number.");
            input.next();
            display();
        }
        return input.nextInt();
    }

    private void exe(int choice) {
        switch (choice) {
            case 1:
                controller.setData();
                break;
            case 2:
                controller.getData();
                break;
            case 3:
                break;
            case 4:
                System.out.println("Exiting Program...");
                this.running = false;
                break;
            default:
                System.out.println("Invalid Choice! Please Choose Between 1-4.");
        }
    }

}
