package controller;

import model.Student;
import view.consoleApp.MainMenu;

import java.util.ArrayList;

public class SearchControl extends Student{

    public void searching(String search) {

        MainMenu menu = new MainMenu();

        if (search.equals("0")) {
            menu.start();
        }

        String lowerString = search.toLowerCase();
        boolean found = false;

        for (ArrayList<String> strings : table) {
            String id = strings.get(0);
            String lastname = strings.get(1);
            String middlename = strings.get(2);
            String firstname = strings.get(3);

            if (id.contains(search) || lastname.equalsIgnoreCase(lowerString) || middlename.equalsIgnoreCase(lowerString) || firstname.equalsIgnoreCase(lowerString)) {
                System.out.println("Match Found: " + strings);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No Records Found!");
        }
    }
}
