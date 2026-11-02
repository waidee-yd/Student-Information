package controller;

import model.Student;

import java.util.ArrayList;

public class searchControl extends Student{

    public void searching(String search) {
        String lowerString = search.toLowerCase();
        boolean found = false;

        for (ArrayList<String> strings : table) {
            String id = strings.get(0);
            String lastname = strings.get(1);
            String middlename = strings.get(2);
            String firstname = strings.get(3);

            if (id.equalsIgnoreCase(search) || lastname.equalsIgnoreCase(lowerString) || middlename.equalsIgnoreCase(lowerString) || firstname.equalsIgnoreCase(lowerString)) {
                System.out.println("Match Found: " + strings);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No Records Found!");
        }
    }
}
