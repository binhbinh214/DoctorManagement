package model;

import java.util.HashMap;

public class DoctorHash {
    private HashMap<String, Doctor> doctorDatabase;

    public DoctorHash() {
        doctorDatabase = new HashMap<>();
    }

    public void addDoctor(Doctor doctor) throws Exception {
        if (doctorDatabase.containsKey(doctor.getCode())) {
            throw new Exception("Doctor code [" + doctor.getCode() + "] is duplicate");
        }
        doctorDatabase.put(doctor.getCode(), doctor);
    }

    public void updateDoctor(Doctor doctor) throws Exception {
        if (!doctorDatabase.containsKey(doctor.getCode())) {
            throw new Exception("Doctor code doesn't exist");
        }
        doctorDatabase.put(doctor.getCode(), doctor);
    }

    public void deleteDoctor(String code) throws Exception {
        if (!doctorDatabase.containsKey(code)) {
            throw new Exception("Doctor code doesn't exist");
        }
        doctorDatabase.remove(code);
    }

    public HashMap<String, Doctor> searchDoctor(String input) throws Exception {
        HashMap<String, Doctor> result = new HashMap<>();
        for (Doctor doctor : doctorDatabase.values()) {
            if (doctor.getName().contains(input) || doctor.getSpecialization().contains(input)) {
                result.put(doctor.getCode(), doctor);
            }
        }
        return result;
    }
}