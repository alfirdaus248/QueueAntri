# Hospital Queue Management System

## Overview

This project is a Java Swing desktop application designed to simulate a hospital patient queue system. It manages patient registration, prioritization (emergency vs regular), queue processing, and stores processed patient data into a MySQL database for history tracking.

The system combines data structures (Queue and PriorityQueue), GUI-based interaction, and database integration to represent a real-world hospital queue workflow.

## Features

Patient Queue Management

* Add new patients with name, age, complaint, and priority
* Two types of queues:

  * Emergency (Darurat)
  * Regular (Reguler)
* Emergency patients are prioritized over regular patients

Queue Processing

* Process patients based on priority
* Emergency patients are served first
* Regular patients follow FIFO order
* Processed patients are removed from the active queue

History Management

* Processed patients are saved into MySQL database
* View complete patient history
* Search history by patient name

Graphical User Interface

* Built using Java Swing
* Forms for adding patients, viewing queue, and viewing history
* Table-based display for queue and history

## Tech Stack

Programming Language: Java
GUI Framework: Java Swing
Database: MySQL (phpMyAdmin)
IDE: NetBeans
Libraries:

* MySQL Connector/J (mysql-connector-j-8.3.0.jar)
* Absolute Layout (NetBeans Global Library)

## Required Libraries

Before running the project, you must add the following libraries in NetBeans:

1. MySQL JDBC Driver
   Path:
   MySqlJdbcDriver/mysql-connector-j-8.3.0.jar

   Add to project libraries:

   * Right click project
   * Properties
   * Libraries
   * Add JAR/Folder
   * Select the .jar file

2. Absolute Layout Library

   * Available in NetBeans Global Libraries
   * Add via:
     Properties → Libraries → Add Library → Absolute Layout

## Database Setup

This project requires MySQL database configuration.

Steps:

1. Open phpMyAdmin

2. Create a database named:
   rumah_sakit

3. Import the SQL file provided in the project folder

4. Ensure MySQL is running on port 3308
   (or modify Database.java to match your MySQL port)

Database connection configuration (Database.java):

String url = "jdbc:mysql://localhost:3308/rumah_sakit";
String user = "root";
String password = "";

Adjust these values if your local setup is different.

## How to Run

1. Open the project in NetBeans
2. Add required libraries (MySQL driver and Absolute Layout)
3. Import the database using phpMyAdmin
4. Run the main file:
   QueueAntriApp.java

The application will launch the main queue management interface.

## System Workflow

1. User opens the application

2. Main menu displays current queue

3. User adds a new patient through the form

4. Patient is assigned to:

   * Priority queue (emergency)
   * Regular queue

5. Queue is displayed in the main table

6. User processes the next patient

7. System selects:

   * Emergency patient first if available
   * Otherwise regular patient

8. Processed patient is saved into database

9. User can open the history page

10. History displays all processed patients and allows search

## Data Structure Design

* Regular Queue: LinkedList (FIFO)
* Priority Queue: PriorityQueue (based on priority level)
* Patient Model: Pasien class implements Comparable

## Notes

* Active queue is stored in memory and will be lost if the application is closed
* Only processed patients are saved permanently in the database
* Priority handling may require adjustment depending on implementation logic
* Ensure database connection matches your local MySQL configuration

## Author

M. Hisyam Al Firdaus