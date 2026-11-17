package model;

import java.sql.*;
import java.util.ArrayList;

public class StudentDataAccess {

    public ArrayList<Student> getAllStudent() {
        ArrayList<Student> studentList = new ArrayList<>();
        String query = "SELECT * FROM students";

        try (Connection connection = DatabaseConnection.getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {
            if (connection == null) { return studentList; }

            while (resultSet.next()) {
                studentList.add(new Student(
                        resultSet.getString("student_id"),
                        resultSet.getString("lastName"),
                        resultSet.getString("firstName"),
                        resultSet.getString("middleName"),
                        resultSet.getString("course"),
                        resultSet.getString("email")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }

    public void insertStudent(Student student) {
        String query = "INSERT INTO students (student_id, lastName, firstName, middleName, course, email) VALUES (?,?,?,?,?,?)";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement prepStatement = connection.prepareStatement(query)) {
            prepStatement.setString(1, student.getStudentID());
            prepStatement.setString(2, student.getLast());
            prepStatement.setString(3, student.getFirst());
            prepStatement.setString(4, student.getMiddle());
            prepStatement.setString(5, student.getCourse());
            prepStatement.setString(6, student.getEmail());
            prepStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
