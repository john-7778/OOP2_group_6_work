package application;

import java.util.ArrayList;
import java.util.List;

public class Lecturer {
    private String id;
    private String name;
    private List<Unit> units;

    // Constructor
    public Lecturer(String id, String name) {
        this.id = id;
        this.name = name;
        this.units = new ArrayList<>();
    }

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Unit> getUnits() {
        return units;
    }

    public void addUnit(Unit unit) {
        this.units.add(unit);
    }
}

