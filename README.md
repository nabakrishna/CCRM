# CCRM
Campus Course & Records Manager (CCRM)
A comprehensive Java SE console application for managing students, courses, enrollments, and grades at an educational institute.

Table of Contents

- Project Overview
- Java Platform Information
- Setup Instructions
- Features
- Technical Implementation
- Usage
- Project Structure
- Demo
Acknowledgements

Project Overview
The Campus Course & Records Manager (CCRM) is a console-based Java application that provides complete management functionality for educational institutions. It handles student registration, course management, enrollment processing, grade recording, and transcript generation with robust file I/O operations and backup utilities.

How to Run
Ensure JDK 11 or higher is installed

Clone this repository

Navigate to the project directory

Compile: javac -d bin src/edu/ccrm/**/*.java

Run: java -cp bin edu.ccrm.cli.CCRMApplication

Enable assertions (optional): java -ea -cp bin edu.ccrm.cli.CCRMApplication

Java Platform Information
Evolution of Java
1995: Java 1.0 - Initial release with core language features

1997: Java 1.1 - Inner classes, JavaBeans, JDBC, RMI

1998: Java 1.2 (J2SE) - Collections Framework, Swing, JIT compiler

2000: Java 1.3 - HotSpot JVM, JNDI, RMI-IIOP

2002: Java 1.4 - Regular expressions, NIO, assertions, XML processing

2004: Java 5 - Generics, annotations, enums, autoboxing, enhanced for-loop

2006: Java 6 - Performance improvements, scripting support, JDBC 4.0

2011: Java 7 - Diamond operator, try-with-resources, NIO.2

2014: Java 8 - Lambda expressions, Stream API, Optional, Date/Time API

2017: Java 9 - Module system, JShell, HTTP/2 client

2018: Java 10 - Local variable type inference (var)

2018: Java 11 - HTTP client, String methods, Flight Recorder

2019-Present: Java 12+ - Text blocks, pattern matching, records, sealed classes

Java Platform Comparison
Feature	Java ME	Java SE	Java EE
Target	Mobile/Embedded devices	Desktop applications	Enterprise web applications
Components	CLDC, MIDP profiles	Full JDK libraries	Servlets, JSP, EJB, JPA
Memory	Limited (KB-MB)	Standard (MB-GB)	Large scale (GB+)
APIs	Basic I/O, networking	Complete standard library	Web services, messaging
Deployment	Mobile apps, IoT	Standalone applications	Web servers, app servers
Examples	Mobile games, sensors	CCRM, desktop tools	Banking systems, e-commerce
Java Architecture: JDK, JRE, JVM
Java Virtual Machine (JVM)

Runtime environment that executes Java bytecode

Provides platform independence through bytecode interpretation

Handles memory management, garbage collection, and security

Java Runtime Environment (JRE)

Includes JVM + standard libraries + supporting files

Required to run Java applications

Contains core classes, native libraries, and configuration files

Java Development Kit (JDK)

Complete development environment including JRE + development tools

Contains compiler (javac), debugger, documentation generator (javadoc)

Required for developing Java applications

Interaction Flow: Source Code → JDK (javac) → Bytecode → JRE (JVM) → Native Machine Code

Setup Instructions
Installing Java on Windows
Download JDK

Visit Oracle's official website or OpenJDK

Download JDK 11 or later for Windows x64

Choose the installer (.exe) version

Installation Steps

Run the downloaded installer as administrator

Follow installation wizard (default settings recommended)

Note the installation path (typically C:\Program Files\Java\jdk-XX)

Set Environment Variables

Open System Properties → Advanced → Environment Variables

Add JAVA_HOME pointing to JDK installation directory

Add %JAVA_HOME%\bin to PATH variable

Verification

bash
java -version
javac -version
Eclipse IDE Setup
Create New Project

File → New → Java Project

Project name: "CCRM"

Use default JRE (ensure it's JDK 11+)

Create separate source and output folders

Project Structure

Create package structure under src/

Configure build path if needed

Set compiler compliance level to match JDK version

Run Configuration

Right-click main class → Run As → Java Application

Configure VM arguments for assertions: -ea

Set working directory if needed for file operations

![Eclipse Run Configuration](screenshots/eclipse-run. Functionality

Student Management: Add, update, list, and deactivate students

Course Management: Create courses, assign instructors, search and filter

Enrollment System: Enroll/unenroll students with business rule validation

Grading System: Record marks, compute GPA, generate transcripts

File Operations: Import/export CSV data, backup with timestamps

Reporting: GPA distribution, student rankings using Stream API

Business Rules
Maximum 18 credits per semester enrollment

Grade point calculation: S(10), A(9), B(8), C(7), D(6), F(0)

Unique registration numbers and course codes

Semester-wise enrollment tracking

Technical Implementation
Object-Oriented Programming Pillars
Encapsulation

Private fields with public getter/setter methods

Data validation in setter methods

Controlled access to internal state

Inheritance

Abstract Person class extended by Student and Instructor

Common fields (id, name, email) in base class

Specialized behavior in derived classes

Abstraction

Abstract methods in Person class (e.g., getRole())

Service interfaces defining contracts

Hidden implementation complexity

Polymorphism

Method overriding in inheritance hierarchy

Interface implementations with different behaviors

Runtime method resolution through virtual method invocation
