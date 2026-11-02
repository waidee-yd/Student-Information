package view.consoleApp.module;

import java.util.Scanner;

public abstract class console implements Display, Execution{

    protected Scanner input = new Scanner(System.in);
    protected boolean running = true;

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
