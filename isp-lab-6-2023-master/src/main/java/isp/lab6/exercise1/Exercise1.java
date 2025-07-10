package isp.lab6.exercise1;

import java.util.HashMap;
import java.util.HashSet;

public class Exercise1 {
    public static void main(String[] args) {
        HashSet<Student> list = new HashSet<>();
        Student s1 = new Student("John",001);
        Student s2 = new Student("Micle",002);
        s1.addGrade("OOP", 10);
        s1.addGrade("Math", 9);
        s2.addGrade("Data Transmission",8);
        s2.addGrade("Data Bases",3);
        list.add(s1);
        list.add(s2);

        System.out.println(s1);
        System.out.println("");
        System.out.println(list);

    }
}
