package com.example.mhrs;

public class Appointment {
    private final Doctor doctor;
    private final String day;
    private final String time;

    public Appointment(Doctor doctor, String day, String time) {
        this.doctor = doctor;
        this.day = day;
        this.time = time;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public String getDay() {
        return day;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Appointment with Dr. " + doctor.getName() + " on " + day + " at " + time;
    }
}
