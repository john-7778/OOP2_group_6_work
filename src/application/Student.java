package application;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String registrationNumber;
    private String name;
    private String intake;
    private Integer phoneNumber;
    private String email;
    private List<Unit> units;

    // Constructor
    public Student(String registrationNumber, String name, String intake, Integer phoneNumber, String email) {
        this.registrationNumber = registrationNumber;
        this.name = name;
        this.intake = intake;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.units = new ArrayList<>();
    }

    // Getters and Setters

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntake() {
        return intake;
    }

    public void setIntake(String intake) {
        this.intake = intake;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Unit> getUnits() {
        return units;
    }

    public void addUnit(Unit unit) {
        this.units.add(unit);
    }
}
