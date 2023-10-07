package view;

import model.Doctor;

import java.util.HashMap;
import java.util.Scanner;

public class DoctorView {
    private Scanner scanner;

    public DoctorView() {
        scanner = new Scanner(System.in);
    }

    public int displayMenuAndGetChoice() {
        System.out.println("====== DOCTOR MANAGEMENT SYSTEM ======:");
        System.out.println("1. Add Doctor");
        System.out.println("2. Update Doctor");
        System.out.println("3. Delete Doctor");
        System.out.println("4. Search Doctor");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    public Doctor getDoctorDetailsFromUser() {
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Code: ");
        String code = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Specialization: ");
        String specialization = scanner.nextLine();
        System.out.print("Enter Availability: ");
        int availability = scanner.nextInt();

        return new Doctor(code, name, specialization, availability);
    }

    public String getDoctorCodeToUpdate() {
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Code to update: ");
        return scanner.nextLine();
    }

    public String getDoctorCodeToDelete() {
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Code to delete: ");
        return scanner.nextLine();
    }

    public String getSearchInput() {
        scanner.nextLine(); // Consume newline
        System.out.print("Enter search string: ");
        return scanner.nextLine();
    }

    public void displaySearchResults(HashMap<String, Doctor> searchResult) {
        if (searchResult.isEmpty()) {
            System.out.println("No doctors found matching the search criteria.");
        } else {
            System.out.println("Search Results:");
            for (Doctor doctor : searchResult.values()) {
                System.out.println("Code: " + doctor.getCode() + ", Name: " + doctor.getName() +
                        ", Specialization: " + doctor.getSpecialization() + ", Availability: " + doctor.getAvailability());
            }
        }
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}
