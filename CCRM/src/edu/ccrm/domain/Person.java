package edu.ccrm.domain;

import java.time.LocalDate;

public abstract class Person {
    protected String id;
    protected String fullName;
    protected String email;
    protected LocalDate registrationDate;
    protected boolean active;

    public Person(String id, String fullName, String email) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.registrationDate = LocalDate.now();
        this.active = true;
    }

    // Getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public LocalDate getRegistrationDate() { return registrationDate; }
    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    // Abstract methods
    public abstract String getRole();
    public abstract void displayProfile();

    @Override
    public String toString() {
        return String.format("ID: %s, Name: %s, Email: %s, Active: %s",
                id, fullName, email, active);
    }
}