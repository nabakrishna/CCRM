package edu.ccrm.domain;

import java.time.LocalDate;

public class Course {
    private String code;
    private String title;
    private int credits;
    private String instructor;
    private Semester semester;
    private String department;
    private LocalDate creationDate;
    private boolean active;

    // Private constructor for Builder pattern
    private Course(Builder builder) {
        this.code = builder.code;
        this.title = builder.title;
        this.credits = builder.credits;
        this.instructor = builder.instructor;
        this.semester = builder.semester;
        this.department = builder.department;
        this.creationDate = LocalDate.now();
        this.active = true;
    }

    // Builder Pattern Implementation
    public static class Builder {
        private String code;
        private String title;
        private int credits;
        private String instructor;
        private Semester semester;
        private String department;

        public Builder(String code, String title, int credits) {
            this.code = code;
            this.title = title;
            this.credits = credits;
        }

        public Builder instructor(String instructor) {
            this.instructor = instructor;
            return this;
        }

        public Builder semester(Semester semester) {
            this.semester = semester;
            return this;
        }

        public Builder department(String department) {
            this.department = department;
            return this;
        }

        public Course build() {
            return new Course(this);
        }
    }

    // Getters and setters
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public int getCredits() { return credits; }
    public void setCredits(int credits) { this.credits = credits; }

    public String getInstructor() { return instructor; }
    public void setInstructor(String instructor) { this.instructor = instructor; }

    public Semester getSemester() { return semester; }
    public void setSemester(Semester semester) { this.semester = semester; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public LocalDate getCreationDate() { return creationDate; }
    public void setCreationDate(LocalDate creationDate) { this.creationDate = creationDate; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    @Override
    public String toString() {
        return String.format("Course[%s] %s (%d credits) - %s - %s",
                code, title, credits, instructor, semester);
    }
}