package view.consoleApp;

import controller.studentController;
import model.Handler;
import model.Console;

public class mainMenu extends Console {

    counterMenu counterControl = new counterMenu();
    studentController controller = new studentController();

    public void display() {
        System.out.println("\t== Student Information ==");
        System.out.println("1. Input Record");
        System.out.println("2. View Record");
        System.out.println("3. Search Record");
        if (Handler.method == 1) {
            System.out.println("4. Change Standard Method? (Standard by DEFAULT)");
        } else {
            System.out.println("4. Change Regular Expression Method? (Standard by DEFAULT)");
        }
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");

    }

    public void exe(int choice) {
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
                counterControl.start();
                break;
            case 5:
                System.out.println("Exiting Program...");
                this.running = false;
                break;
            default:
                System.out.println("Invalid Choice! Please Choose Between 1-5.");
        }
    }

}
