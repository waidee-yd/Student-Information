package view.consoleApp.module;

import java.util.Scanner;

abstract class Start implements Display, Execution{

    Scanner input = new Scanner(System.in);
    boolean running = true;

    public void start() {
        while (running) {
            display();
            int choice = userInput();
            exe(choice);
        }
        input.close();
    }

    public int userInput() {
        while (!input.hasNextInt()) {
            System.out.println("Invalid Input! Enter a number.");
            input.next();
            display();
        }
        return input.nextInt();
    }


}
