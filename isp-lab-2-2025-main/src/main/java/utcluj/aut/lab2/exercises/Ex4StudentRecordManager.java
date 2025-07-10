package utcluj.aut.lab2.exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Application that manages student records using only Strings and arrays.
 * The program allows users to input student records, filter them by grade,
 * and sort them by different criteria.
 * Students should implement all methods to complete the exercise.
 */
public class Ex4StudentRecordManager {

    /**
     * Main method that runs the application.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int studentsNumber = 0;
        List<String> records = new ArrayList<>();
        while(true) {
            System.out.println("Enter the student '" + studentsNumber + "' - name, age, grade: (or 'DONE' if you want to finish): ");
            String record = scanner.nextLine();
            if(record.equals("DONE")) {
                break;
            }
            records.add(record);
            studentsNumber++;
        }
        String[][] recordsArray = new String[studentsNumber][3];
        for(int i = 0; i < studentsNumber; i++) {
            recordsArray[i] = parseStudentRecord(records.get(i));
        }
        String[] userOptions = getFilterAndSortOptions();
        System.out.println("Do you want to filter the records? (Y/N)");
        while(true) {
            String filter = scanner.nextLine();
            if(filter.equals("Y")) {
                filterByGrade(recordsArray, userOptions[0]);
                break;
            } else if(filter.equals("N")) {
                break;
            } else {
                System.out.println("Invalid option, try again! (Y/N)");
            }
        }
        System.out.println("Do you want to sort the records? (Y/N)");
        while(true) {
            String filter = scanner.nextLine();
            if(filter.equals("Y")) {
                recordsArray = sortRecords(recordsArray, userOptions[1], userOptions[2].equalsIgnoreCase("ascending"));
                break;
            } else if(filter.equals("N")) {
                break;
            } else {
                System.out.println("Invalid option, try again! (Y/N)");
            }
        }
        System.out.println("The final array is: ");
        displayRecords(recordsArray);
    }

    /**
     * Parses a student record from a string in the format "name,age,grade".
     *
     * @param record the record string to parse
     * @return a string array with [name, age, grade] or null if invalid format
     */
    public static String[] parseStudentRecord(String record) {
        if(record == null) {
            throw new IllegalArgumentException("Empty record!");
        }
        String[] parts = record.split(",");
        if(parts.length != 3) {
            throw new IllegalArgumentException("Invalid record format. Record format should be: name,age,grade (3 inputs)");
        }
        for(int i = 0; i < parts.length; i++) {
            parts[i] = parts[i].trim();
        }
        if(!isInteger(parts[2])) {
            throw new IllegalArgumentException("Student grade is NOT an integer!");
        }
        return parts;
    }

    /**
     * Filters student records by a minimum grade threshold.
     *
     * @param records array of student records, each record is [name, age, grade]
     * @param minGrade the minimum grade threshold as a string
     * @return array of filtered student records
     */
    public static String[][] filterByGrade(String[][] records, String minGrade) {
        int grade, counter = 0;
        try {
            grade = Integer.parseInt(minGrade);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("Grade is not an integer!");
        }
        for (String[] record : records) {
            int studentGrade = Integer.parseInt(record[2]);
            if (studentGrade >= grade)
                counter++;
        }
        String[][] filteredRecords = new String[counter][3];
        for(int i = 0; i < counter; i++) {
            int studentGrade = Integer.parseInt(records[i][2]);
            if(studentGrade >= grade) {
                filteredRecords[i][0] = records[i][0];
                filteredRecords[i][1] = records[i][1];
                filteredRecords[i][2] = records[i][2];
            }
        }
        return filteredRecords;
    }

    public static void stringsBubbleSort(String[][] array, int sortBy, boolean ascending) {
        int arrayLength = array.length;
        boolean swapped;
        for (int i = 0; i < arrayLength - 1; i++) {
            swapped = false;
            for (int j = 0; j < arrayLength - 1 - i; j++) {
                if ((ascending && array[j][sortBy].compareTo(array[j + 1][sortBy]) > 0) || (!ascending && array[j][sortBy].compareTo(array[j + 1][sortBy]) < 0)) {
                    String[] temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }
    }

    /**
     * Sorts student records by the given criteria.
     *
     * @param records array of student records, each record is [name, age, grade]
     * @param sortBy the sorting criteria ("name", "age", or "grade")
     * @param ascending true for ascending order, false for descending
     * @return a new array with sorted student records
     */
    public static String[][] sortRecords(String[][] records, String sortBy, boolean ascending) {
        String[][] sortedRecords = new String[records.length][3];
        for(int i = 0; i < records.length; i++) {
            sortedRecords[i][0] = records[i][0];
            sortedRecords[i][1] = records[i][1];
            sortedRecords[i][2] = records[i][2];
        }
        switch (sortBy) {
            case "name" -> stringsBubbleSort(sortedRecords, 0, ascending);
            case "age" -> stringsBubbleSort(sortedRecords, 1, ascending);
            case "grade" -> stringsBubbleSort(sortedRecords, 2, ascending);
            default -> throw new IllegalArgumentException("Invalid sort by! Sort by should be: name, age or grade");
        }
        return sortedRecords;
    }

    /**
     * Displays student records in a formatted way.
     *
     * @param records array of student records to display
     */
    public static void displayRecords(String[][] records) {
        if(records == null) {
            throw new IllegalArgumentException("Empty records!");
        }
        System.out.println();
        for(String[] record : records) {
            System.out.println("Name: " + record[0] + ", Age: " + record[1] + ", Grade: " + record[2]);
        }
    }

    /**
     * Prompts for and reads user input for filtering and sorting options.
     *
     * @return a string array with [minGrade, sortBy, ascending]
     */
    public static String[] getFilterAndSortOptions() {
        Scanner scanner = new Scanner(System.in);
        String[] options = new String[3];
        System.out.println("Enter the minimum grade threshold: ");
        options[0] = scanner.next();
        System.out.println("Enter the sorting criteria (name, age, grade): ");
        options[1] = scanner.next();
        System.out.println("Enter the sorting order (ascending, descending): ");
        options[2] = scanner.next();
        scanner.close();
        return options;
    }

    /**
     * Checks if a string can be parsed as an integer.
     *
     * @param str the string to check
     * @return true if the string is a valid integer, false otherwise
     */
    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }
}