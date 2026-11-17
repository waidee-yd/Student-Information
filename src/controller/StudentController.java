package controller;

import model.Handler;
import model.Student;
import model.StudentDataAccess;
import view.UIHandler.TableHandler;

public class StudentController {

    public StudentController() {

    }

    public void setData(String last, String first, String middle, String course, String email) {
        Student student = new Student();
        TableHandler th = new TableHandler();

        student.generateID(Handler.method);
        student.setLast(last);
        student.setFirst(first);
        student.setMiddle(middle);
        student.setCourse(course);
        student.setEmail(email);

        StudentDataAccess dataAccess = new StudentDataAccess();
        dataAccess.insertStudent(student);
        th.RefreshTable();

    }

}
