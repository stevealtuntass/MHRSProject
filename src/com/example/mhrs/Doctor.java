package com.example.mhrs;

import java.util.HashMap;
import java.util.Map;

public class Doctor {
    private final String name;
    private final MedicalField field;
    private final Map<String, String> availability;

    public Doctor(String name, MedicalField field) {
        this.name = name;
        this.field = field;
        this.availability = new HashMap<>();
        initializeAvailability();
    }

    public String getName() {
        return name;
    }

    public MedicalField getField() {
        return field;
    }

    public Map<String, String> getAvailability() {
        return availability;
    }

    private void initializeAvailability() {
        availability.put("Monday", "9am-12pm");
        availability.put("Tuesday", "10am-1pm");
        availability.put("Wednesday", "1pm-4pm");
        // Add more days and times as needed
    }

    @Override
    public String toString() {
        return name;
    }
}
