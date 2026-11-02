package view.consoleApp;

import model.Console;

import java.util.Scanner;

public class searchMenu extends Console {

    Scanner scanner = new Scanner(System.in);

    public searchMenu() {

    }

    @Override
    public void start() {
        display();
        String search = searchInput();
    }

    @Override
    protected void display() {
        System.out.println("\t==Search==");
        System.out.println("<- Back: 0");
        System.out.print("Enter Name or ID: ");
    }

    protected String searchInput() {
        String string = scanner.nextLine().trim();
        scanner.nextLine();
        while (!scanner.hasNextLine()) {
            System.out.println("Invalid Input!");
            display();
        }
        return string;
    }
}
