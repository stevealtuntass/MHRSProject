package com.example.mhrs;

public class Doctor {
    private final String name;
    private final MedicalField field;

    public Doctor(String name, MedicalField field) {
        this.name = name;
        this.field = field;
    }

    public String getName() {
        return name;
    }

    public MedicalField getField() {
        return field;
    }

    @Override
    public String toString() {
        return name;
    }
}
