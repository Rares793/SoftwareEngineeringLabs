package isp.lab6.exercise1;

import isp.lab6.exercise2.Vehicle;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class GradeManagementSystem {
    final private HashSet<Student> students;

    public GradeManagementSystem() {
        students = new HashSet<>();
    }

    public HashSet<Student> getStudents() {
        return students;
    }
    public void addStudent(Student student) { students.add(student) ; }
    public void removeStudent(Student student) { students.remove(student); }
    public void updateStudent(Student student, String newName, int newId) {

    }

}
