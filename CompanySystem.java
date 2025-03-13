import java.util.ArrayList;
import java.util.List;

// Represents an Employee belonging to a Department
class Employee {
    private final String employeeName;

    public Employee(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeName() {
        return employeeName;
    }
}

// Represents a Department within a Company
class Department {
    private final String departmentName;
    private final List<Employee> employeeList;

    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.employeeList = new ArrayList<>();
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void addEmployee(String employeeName) {
        employeeList.add(new Employee(employeeName));
    }

    public void showDepartmentDetails() {
        System.out.println("Department: " + departmentName);
        if (employeeList.isEmpty()) {
            System.out.println("  No employees in this department.");
        } else {
            for (Employee employee : employeeList) {
                System.out.println("  - " + employee.getEmployeeName());
            }
        }
        System.out.println();
    }
}

// Represents a Company containing multiple Departments
class Company {
    private final String companyName;
    private final List<Department> departmentList;

    public Company(String companyName) {
        this.companyName = companyName;
        this.departmentList = new ArrayList<>();
    }

    public void createDepartment(String departmentName) {
        departmentList.add(new Department(departmentName));
    }

    public void hireEmployee(String departmentName, String employeeName) {
        for (Department department : departmentList) {
            if (department.getDepartmentName().equalsIgnoreCase(departmentName)) {
                department.addEmployee(employeeName);
                return;
            }
        }
        System.out.println("Error: Department '" + departmentName + "' not found.");
    }

    public void showCompanyStructure() {
        System.out.println("\nCompany: " + companyName);
        if (departmentList.isEmpty()) {
            System.out.println("No departments available.");
        } else {
            for (Department department : departmentList) {
                department.showDepartmentDetails();
            }
        }
    }
}

// Main class to demonstrate Composition
public class CompanySystem {
    public static void main(String[] args) {
        Company myCompany = new Company("Tech Global");

        // Adding departments
        myCompany.createDepartment("Software Development");
        myCompany.createDepartment("Human Resources");
        myCompany.createDepartment("Marketing");

        // Hiring employees
        myCompany.hireEmployee("Software Development", "Ajay");
        myCompany.hireEmployee("Software Development", "Amit");
        myCompany.hireEmployee("Human Resources", "Sachin");
        myCompany.hireEmployee("Marketing", "Jatin");
        myCompany.hireEmployee("Marketing", "Atharva");
        myCompany.hireEmployee("Marketing", "Harsh");

        // Display the company structure
        myCompany.showCompanyStructure();
    }
}

//SampleOutput
//        Company: Tech Global
//        Department: Software Development
//  - Ajay
//  - Amit
//
//        Department: Human Resources
//  - Sachin
//
//        Department: Marketing
//  - Jatin
//  - Atharva
//  - Harsh
