package controller;

import model.Student;
import model.StudentDataAccess;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class Search {

    private final StudentDataAccess access = new StudentDataAccess();
    private static final List<Student> matches = new ArrayList<>();

    public List<Student> getMatches() {
        return matches;
    }

    //Searching Algorithm
    public void searching(String search) {
        matches.clear();

        ArrayList<Student> students = access.getAllStudent();

        String query = search == null ? "" : search.trim().toLowerCase();

        for (Student s : students) {
            String id = s.getStudentID() != null ? s.getStudentID().toLowerCase() : "";
            String lastName = s.getLast() != null ? s.getLast().toLowerCase() : "";
            String middleName = s.getMiddle() != null ? s.getMiddle().toLowerCase() : "";
            String firstName = s.getFirst() != null ? s.getFirst().toLowerCase() : "";

            if (query.isEmpty() || id.contains(query) || lastName.contains(query) || middleName.contains(query) || firstName.contains(query)) {
                matches.add(s);
            }
        }

        if (matches.isEmpty()) {
            System.out.println("No Records Found!");
        } else {
            System.out.println("Matches Found: " + matches.size());
        }
    }

    public static DefaultTableModel searchModel() {
        String[] columns = {"Student ID", "Last Name", "First Name", "Middle Name", "Course", "Email"};
        Object[][] rows = new Object[matches.size()][6];

        for (int i = 0; i < matches.size(); i++) {
            Student s = matches.get(i);
            rows[i][0] = s.getStudentID();
            rows[i][1] = s.getLast();
            rows[i][2] = s.getFirst();
            rows[i][3] = s.getMiddle();
            rows[i][4] = s.getCourse();
            rows[i][5] = s.getEmail();
        }

        return new DefaultTableModel(rows,columns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
    }
}
