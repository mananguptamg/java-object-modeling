import java.util.ArrayList;

// CourseDetails class -> Aggregation with Professor, Association with StudentDetails
class CourseDetails {
    // Attributes
    private final String name;
    private Professor professor;
    private final ArrayList<StudentDetails> students;

    // Constructor
    CourseDetails(String name) {
        this.name = name;
        students = new ArrayList<>();
    }

    // Method to assign professor to course
    public void assignProfessor(Professor professor) {
        this.professor = professor;
    }

    // Method to add Students to course
    public void addStudent(StudentDetails student) {
        students.add(student);
    }

    // Method to get course name
    public String getName() {
        return name;
    }

    // Method to display course details
    public void displayCourseDetails() {
        System.out.println("Course: " + name);
        if(professor != null) {
            System.out.println("Professor: " + professor.getName());
        }
        System.out.println();
        System.out.println("Students: ");
        for(StudentDetails student: students) {
            System.out.println("Student: " + student.getName());
        }
        System.out.println();
    }
}

// Professor class -> Independent Entity, Aggregated with Course
class Professor {
    // Attributes
    private final String name;

    // Constructor
    Professor(String name) {
        this.name = name;
    }

    // Method to get professor name
    public String getName() {
        return name;
    }
}

// StudentDetails class -> Associated with Course
class StudentDetails {
    // Attributes
    private final String name;
    private final ArrayList<CourseDetails> courses;

    // Constructor
    StudentDetails(String name) {
        this.name = name;
        courses = new ArrayList<>();
    }

    // Method to enroll student into a course
    public void enrollCourse(CourseDetails course) {
        courses.add(course);
        course.addStudent(this);
    }

    // Method to get student name
    public String getName() {
        return name;
    }
}

// Main class -> Demonstrating University Management System
public class UniversityManagement {
    public static void main(String[] args) {
        // Create objects of student
        StudentDetails student1 = new StudentDetails("Jatin");
        StudentDetails student2 = new StudentDetails("Manan");

        // Create an Object of professor
        Professor professor1 = new Professor("Dr. Gagan");

        // Create an Object of course
        CourseDetails course1 = new CourseDetails("Java");

        // Assign professor to course
        course1.assignProfessor(professor1);

        // Add students to course
        student1.enrollCourse(course1);
        student2.enrollCourse(course1);

        // Display course details
        course1.displayCourseDetails();
    }
}

// //SampleOutput
// Course: Java
// Professor: Dr. Gagan

// Students:
// Student: Jatin
// Student: Manan
