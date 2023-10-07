package controller;

import model.Doctor;
import model.DoctorHash;
import view.DoctorView;

import java.util.HashMap;

public class DoctorController {
    private DoctorHash doctorHash;
    private DoctorView doctorView;

    public DoctorController() {
        doctorHash = new DoctorHash();
        doctorView = new DoctorView();
    }

    public void start() {
        while (true) {
            int choice = doctorView.displayMenuAndGetChoice();

            switch (choice) {
                case 1:
                    addDoctor();
                    break;
                case 2:
                    updateDoctor();
                    break;
                case 3:
                    deleteDoctor();
                    break;
                case 4:
                    searchDoctor();
                    break;
                case 5:
                    System.out.println("Exiting program.");
                    return;
                default:
                    doctorView.displayMessage("Invalid choice. Please try again.");
            }
        }
    }

    private void addDoctor() {
        try {
            Doctor doctor = doctorView.getDoctorDetailsFromUser();
            doctorHash.addDoctor(doctor);
            doctorView.displayMessage("Doctor added successfully.");
        } catch (Exception e) {
            doctorView.displayMessage("Error: " + e.getMessage());
        }
    }

    private void updateDoctor() {
        String code = doctorView.getDoctorCodeToUpdate();
        try {
            Doctor existingDoctor = doctorHash.searchDoctor(code).get(code);
            if (existingDoctor == null) {
                doctorView.displayMessage("Doctor code does not exist.");
                return;
            }

            Doctor updatedDoctor = doctorView.getDoctorDetailsFromUser();
            updatedDoctor.setCode(code); // Ensure code remains the same
            doctorHash.updateDoctor(updatedDoctor);
            doctorView.displayMessage("Doctor updated successfully.");
        } catch (Exception e) {
            doctorView.displayMessage("Error: " + e.getMessage());
        }
    }

    private void deleteDoctor() {
        String code = doctorView.getDoctorCodeToDelete();
        try {
            doctorHash.deleteDoctor(code);
            doctorView.displayMessage("Doctor deleted successfully.");
        } catch (Exception e) {
            doctorView.displayMessage("Error: " + e.getMessage());
        }
    }

    private void searchDoctor() {
        String searchInput = doctorView.getSearchInput();
        try {
            HashMap<String, Doctor> searchResult = doctorHash.searchDoctor(searchInput);
            doctorView.displaySearchResults(searchResult);
        } catch (Exception e) {
            doctorView.displayMessage("Error: " + e.getMessage());
        }
    }

 
    }
