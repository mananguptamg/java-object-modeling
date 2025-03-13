import java.util.ArrayList;

// Course class -> Association with Student
class Course {
    // Attributes
    private final String name;
    private final ArrayList<Student> students;

    // Constructor
    Course(String name) {
        this.name = name;
        students = new ArrayList<>();
    }

    // Method to get name of course
    public String getName() {
        return name;
    }

    // Method to add a student to course
    public void enrollStudent(Student student) {
        students.add(student);
    }

    // Method to display students in a course
    public void displayStudents() {
        System.out.print("Course: " + name + " Students: ->");
        for(Student student: students) {
            System.out.print(" " + student.getName());
        }
        System.out.println();
    }

    // Student class -> Association with Course, Aggregation with School
}
class Student {
    // Attributes
    private final String name;
    private final ArrayList<Course> courses;

    // Constructor
    Student(String name) {
        this.name = name;
        courses = new ArrayList<>();
    }

    // Method to get student name
    public String getName() {
        return name;
    }

    // Method to add a student in course
    public void enrollCourse(Course course) {
        courses.add(course);
        course.enrollStudent(this);
    }

    // Method to display courses where student enrolled
    public void displayCourses() {
        System.out.print("Student: " + name + " Courses: ->");
        for(Course course: courses) {
            System.out.print(" " + course.getName());
        }
        System.out.println();
    }
}

// School class -> Aggregation with Student
class School {
    // Attributes
    private final String name;
    private final ArrayList<Student> students;

    // Constructor
    School(String name) {
        this.name = name;
        students = new ArrayList<>();
    }

    // Method to add Student to school
    public void enrollStudent(Student student) {
        students.add(student);
    }

    // Method to display students in School
    public void displayStudents() {
        System.out.print("School: " + name + " Students: ->");
        for(Student student: students) {
            System.out.print(" " + student.getName());
        }
        System.out.println();
    }
}

// Main class to demonstrate Association and Aggregation
public class SchoolSystem {
    public static void main(String[] args) {
        // Create an Object of School
        School school1 = new School("ABC School");

        // Create objects of Student
        Student student1 = new Student("Harsh");
        Student student2 = new Student("Mehak");

        // Add students to school
        school1.enrollStudent(student1);
        school1.enrollStudent(student2);

        // Create objects of Course
        Course course1 = new Course("Java");
        Course course2 = new Course("C++");

        // Enroll students in course
        student1.enrollCourse(course1);
        student1.enrollCourse(course2);
        student2.enrollCourse(course2);

        // Display enrolled students in school
        school1.displayStudents();

        // Display courses in which students enrolled
        student1.displayCourses();
        student2.displayCourses();

        // Display students in each course
        course1.displayStudents();
        course2.displayStudents();
    }
}

//SampleOutput
//        School: ABC School Students: -> Harsh Mehak
//        Student: Harsh Courses: -> Java C++
//        Student: Mehak Courses: -> C++
//        Course: Java Students: -> Harsh
//        Course: C++ Students: -> Harsh Mehak