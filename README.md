# Campus Course & Records Manager (CCRM)

## Table of Contents:
- [Project Overview](#project-overview)
- [Evolution of Java](#evolution-of-java)
- [Java Platform Comparison](#java-platform-comparison)
- [Java Architecture](#java-architecture)
- [Installation & Setup](#installation--setup)
- [Project Structure](#project-structure)
- [Features](#features)
- [Technical Implementation](#technical-implementation)
- [How to Run](#how-to-run)
- [Screenshots](#screenshots)
- [Syllabus Mapping](#syllabus-mapping)
- [Sample Usage](#sample-usage)
- [Acknowledgments](#acknowledgments)

## Project Overview

Campus Course & Records Manager (CCRM) is a comprehensive console-based Java SE application designed for educational institutions to efficiently manage:

- **Student Management**: Create, update, enroll/unenroll students in courses
- **Course Management**: Create, update, list, search, and assign instructors to courses
- **Grades & Transcripts**: Record marks, compute GPA, and generate transcripts
- **File Operations**: Import/export CSV data, backup and archive course data

## Evolution of Java

Java started in 1995 as Sun Microsystems' ambitious project to create a language that could run anywhere, which was pretty revolutionary at the time. The early 2000s brought major improvements like the Collections Framework and Swing, making Java a serious player in enterprise development. Java 5 in 2004 was a game-changer with generics and annotations, finally making the code cleaner and safer to write. Then Java 8 in 2014 completely transformed how we write Java by introducing lambda expressions and streams, bringing functional programming features that developers had been craving. Since then, Oracle has been releasing new versions every six months, constantly adding modern features like records and pattern matching to keep Java relevant in today's fast-paced development world.

## Java Platform Comparison

| Feature | Java ME (Micro Edition) | Java SE (Standard Edition) | Java EE (Enterprise Edition) |
|---------|------------------------|----------------------------|------------------------------|
| **Target Platform** | Mobile devices, IoT, embedded systems | Desktop applications, standalone apps | Enterprise web applications, servers |
| **Memory Footprint** | Very small (KB to few MB) | Moderate (MB to GB) | Large (GB+) |
| **APIs Included** | Limited subset of Java APIs | Complete Java core APIs | Java SE + Enterprise APIs |
| **Deployment** | Mobile apps, smart cards | Desktop JAR/EXE files | Web servers, application servers |
| **Examples** | Android apps, smart TV apps | Eclipse IDE, NetBeans | Banking systems, e-commerce |
| **Development Focus** | Resource-constrained environments | General-purpose applications | Multi-tier enterprise solutions |

## Java Architecture

### JDK (Java Development Kit)
- **Complete development environment** for Java applications
- **Includes**: JRE + development tools (javac, javadoc, jar, debugger)
- **Used by**: Developers to compile, debug, and package Java applications
- **Size**: Largest component (~100-300 MB)

### JRE (Java Runtime Environment)
- **Runtime environment** required to execute Java applications  
- **Includes**: JVM + core libraries + supporting files
- **Used by**: End users to run Java applications
- **Size**: Medium component (~50-100 MB)

### JVM (Java Virtual Machine)
- **Abstract machine** that provides runtime environment for Java bytecode
- **Responsibility**: Load, verify, and execute Java bytecode
- **Platform-specific**: Different implementations for different operating systems
- **Key features**: Garbage collection, memory management, security

**Interaction Flow:**
Java Source Code (.java) → javac compiler → Bytecode (.class) → JVM → Machine Code


## Installation & Setup

### Windows Java Installation Steps

1. **Download JDK**
   - Visit Oracle JDK download page or OpenJDK
   - Download JDK 11 or higher for Windows x64

2. **Install JDK**
   - Run the installer with administrator privileges
   - Choose installation directory (e.g., `C:\Program Files\Java\jdk-11.0.x`)
   - Complete installation wizard

3. **Set Environment Variables**
JAVA_HOME = C:\Program Files\Java\jdk-11.0.x
PATH = %PATH%;%JAVA_HOME%\bin


4. **Verify Installation**
java -version
javac -version


### Eclipse IDE Setup

1. **Download Eclipse IDE for Java Developers**
2. **Extract and launch Eclipse**
3. **Create New Java Project**:
- File → New → Java Project
- Project name: `CCRM`
- JRE version: Java 11+
- Module settings: Don't create module-info.java

4. **Configure Build Path**:
- Right-click project → Properties → Java Build Path
- Ensure correct JRE is selected

## Features

### Core Functionality
-  **Student Management**: CRUD operations with validation
-  **Course Management**: Advanced search and filtering using Stream API
-  **Enrollment System**: Business rule validation (credit limits, prerequisites)
-  **Grading System**: Automated GPA calculation with enum-based grades
-  **Transcript Generation**: Polymorphic reporting with formatted output
-  **File Operations**: CSV import/export with NIO.2 Path API
-  **Backup System**: Timestamped backups with recursive directory operations

### Advanced Java Features Implemented
- **Design Patterns**: Singleton (AppConfig), Builder (Course creation)
- **Exception Handling**: Custom exceptions with comprehensive error handling
- **Stream API**: Filtering, mapping, and aggregation operations
- **Lambda Expressions**: Functional interfaces for comparisons and predicates  
- **Date/Time API**: Modern temporal handling for all date operations
- **NIO.2**: Path-based file operations with atomic moves and copies
- **Generics**: Type-safe collections and service interfaces
- **Nested Classes**: Static nested classes and inner classes

## Technical Implementation

### OOP Principles Demonstrated

#### Encapsulation
private String studentId; // Private fields

public String getStudentId() { // Public getters
    return studentId;
}

public void setStudentId(String id) { // Validation in setters
    if (id != null && !id.trim().isEmpty()) {
        this.studentId = id;
    }
}



#### Inheritance
// Abstract base class
public abstract class Person {
    protected String id, name, email;
    public abstract String getRole();
}

// Concrete implementations
public class Student extends Person {
    @Override
    public String getRole() {
        return "Student";
    }
}


#### Polymorphism
// Interface-based polymorphism
List<Persistable> services = Arrays.asList(
        new StudentService(),
        new CourseService()
);
services.forEach(service -> {
    try {
        service.save();
    } catch (IOException e) {
        handleException(e);
    }
});


#### Abstraction
// Service interfaces hide implementation complexity
public interface Searchable<T> {
    List<T> search(Predicate<T> criteria);

    default List<T> findByName(String name) {
        return search(item -> item.getName().contains(name));
    }
}


## How to Run

### Prerequisites
- Java JDK 11 or higher
- Eclipse IDE or any Java IDE
- Windows/Linux/macOS

### Compilation & Execution
Clone the repository
```bash
git clone https://github.com/yourusername/-Campus-Course-Records-Manager-CCRM-
```
cd CCRM

Compile (if using command line)
javac -cp src src/edu/ccrm/cli/CCRMApplication.java

Run
java -cp src edu.ccrm.cli.CCRMApplication

Enable assertions (recommended)
java -ea -cp src edu.ccrm.cli.CCRMApplication


### Eclipse IDE
1. Import project: File → Import → Existing Projects into Workspace
2. Right-click `CCRMApplication.java` → Run As → Java Application
3. Follow console menu prompts

## Screenshots

📸 **Screenshot Directory**: `/screenshots/`
- `version_check.png` - JDK installation verification
- <img width="1040" height="241" alt="image" src="https://github.com/nabakrishna/CCRM/blob/main/Screensort/version_check.png" />

 
- `eclipse-setup.png` - Eclipse project configuration
<!-- <img width="907" height="984" alt="image" src="https://github.com/user-attachments/assets/a1efe1e9-be42-4e3f-99cd-0bcdca51004" /> -->

  
- `CCRM_structure.png` - Project Structure
- <img width="486" height="607" alt="image" src="https://github.com/nabakrishna/CCRM/blob/main/Screensort/CCRM_structure.png" />


- `CCRM_addstudent.png` - Student operations demo
- <img width="745" height="865" alt="image" src="https://github.com/nabakrishna/CCRM/blob/main/Screensort/CCRM_addstudent.png" /> 


<!-- <img width="1920" height="1020" alt="image" src="https://github.com/user-attachments/assets/ebf7d04f-b6a9-4874-8d10-f2967ed9dc34" /> -->


## Syllabus Mapping

| **Syllabus Topic** | **Implementation Location** | **Description** |
|-------------------|----------------------------|-----------------|
| **OOP Principles** | `edu.ccrm.domain.*` | Person hierarchy, encapsulation |
| **Design Patterns** | `AppConfig.java`, `Course.Builder` | Singleton, Builder patterns |
| **Exception Handling** | `edu.ccrm.domain.exceptions.*` | Custom checked/unchecked exceptions |
| **Collections & Generics** | `*Service.java` classes | Type-safe Maps, Lists, Streams |
| **File I/O (NIO.2)** | `edu.ccrm.io.*` | Path API, Files operations |
| **Date/Time API** | Domain classes | LocalDate, DateTimeFormatter |
| **Enums** | `Grade.java`, `Semester.java` | Enum constructors, methods |
| **Nested Classes** | `StudentService.StudentStats` | Static nested class |
| **Interfaces** | `Persistable.java`, `Searchable.java` | Interface inheritance, default methods |
| **Recursion** | `RecursiveUtils.java` | Directory traversal, size calculation |

## Sample Usage

### Basic Operations
=== CCRM Main Menu ===

Manage Students
Manage Courses
Manage Enrollments
Manage Grades
Import/Export Data
Reports
Backup Data
Exit


Example: Adding a student

Enter choice: 1
Student ID: 10020 |
Registration Number: abc10020 |
Full Name: abc |
Email: abc@gmai.com

✅ Student added successfully!


### Enabling Assertions
Enable assertions for debugging
java -ea -cp src edu.ccrm.cli.CCRMApplication

Assertions validate business rules:
assert studentId != null : "Student ID cannot be null";
assert credits >= 1 && credits <= 6 : "Credits must be between 1-6";


## Error Handling

The application implements robust exception handling:

### Errors vs Exceptions
- **Errors**: System-level problems (OutOfMemoryError, StackOverflowError)
- **Exceptions**: Recoverable conditions handled by application logic

### Custom Exception Examples
// Checked exceptions for business rule violations
public class MaxCreditLimitExceededException extends Exception {
    public MaxCreditLimitExceededException(String message) {
        super(message);
    }
}

// Unchecked exceptions for programming errors
public class DuplicateEnrollmentException extends RuntimeException {
    public DuplicateEnrollmentException(String message) {
        super(message);
    }
}


## Acknowledgments

- **Java Documentation**: Oracle official Java tutorials and documentation
- **Design Patterns**: Gang of Four Design Patterns reference
- **Stream API**: Java 8 functional programming concepts
- **NIO.2**: Modern Java I/O best practices

---

**Project Completed**: September 2025  
**Academic Session**: Semester 3, B.Tech Computer Science  
**Institution**: Vellore Institute of Technology (VIT)
