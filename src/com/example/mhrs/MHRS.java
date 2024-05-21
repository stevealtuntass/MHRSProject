package com.example.mhrs;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MHRS {
    private static final Map<String, User> users = new HashMap<>();
    private static final List<Doctor> doctors = new ArrayList<>();

    public static void initializeDoctors() {
        doctors.add(new Doctor("Dr. Smith", MedicalField.CARDIOLOGY));
        doctors.add(new Doctor("Dr. Johnson", MedicalField.CARDIOLOGY));
        doctors.add(new Doctor("Dr. Williams", MedicalField.NEUROLOGY));
        doctors.add(new Doctor("Dr. Brown", MedicalField.NEUROLOGY));
        doctors.add(new Doctor("Dr. Jones", MedicalField.DERMATOLOGY));
    }

    public static void createAndShowGUI() {
        JFrame frame = new JFrame("Medical Health Record System (MHRS)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new CardLayout());

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JButton registerButton = new JButton("Register");
        JButton loginButton = new JButton("Login");
        mainPanel.add(registerButton);
        mainPanel.add(loginButton);

        JPanel registerPanel = new JPanel();
        registerPanel.setLayout(new BoxLayout(registerPanel, BoxLayout.Y_AXIS));

        JTextField registerIdField = new JTextField(20);
        JPasswordField registerPasswordField = new JPasswordField(20);
        JButton registerSubmitButton = new JButton("Submit");

        registerPanel.add(new JLabel("Enter your ID number:"));
        registerPanel.add(registerIdField);
        registerPanel.add(new JLabel("Set a password:"));
        registerPanel.add(registerPasswordField);
        registerPanel.add(registerSubmitButton);

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));

        JTextField loginIdField = new JTextField(20);
        JPasswordField loginPasswordField = new JPasswordField(20);
        JButton loginSubmitButton = new JButton("Submit");

        loginPanel.add(new JLabel("Enter your ID number:"));
        loginPanel.add(loginIdField);
        loginPanel.add(new JLabel("Enter your password:"));
        loginPanel.add(loginPasswordField);
        loginPanel.add(loginSubmitButton);

        JPanel appointmentPanel = new JPanel();
        appointmentPanel.setLayout(new BoxLayout(appointmentPanel, BoxLayout.Y_AXIS));

        JComboBox<MedicalField> fieldComboBox = new JComboBox<>(MedicalField.values());
        JComboBox<Doctor> doctorComboBox = new JComboBox<>();
        JButton appointmentSubmitButton = new JButton("Make Appointment");

        appointmentPanel.add(new JLabel("Choose a medical field:"));
        appointmentPanel.add(fieldComboBox);
        appointmentPanel.add(new JLabel("Choose a doctor:"));
        appointmentPanel.add(doctorComboBox);
        appointmentPanel.add(appointmentSubmitButton);

        contentPane.add(mainPanel, "Main");
        contentPane.add(registerPanel, "Register");
        contentPane.add(loginPanel, "Login");
        contentPane.add(appointmentPanel, "Appointment");

        CardLayout cardLayout = (CardLayout) contentPane.getLayout();

        registerButton.addActionListener(e -> cardLayout.show(contentPane, "Register"));
        loginButton.addActionListener(e -> cardLayout.show(contentPane, "Login"));

        registerSubmitButton.addActionListener(e -> {
            String id = registerIdField.getText();
            String password = new String(registerPasswordField.getPassword());
            users.put(id, new User(id, password));
            JOptionPane.showMessageDialog(frame, "Registration successful!");
            cardLayout.show(contentPane, "Main");
        });

        loginSubmitButton.addActionListener(e -> {
            String id = loginIdField.getText();
            String password = new String(loginPasswordField.getPassword());

            if (!users.containsKey(id)) {
                JOptionPane.showMessageDialog(frame, "User not found. Please register first.");
                return;
            }

            User user = users.get(id);
            if (!user.getPassword().equals(password)) {
                JOptionPane.showMessageDialog(frame, "Incorrect password. Please try again.");
                return;
            }

            fieldComboBox.setSelectedIndex(0);
            updateDoctorsComboBox(fieldComboBox, doctorComboBox);
            fieldComboBox.addActionListener(event -> updateDoctorsComboBox(fieldComboBox, doctorComboBox));
            cardLayout.show(contentPane, "Appointment");
        });

        appointmentSubmitButton.addActionListener(e -> {
            Doctor chosenDoctor = (Doctor) doctorComboBox.getSelectedItem();
            if (chosenDoctor != null) {
                JOptionPane.showMessageDialog(frame, "Appointment made with Dr. " + chosenDoctor.getName() + " in " + chosenDoctor.getField() + ".");
                cardLayout.show(contentPane, "Main");
            }
        });

        frame.setVisible(true);
    }

    private static void updateDoctorsComboBox(JComboBox<MedicalField> fieldComboBox, JComboBox<Doctor> doctorComboBox) {
        MedicalField chosenField = (MedicalField) fieldComboBox.getSelectedItem();
        doctorComboBox.removeAllItems();
        for (Doctor doctor : doctors) {
            if (doctor.getField() == chosenField) {
                doctorComboBox.addItem(doctor);
            }
        }
    }
}
