package view.consoleApp;

import controller.searchControl;

import model.Console;

import java.util.Scanner;

public class searchMenu extends Console {

    Scanner scanner = new Scanner(System.in);

    searchControl control = new searchControl();

    public searchMenu() {

    }

    @Override
    public void start() {
        display();
        String search = searchInput();
        control.searching(search);
    }

    @Override
    protected void display() {
        System.out.println("\t==Search==");
        System.out.println("<- Back: 0");
        System.out.print("Enter Name or ID: ");
    }

    protected String searchInput() {
        String string = scanner.nextLine().trim();
        while (string.isEmpty()) {
            System.out.println("Invalid Input!");
            display();
        }
        return string;
    }
}
