package view.consoleApp;

import controller.SearchControl;

import model.Console;

import java.util.Scanner;

public class SearchMenu extends Console {

    Scanner scanner = new Scanner(System.in);

    SearchControl control = new SearchControl();

    public SearchMenu() {

    }

    @Override
    public void start() {
        display();
        String search = searchInput();

        if (search.equals("0")) {

        }

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
