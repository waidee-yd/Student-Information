package model;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class Table {

    public static DefaultTableModel createModel() {
        String[] column = {"Student ID", "Last Name", "First Name", "Middle Name", "Course", "Email"};

        int size = Student.table.size();
        Object[][] data = new Object[size][6];

        for (int i = 0; i < size; i++) {
            ArrayList<String> row = Student.table.get(i);

            data[i][0] = row.get(0);
            data[i][1] = row.get(1);
            data[i][2] = row.get(2);
            data[i][3] = row.get(3);
            data[i][4] = row.get(4);
            data[i][5] = row.get(5);
        }

        return new DefaultTableModel(data, column);
    }
}
