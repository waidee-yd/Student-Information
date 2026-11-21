package controller;

import model.Student;
import model.StudentDataAccess;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class TableController {

    public static DefaultTableModel createModel() {
        String[] column = {"Student ID", "Last Name", "First Name", "Middle Name", "Course", "Email"};

        StudentDataAccess dataAccess = new StudentDataAccess();
        ArrayList<Student> studentsFromDb = dataAccess.getAllStudent();

        int size = studentsFromDb.size();
        Object[][] data = new Object[size][6];

        for (int i = 0; i < size; i++) {
            Student row = studentsFromDb.get(i);

            data[i][0] = row.getStudentID();
            data[i][1] = row.getLast();
            data[i][2] = row.getFirst();
            data[i][3] = row.getMiddle();
            data[i][4] = row.getCourse();
            data[i][5] = row.getEmail();
        }

        return new DefaultTableModel(data, column) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
    }
}
