package edu.ccrm.cli;

import edu.ccrm.config.AppConfig;
import edu.ccrm.domain.*;
import edu.ccrm.service.*;
import java.util.Scanner;

public class CCRMApplication {
    private StudentService studentService;
    private Scanner scanner;
    private AppConfig config;

    public CCRMApplication() {
        config = AppConfig.getInstance();
        studentService = new StudentService();
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("=== Campus Course & Records Manager (CCRM) ===");
        System.out.println("Platform: Java SE - Standard Edition for desktop applications");

        boolean running = true;
        while (running) {
            displayMainMenu();
            int choice = getChoice();

            switch (choice) {
                case 1:
                    manageStudents();
                    break;
                case 2:
                    manageCourses();
                    break;
                case 3:
                    manageEnrollments();
                    break;
                case 4:
                    manageGrades();
                    break;
                case 5:
                    importExportData();
                    break;
                case 6:
                    showReports();
                    break;
                case 7:
                    backupData();
                    break;
                case 0:
                    running = false;
                    System.out.println("Thank you for using CCRM!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private void displayMainMenu() {
        System.out.println("\n=== Main Menu ===");
        System.out.println("1. Manage Students");
        System.out.println("2. Manage Courses");
        System.out.println("3. Manage Enrollments");
        System.out.println("4. Manage Grades");
        System.out.println("5. Import/Export Data");
        System.out.println("6. Reports");
        System.out.println("7. Backup Data");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private int getChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void manageStudents() {
        System.out.println("\n=== Student Management ===");
        System.out.println("1. Add Student");
        System.out.println("2. List Students");
        System.out.println("3. Update Student");
        System.out.println("4. Deactivate Student");
        System.out.println("5. View Student Profile");
        System.out.print("Enter your choice: ");

        int choice = getChoice();

        switch (choice) {
            case 1:
                addStudent();
                break;
            case 2:
                listStudents();
                break;
            case 3:
                updateStudent();
                break;
            case 4:
                deactivateStudent();
                break;
            case 5:
                viewStudentProfile();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private void addStudent() {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Registration Number: ");
        String regNo = scanner.nextLine();
        System.out.print("Enter Full Name: ");
        String fullName = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        try {
            Student student = new Student(id, regNo, fullName, email);
            studentService.addStudent(student);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void listStudents() {
        System.out.println("\n=== All Students ===");
        studentService.getAllStudents().forEach(student -> {
            System.out.println(student.toString());
        });
    }

    private void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        String id = scanner.nextLine();

        Student existingStudent = studentService.getStudentById(id);
        if (existingStudent == null) {
            System.out.println("Student not found with ID: " + id);
            return;
        }

        System.out.print("Enter new Full Name (current: " + existingStudent.getFullName() + "): ");
        String fullName = scanner.nextLine();
        System.out.print("Enter new Email (current: " + existingStudent.getEmail() + "): ");
        String email = scanner.nextLine();

        if (!fullName.trim().isEmpty()) {
            existingStudent.setFullName(fullName);
        }
        if (!email.trim().isEmpty()) {
            existingStudent.setEmail(email);
        }

        studentService.updateStudent(id, existingStudent);
    }

    private void deactivateStudent() {
        System.out.print("Enter Student ID to deactivate: ");
        String id = scanner.nextLine();
        studentService.deactivateStudent(id);
    }

    private void viewStudentProfile() {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();

        Student student = studentService.getStudentById(id);
        if (student != null) {
            student.displayProfile();
        } else {
            System.out.println("Student not found with ID: " + id);
        }
    }

    // Placeholder methods for other functionalities
    private void manageCourses() {
        System.out.println("Course management functionality - To be implemented");
    }

    private void manageEnrollments() {
        System.out.println("Enrollment management functionality - To be implemented");
    }

    private void manageGrades() {
        System.out.println("Grade management functionality - To be implemented");
    }

    private void importExportData() {
        System.out.println("Import/Export functionality - To be implemented");
    }

    private void showReports() {
        StudentService.StudentStats stats = studentService.getStudentStatistics();
        System.out.println("\n=== Student Statistics ===");
        System.out.println("Total Students: " + stats.getTotalStudents());
        System.out.println("Active Students: " + stats.getActiveStudents());
        System.out.printf("Average GPA: %.2f%n", stats.getAverageGPA());
    }

    private void backupData() {
        System.out.println("Backup functionality - To be implemented");
    }

    public static void main(String[] args) {
        new CCRMApplication().start();
    }
}