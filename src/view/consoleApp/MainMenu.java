package view.consoleApp;

import controller.StudentController;
import model.Handler;
import controller.ConsoleController;

public class MainMenu extends ConsoleController {

    SearchMenu search = new SearchMenu();
    CounterMenu counter = new CounterMenu();
    StudentController controller = new StudentController();

    public MainMenu() {

    }

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
                search.start();
                break;
            case 4:
                counter.start();
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
