package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StudentPortal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create an empty list to store students
        List<Student> students = new ArrayList<>();

        // Create an empty list to store units
        List<Unit> units = new ArrayList<>();

        // Create an empty list to store lecturers
        List<Lecturer> lecturers = new ArrayList<>();

        boolean exit = false;

        while (!exit) {
            System.out.println("Welcome to the Student Management Portal!");
            System.out.println("1. Student Registration");
            System.out.println("2. Unit Registration");
            System.out.println("3. Lecturer Registration");
            System.out.println("4. Add Unit to Student");
            System.out.println("5. Add Unit to Lecturer");
            System.out.println("6. Remove Unit from Student");
            System.out.println("7. Remove Unit from Lecturer");
            System.out.println("8. Display Students");
            System.out.println("9. Display Units");
            System.out.println("10. Display Lecturers");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.println("Student Registration");
                    System.out.print("Enter student registration number: ");
                    String registrationNumber = scanner.nextLine();
                    System.out.print("Enter student name: ");
                    String studentName = scanner.nextLine();
                    System.out.print("Enter intake: ");
                    String intake = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    Integer phoneNumber = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();

                    // Create a new student object
                    Student student = new Student(registrationNumber, studentName, intake, phoneNumber, email);

                    // Add the student to the list
                    students.add(student);

                    System.out.println("Student registered successfully!");
                    break;

                case 2:
                    System.out.println("Unit Registration");
                    System.out.print("Enter unit code: ");
                    String unitCode = scanner.nextLine();
                    System.out.print("Enter unit name: ");
                    String unitName = scanner.nextLine();

                    // Create a new unit object
                    Unit unit = new Unit(unitName, unitCode);

                    // Add the unit to the list
                    units.add(unit);

                    System.out.println("Unit registered successfully!");
                    break;

                case 3:
                    System.out.println("Lecturer Registration");
                    System.out.print("Enter lecturer ID: ");
                    String lecturerId = scanner.nextLine();
                    System.out.print("Enter lecturer name: ");
                    String lecturerName = scanner.nextLine();

                    // Create a new lecturer object
                    Lecturer lecturer = new Lecturer(lecturerId, lecturerName);

                    // Add the lecturer to the list
                    lecturers.add(lecturer);

                    System.out.println("Lecturer registered successfully!");
                    break;

                case 4:
                    System.out.println("Add Unit to Student");
                    System.out.print("Enter student registration number: ");
                    String studentId = scanner.nextLine();
                    System.out.print("Enter unit code: ");
                    String selectedUnitCode = scanner.nextLine();

                    // Find the student and the unit
                    Student selectedStudent = students.stream().filter(s -> s.getRegistrationNumber().equals(studentId)).findFirst().orElse(null);
                    Unit selectedUnit = units.stream().filter(c -> c.getCode().equals(selectedUnitCode)).findFirst().orElse(null);

                    if (selectedStudent != null && selectedUnit != null) {
                        // Add the unit to the student
                        selectedStudent.addUnit(selectedUnit);
                        System.out.println("Unit added to student successfully!");
                    } else {
                        System.out.println("Student or unit not found.");
                    }
                    break;

                case 5:
                    System.out.println("Add Unit to Lecturer");
                    System.out.print("Enter lecturer ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter unit code: ");
                    selectedUnitCode = scanner.nextLine();

                    // Find the lecturer and the unit
                    Lecturer selectedLecturer = lecturers.stream().filter(l -> l.getId().equals(id)).findFirst().orElse(null);
                    Unit selectedUnit1 = units.stream().filter(c -> c.getCode().equals(selectedUnitCode)).findFirst().orElse(null);

                    if (selectedLecturer != null && selectedUnit1 != null) {
                        // Add the unit to the lecturer
                        selectedLecturer.addUnit(selectedUnit1);
                        System.out.println("Unit added to lecturer successfully!");
                    } else {
                        System.out.println("Lecturer or Unit not found.");
                    }
                    break;

                case 6:
                    System.out.println("Remove Unit from Student");
                    System.out.print("Enter student ID: ");
                    String regNumber = scanner.nextLine();
                    System.out.print("Enter unit code: ");
                    String unitCode1 = scanner.nextLine();

                    // Find the student and the unit
                    Student selectedStudent1 = students.stream().filter(s -> s.getRegistrationNumber().equals(regNumber)).findFirst().orElse(null);
                    Unit unit1 = units.stream().filter(c -> c.getCode().equals(unitCode1)).findFirst().orElse(null);

                    if (selectedStudent1 != null && unit1 != null) {
                        // Remove the unit from the student
                        selectedStudent1.getUnits().remove(unit1);
                        System.out.println("Unit removed from student successfully!");
                    } else {
                        System.out.println("Student or unit not found.");
                    }
                    break;

                case 7:
                    System.out.println("Remove unit from Lecturer");
                    System.out.print("Enter lecturer ID: ");
                    String selectedLecturerId = scanner.nextLine();
                    System.out.print("Enter unit code: ");
                    unitCode1 = scanner.nextLine();

                    // Find the lecturer and the unit
                    Lecturer selectedLecturer1 = lecturers.stream().filter(l -> l.getId().equals(selectedLecturerId)).findFirst().orElse(null);
                    unit1 = units.stream().filter(c -> c.getCode().equals(unitCode1)).findFirst().orElse(null);

                    if (selectedLecturer1 != null && unit1 != null) {
                        // Remove the unit from the lecturer
                        selectedLecturer1.getUnits().remove(unit1);
                        System.out.println("Unit removed from lecturer successfully!");
                    } else {
                        System.out.println("Lecturer or Unit not found.");
                    }
                    break;


                case 8:
                    System.out.println("\nDisplay Students");
                    if (students.isEmpty()) {
                        System.out.println("No students registered.");
                    } else {
                        for (Student s : students) {
                            System.out.print(s.getRegistrationNumber());
                            System.out.print(" | "+s.getName());
                            System.out.print(" | "+s.getIntake());
                            System.out.print(" | "+s.getPhoneNumber());
                            System.out.print(" | "+s.getEmail());
                            System.out.print(" | Units("+s.getUnits().size()+"): ");
                            System.out.println(s.getUnits().stream().map(u -> {
                                return u.getName()+" ("+u.getCode()+")";
                            }).collect(Collectors.joining(",")));
                        }
                        System.out.println("");
                    }
                    break;

                case 9:
                    System.out.println("\nDisplay Units");
                    if (units.isEmpty()) {
                        System.out.println("No units registered.");
                    } else {
                        for (Unit u : units) {
                            System.out.print(u.getCode());
                            System.out.print(" | "+u.getName());
                        }
                        System.out.println("");
                    }
                    break;

                case 10:
                    System.out.println("\nDisplay Lecturers");
                    if (lecturers.isEmpty()) {
                        System.out.println("No lecturers registered.");
                    } else {
                        for (Lecturer lec : lecturers) {
                            System.out.print(lec.getId());
                            System.out.print(" | "+lec.getName());
                            System.out.print(" | Units("+lec.getUnits().size()+"): ");
                            System.out.println(lec.getUnits().stream().map(u -> {
                                return u.getName()+" ("+u.getCode()+")";
                            }).collect(Collectors.joining(",")));

                        }
                        System.out.println("");
                    }
                    break;


                case 11:
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        System.out.println("Thank you for using the Student Portal!");
    }
}

