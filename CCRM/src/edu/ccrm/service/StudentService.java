package edu.ccrm.service;

import edu.ccrm.domain.*;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.io.IOException;

public class StudentService implements Persistable, Searchable<Student> {
    private Map<String, Student> students;

    // Static nested class for statistics
    public static class StudentStats {
        private int totalStudents;
        private double averageGPA;
        private int activeStudents;

        public StudentStats(int totalStudents, double averageGPA, int activeStudents) {
            this.totalStudents = totalStudents;
            this.averageGPA = averageGPA;
            this.activeStudents = activeStudents;
        }

        // Getters
        public int getTotalStudents() { return totalStudents; }
        public double getAverageGPA() { return averageGPA; }
        public int getActiveStudents() { return activeStudents; }
    }

    public StudentService() {
        this.students = new HashMap<>();
    }

    public void addStudent(Student student) throws IllegalArgumentException {
        if (students.containsKey(student.getId())) {
            throw new IllegalArgumentException("Student with ID " + student.getId() + " already exists");
        }
        students.put(student.getId(), student);
        System.out.println("Student added successfully: " + student.getFullName());
    }

    public Student getStudentById(String id) {
        return students.get(id);
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students.values());
    }

    public void updateStudent(String id, Student updatedStudent) {
        if (students.containsKey(id)) {
            students.put(id, updatedStudent);
            System.out.println("Student updated successfully");
        } else {
            System.out.println("Student not found with ID: " + id);
        }
    }

    public void deactivateStudent(String id) {
        Student student = students.get(id);
        if (student != null) {
            student.setActive(false);
            System.out.println("Student deactivated: " + student.getFullName());
        } else {
            System.out.println("Student not found with ID: " + id);
        }
    }

    public void enrollStudent(String studentId, String courseCode)
            throws DuplicateEnrollmentException {
        Student student = students.get(studentId);
        if (student == null) {
            throw new IllegalArgumentException("Student not found with ID: " + studentId);
        }

        if (student.getEnrolledCourses().contains(courseCode)) {
            throw new DuplicateEnrollmentException("Student already enrolled in course: " + courseCode);
        }

        student.getEnrolledCourses().add(courseCode);
        System.out.println("Student enrolled successfully in course: " + courseCode);
    }

    @Override
    public List<Student> search(Predicate<Student> criteria) {
        return students.values().stream()
                .filter(criteria)
                .collect(Collectors.toList());
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(students.values());
    }

    @Override
    public void save() throws IOException {
        // Implementation for file saving
        System.out.println("Students saved to file");
    }

    @Override
    public void load() throws IOException {
        // Implementation for file loading
        System.out.println("Students loaded from file");
    }

    // Stream API example for statistics
    public StudentStats getStudentStatistics1() {
        List<Student> allStudents = new ArrayList<>(students.values());

        int totalStudents = allStudents.size();
        int activeStudents = (int) allStudents.stream()
                .filter(Student::isActive)
                .count();

        double averageGPA = allStudents.stream()
                .filter(Student::isActive)
                .mapToDouble(Student::calculateGPA)
                .average()
                .orElse(0.0);

        return new StudentStats(totalStudents, averageGPA, activeStudents);
    }

    public StudentStats getStudentStatistics() {
        // TODO Auto-generated method stub
        return null;
    }
}