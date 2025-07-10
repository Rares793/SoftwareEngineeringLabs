package isp.lab6.exercise1;

import isp.lab6.exercise2.Vehicle;

import java.util.HashMap;
import java.util.Objects;

public class Student {
    private final String studentName;
    final private int studentId;
    private final HashMap<String,Integer> subjects;

    public String getStudentName() {
        return studentName;
    }

    public int getStudentId() {
        return studentId;
    }

    public Student(String studentName, int studentId) {
        this.studentName = studentName;
        this.studentId = studentId;
        this.subjects = new HashMap<>();
    }
    public void addGrade(String subject, int grade){
        subjects.put(subject, grade);
    }
    public void removeGrade(String subject, int grade){
        subjects.remove(subject,grade);
    }
    int sum = 0;
    public double AverageGrade(){
        if(subjects.isEmpty()){
            return 0.0;
        }
        int sum = 0;
        for(int grade: subjects.values()){
            sum += grade;
        }
        return (double) sum / subjects.size();
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentName='" + studentName + '\'' +
                ", studentId=" + studentId +
                ", subjects=" + subjects +
                ", sum=" + AverageGrade() +
                '}';
    }
}
