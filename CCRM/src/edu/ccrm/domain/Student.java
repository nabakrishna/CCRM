package edu.ccrm.domain;

import java.util.*;
import java.time.LocalDate;

public class Student extends Person {
    private String regNo;
    private List<String> enrolledCourses;
    private Map<String, Grade> courseGrades;
    private int maxCreditsPerSemester = 24;

    public Student(String id, String regNo, String fullName, String email) {
        super(id, fullName, email);
        this.regNo = regNo;
        this.enrolledCourses = new ArrayList<>();
        this.courseGrades = new HashMap<>();
    }

    @Override
    public String getRole() {
        return "Student";
    }

    @Override
    public void displayProfile() {
        System.out.println("=== Student Profile ===");
        System.out.println("Registration No: " + regNo);
        System.out.println(toString());
        System.out.println("Enrolled Courses: " + enrolledCourses.size());
        System.out.println("GPA: " + calculateGPA());
    }

    public double calculateGPA() {
        if (courseGrades.isEmpty()) return 0.0;

        double totalPoints = courseGrades.values().stream()
                .mapToDouble(Grade::getGradePoint)
                .sum();
        return totalPoints / courseGrades.size();
    }

    // Getters and setters
    public String getRegNo() { return regNo; }
    public void setRegNo(String regNo) { this.regNo = regNo; }

    public List<String> getEnrolledCourses() { return enrolledCourses; }
    public void setEnrolledCourses(List<String> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    public Map<String, Grade> getCourseGrades() { return courseGrades; }
    public void setCourseGrades(Map<String, Grade> courseGrades) {
        this.courseGrades = courseGrades;
    }

    public int getMaxCreditsPerSemester() { return maxCreditsPerSemester; }
    public void setMaxCreditsPerSemester(int maxCreditsPerSemester) {
        this.maxCreditsPerSemester = maxCreditsPerSemester;
    }
}