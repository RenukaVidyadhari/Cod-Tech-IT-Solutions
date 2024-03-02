import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int rollNumber;
    private double marks1, marks2, marks3;
    private double percentage;
    private char grade;

    public Student(String name, int rollNumber, double marks1, double marks2, double marks3) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks1 = marks1;
        this.marks2 = marks2;
        this.marks3 = marks3;
        calculatePercentage();
        calculateGrade();
    }

    private void calculatePercentage() {
        percentage = (marks1 + marks2 + marks3) / 3.0;
    }

    private void calculateGrade() {
        if (percentage >= 90) {
            grade = 'A';
        } else if (percentage >= 80) {
            grade = 'B';
        } else if (percentage >= 70) {
            grade = 'C';
        } else if (percentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }
    }

    public void displayStudentDetails() {
        System.out.println("Student Details:");
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks 1: " + marks1);
        System.out.println("Marks 2: " + marks2);
        System.out.println("Marks 3: " + marks3);
        System.out.println("Percentage: " + percentage + "%");
        System.out.println("Grade: " + grade);
        System.out.println("-------------------------");
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void updateStudentDetails(double newMarks1, double newMarks2, double newMarks3) {
        this.marks1 = newMarks1;
        this.marks2 = newMarks2;
        this.marks3 = newMarks3;
        calculatePercentage();
        calculateGrade();
    }
}

class GradeManagementSystem {
    private ArrayList<Student> studentList;

    public GradeManagementSystem() {
        studentList = new ArrayList<>();
    }

    public void addStudent(Student student) {
        studentList.add(student);
        System.out.println("Student added successfully!");
    }

    public void updateStudent(int rollNumber, double marks1, double marks2, double marks3) {
        for (Student student : studentList) {
            if (student.getRollNumber() == rollNumber) {
                student.updateStudentDetails(marks1, marks2, marks3);
                System.out.println("Student details updated successfully!");
                return;
            }
        }
        System.out.println("Student not found with Roll Number: " + rollNumber);
    }

    public void deleteStudent(int rollNumber) {
        for (Student student : studentList) {
            if (student.getRollNumber() == rollNumber) {
                studentList.remove(student);
                System.out.println("Student deleted successfully!");
                return;
            }
        }
        System.out.println("Student not found with Roll Number: " + rollNumber);
    }

    public void displayAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students in the system.");
        } else {
            for (Student student : studentList) {
                student.displayStudentDetails();
            }
        }
    }
}

public class StudentGradeManagementSystem {
    public static void main(String[] args) {
        GradeManagementSystem gradeManagementSystem = new GradeManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Student Grade Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter roll number: ");
                    int rollNumber = scanner.nextInt();
                    System.out.print("Enter marks for Subject 1: ");
                    double marks1 = scanner.nextDouble();
                    System.out.print("Enter marks for Subject 2: ");
                    double marks2 = scanner.nextDouble();
                    System.out.print("Enter marks for Subject 3: ");
                    double marks3 = scanner.nextDouble();

                    Student newStudent = new Student(name, rollNumber, marks1, marks2, marks3);
                    gradeManagementSystem.addStudent(newStudent);
                    break;
                case 2:
                    System.out.print("Enter roll number to update student details: ");
                    int updateRollNumber = scanner.nextInt();
                    System.out.print("Enter new marks for Subject 1: ");
                    double newMarks1 = scanner.nextDouble();
                    System.out.print("Enter new marks for Subject 2: ");
                    double newMarks2 = scanner.nextDouble();
                    System.out.print("Enter new marks for Subject 3: ");
                    double newMarks3 = scanner.nextDouble();

                    gradeManagementSystem.updateStudent(updateRollNumber, newMarks1, newMarks2, newMarks3);
                    break;
                case 3:
                    System.out.print("Enter roll number to delete student: ");
                    int deleteRollNumber = scanner.nextInt();
                    gradeManagementSystem.deleteStudent(deleteRollNumber);
                    break;
                case 4:
                    gradeManagementSystem.displayAllStudents();
                    break;
                case 5:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
