import java.util.ArrayList;
import java.util.List;

// Doctor class -> Association with Patient
class Doctor {
    private final String doctorName;
    private final List<Patient> assignedPatients;

    public Doctor(String doctorName) {
        this.doctorName = doctorName;
        this.assignedPatients = new ArrayList<>();
    }

    // Method to consult a patient
    public void provideConsultation(Patient patient) {
        if (!assignedPatients.contains(patient)) {
            assignedPatients.add(patient);
            patient.recordConsultation(this);
        }
        System.out.println(doctorName + " is consulting  " + patient.getPatientName() + ".");
        System.out.println();
    }

    public String getDoctorName() {
        return doctorName;
    }
}

// Patient class -> Associated with Doctor
class Patient {
    private final String patientName;
    private final List<Doctor> consultingDoctors;

    public Patient(String patientName) {
        this.patientName = patientName;
        this.consultingDoctors = new ArrayList<>();
    }

    // Method to record consultation with a doctor
    public void recordConsultation(Doctor doctor) {
        if (!consultingDoctors.contains(doctor)) {
            consultingDoctors.add(doctor);
        }
    }

    public String getPatientName() {
        return patientName;
    }
}

// Hospital class -> Manages doctors and patients
class Hospital {
    private final String hospitalName;
    private final List<Doctor> doctorList;
    private final List<Patient> patientList;

    public Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
        this.doctorList = new ArrayList<>();
        this.patientList = new ArrayList<>();
    }

    // Method to add a doctor
    public void registerDoctor(Doctor doctor) {
        if (!doctorList.contains(doctor)) {
            doctorList.add(doctor);
        }
    }

    // Method to add a patient
    public void admitPatient(Patient patient) {
        if (!patientList.contains(patient)) {
            patientList.add(patient);
        }
    }

    // Display hospital details
    public void showHospitalRecords() {
        System.out.println("Hospital: " + hospitalName);
        System.out.println("\nDoctors on Duty:");
        if (doctorList.isEmpty()) {
            System.out.println("   No doctors available.");
        } else {
            for (Doctor doctor : doctorList) {
                System.out.println("   - " + doctor.getDoctorName());
            }
        }

        System.out.println("\nPatients Admitted:");
        if (patientList.isEmpty()) {
            System.out.println("   No patients admitted.");
        } else {
            for (Patient patient : patientList) {
                System.out.println("   - " + patient.getPatientName());
            }
        }
        System.out.println();
    }
}

// Main class -> Demonstrating Association & Communication
public class HospitalManagement {
    public static void main(String[] args) {
        // Creating hospital instance
        Hospital myHospital = new Hospital("City Hospital");

        // Creating doctor instances
        Doctor drAmit = new Doctor("Dr. Amit");
        Doctor drSonia = new Doctor("Dr. Sonia");

        // Creating patient instances
        Patient harsh = new Patient("Harsh");
        Patient rajat = new Patient("Rajat");

        // Registering doctors and patients
        myHospital.registerDoctor(drAmit);
        myHospital.registerDoctor(drSonia);

        myHospital.admitPatient(harsh);
        myHospital.admitPatient(rajat);

        // Doctors consulting patients
        drAmit.provideConsultation(harsh);
        drAmit.provideConsultation(rajat);
        drSonia.provideConsultation(rajat);

        // Displaying hospital details
        myHospital.showHospitalRecords();
    }
}

//SampleOutput
// Dr. Amit is consulting  Harsh.

// Dr. Amit is consulting  Rajat.

// Dr. Sonia is consulting  Rajat.

// Hospital: City Hospital

// Doctors on Duty:
//    - Dr. Amit
//    - Dr. Sonia

// Patients Admitted:
//    - Harsh
//    - Rajat