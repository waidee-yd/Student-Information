package controller;

import model.Student;
import model.StudentDataAccess;
import view.UIHandler.TableHandler;

public class StudentController {

    private TableHandler tableHandler;

    public StudentController(TableHandler tableHandlers) {
        this.tableHandler = tableHandlers;
    }

    public StudentController() {

    }

    public void setData(String last, String first, String middle, String course, String email) {
        Student student = new Student();

        student.generateID(CounterController.getMethod());
        student.setLast(last);
        student.setFirst(first);
        student.setMiddle(middle);
        student.setCourse(course);
        student.setEmail(email);

        StudentDataAccess dataAccess = new StudentDataAccess();
        dataAccess.insertStudent(student);

        if (this.tableHandler != null) {
            this.tableHandler.RefreshTable();
        }
    }

}
