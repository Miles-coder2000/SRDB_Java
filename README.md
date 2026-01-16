# MCTI Student Records Database (SRDB)

A Java Swing desktop application for managing student records with SQLite database integration.

## Overview

MCTI_SRDB is a comprehensive student record management system built with Java Swing and SQLite. It provides a user-friendly GUI for performing CRUD (Create, Read, Update, Delete) operations on student data including ID numbers, names, age, and addresses.

## Features

- **Add Records**: Insert new student records with validation
- **Edit Records**: Modify existing student information
- **Delete Records**: Remove student records from the database
- **Search Functionality**: Find students by ID number
- **Real-time Clock**: Display current date and time
- **Data Persistence**: SQLite database for reliable data storage
- **Background Image**: Custom UI with background image support

## Technology Stack

- **Language**: Java
- **GUI Framework**: Java Swing with NetBeans Form Designer
- **Database**: SQLite with JDBC driver
- **Build Tool**: Maven
- **Layout Manager**: AbsoluteLayout (NetBeans)

## Project Structure

```
AddRec/
├── src/main/java/
│   └── addrec/
│       ├── AddRec.java          # Main GUI class
│       ├── AddRec.form          # NetBeans form file
│       └── DatabaseHelper.java  # Database operations
├── pom.xml                      # Maven configuration
└── records.db                   # SQLite database (auto-generated)
```

## Database Schema

The application uses a SQLite database with the following table structure:

```sql
CREATE TABLE IF NOT EXISTS records (
    id TEXT PRIMARY KEY,
    firstName TEXT NOT NULL,
    lastName TEXT NOT NULL,
    age INTEGER NOT NULL,
    address TEXT NOT NULL
);
```

## Dependencies

- **SQLite JDBC Driver**: `org.xerial:sqlite-jdbc:3.45.3.0`
- **NetBeans AbsoluteLayout**: For GUI layout management

## Setup Instructions

### Prerequisites
- Java 24 or higher
- Maven 3.6+
- NetBeans IDE (recommended for form editing)

### Installation

1. **Clone the repository**:
   ```bash
   git clone <github.com/Miles-coder2000/SRDB_JAVA.git>
   cd AddRec
   ```

2. **Build the project**:
   ```bash
   mvn clean compile
   ```

3. **Run the application**:
   ```bash
   mvn exec:java -Dexec.mainClass="addrec.AddRec"
   ```

### Alternative Run Method
```bash
java -cp target/classes:lib/* addrec.AddRec
```

## Usage Guide

### Adding a Record
1. Fill in all required fields (ID Number, First Name, Last Name, Age, Address)
2. Click the "Add" button
3. The record will be saved to the database and displayed in the table

### Editing a Record
1. Select a row from the table
2. Click the "Edit" button to load data into form fields
3. Modify the desired fields
4. Click "Edit" again to confirm changes

### Searching Records
1. Enter an ID number in the "Search ID" field
2. Click the "Search" button
3. The matching record will be highlighted in the table
4. Option to load the record for editing

### Deleting Records
1. Select a row from the table
2. Click the "Delete" button
3. The record will be permanently removed

## Key Classes

### AddRec.java
- Main application class extending JFrame
- Handles all GUI events and user interactions
- Manages form validation and data display
- Implements real-time clock functionality

### DatabaseHelper.java
- Static utility class for database operations
- Provides methods for CRUD operations
- Handles SQLite connection management
- Includes database initialization

## Features in Detail

### Input Validation
- Checks for empty fields before adding records
- Validates age field as numeric input
- Prevents duplicate ID entries

### User Experience
- Confirmation dialogs for critical operations
- Clear field functionality after operations
- Table selection and highlighting
- Real-time date/time display

### Database Management
- Automatic database and table creation
- Prepared statements for SQL injection prevention
- Connection pooling and proper resource cleanup
- Error handling and logging

## Customization

### Background Image
The application supports custom background images. Place your image in:
```
src/main/resources/images/Marvelous.jpg
```

### UI Modifications
- Form layout can be modified using NetBeans Form Designer
- Colors and fonts are configurable in the .form file
- Button positions use AbsoluteLayout constraints

## Troubleshooting

### Common Issues

**Database Connection Error**:
- Ensure SQLite JDBC driver is in classpath
- Check file permissions for database creation

**GUI Layout Issues**:
- Verify AbsoluteLayout dependency is available
- Check form file integrity

**Build Failures**:
- Confirm Java 24 compatibility
- Update Maven dependencies if needed

### Error Handling
The application includes comprehensive error handling for:
- Database connection failures
- Invalid input data
- File system permissions
- SQL execution errors

## Development Notes

### Code Architecture
- Separation of concerns between GUI and database logic
- Event-driven programming model
- Static utility pattern for database operations
- Form-based GUI design with NetBeans integration

### Best Practices Implemented
- Prepared statements for SQL operations
- Resource management with try-with-resources
- Input validation and sanitization
- User feedback through dialog messages

## Contributing

When contributing to this project:
1. Maintain the existing code structure
2. Follow Java naming conventions
3. Add appropriate error handling
4. Update documentation as needed
5. Test all CRUD operations thoroughly

## License

This project is developed for educational purposes as part of MCTI coursework.

## Author

**Miles Garcia** - MCTI Student Records Database System

---

*Note: This application uses NetBeans Form Designer. Opening .form files requires NetBeans IDE for visual editing.*
