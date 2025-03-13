import java.util.ArrayList;
import java.util.List;

// Faculty class -> Independent entity, Aggregation with University
class Faculty {
    private final String facultyName;

    public Faculty(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getFacultyName() {
        return facultyName;
    }
}

// Department class -> Strong Composition with University
class Department {
    private final String departmentName;

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }
}

// University class -> Composition with Departments, Aggregation with Faculty
class University {
    private final String universityName;
    private final List<Department> departmentList;
    private final List<Faculty> facultyList;

    public University(String universityName) {
        this.universityName = universityName;
        this.departmentList = new ArrayList<>();
        this.facultyList = new ArrayList<>();
    }

    // Adding a department (Composition: Departments exist only within the university)
    public void addDepartment(String departmentName) {
        departmentList.add(new Department(departmentName));
    }

    // Adding faculty (Aggregation: Faculty can exist outside the university)
    public void hireFaculty(Faculty faculty) {
        facultyList.add(faculty);
    }

    // Displaying university details
    public void showUniversityInfo() {
        System.out.println("University: " + universityName);

        System.out.println("Departments:");
        if (departmentList.isEmpty()) {
            System.out.println("   No departments available.");
        } else {
            for (Department department : departmentList) {
                System.out.println("   - " + department.getDepartmentName());
            }
        }

        System.out.println("\nFaculty Members:");
        if (facultyList.isEmpty()) {
            System.out.println("   No faculty members assigned.");
        } else {
            for (Faculty faculty : facultyList) {
                System.out.println("   - " + faculty.getFacultyName());
            }
        }
        System.out.println();
    }

    // Closing university (Departments are removed, but faculty remains)
    public void shutDownUniversity() {
        System.out.println("The university '" + universityName + "' is shutting down...");
        departmentList.clear(); // Departments are removed permanently
        System.out.println();
    }
}

// Main class to demonstrate Aggregation and Composition
public class UniversitySystem {
    public static void main(String[] args) {
        // Creating a university instance
        University myUniversity = new University("Global University");

        // Adding departments
        myUniversity.addDepartment("Computer Science");
        myUniversity.addDepartment("Mechanical Engineering");

        // Creating faculty members
        Faculty profAmit = new Faculty("Prof. Amit");
        Faculty drArun = new Faculty("Mr. Arun");

        // Hiring faculty members
        myUniversity.hireFaculty(profAmit);
        myUniversity.hireFaculty(drArun);

        // Displaying university details
        myUniversity.showUniversityInfo();

        // Closing the university
        myUniversity.shutDownUniversity();

        // Displaying updated university details (Departments removed, Faculty remains)
        myUniversity.showUniversityInfo();
    }
}

//SampleOutput
// University: Global University
// Departments:
//    - Computer Science
//    - Mechanical Engineering

// Faculty Members:
//    - Prof. Amit
//    - Mr. Arun

// The university 'Global University' is shutting down...

// University: Global University
// Departments:
//    No departments available.

// Faculty Members:
//    - Prof. Amit
//    - Mr. Arun
