package model;

import view.consoleApp.MainMenu;

import java.util.ArrayList;

public class Search extends Student{

    public void searching(String search) {

        MainMenu menu = new MainMenu();

        if (search.equals("0")) {
            menu.start();
        }

        String lowerString = search.toLowerCase();
        boolean found = false;

        for (ArrayList<String> strings : table) {
            String id = strings.get(0);
            String lastname = strings.get(1).toLowerCase();
            String middlename = strings.get(2).toLowerCase();
            String firstname = strings.get(3).toLowerCase();

            if (id.contains(search) || lastname.contains(lowerString) || middlename.contains(lowerString) || firstname.contains(lowerString)) {
                System.out.println("Match Found: " + strings);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No Records Found!");
        }
    }
}
