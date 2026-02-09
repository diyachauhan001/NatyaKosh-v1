import java.util.ArrayList;

public class Student {

    private static int idCounter = 1000;

    private int studentId;
    private String name;
    private String email;
    private ArrayList<Course> enrolledCourses;
    private double balance;

    // Constructor
    public Student(String name, String email) {
        this.studentId = ++idCounter;
        this.name = name;
        this.email = email;
        this.enrolledCourses = new ArrayList<>();
        this.balance = 0.0;
    }

    // Getters
    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public double getBalance() {
        return balance;
    }

    public ArrayList<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    // Business methods
    public void enrollCourse(Course course) {
        enrolledCourses.add(course);
        balance += course.getCourseFee();
    }

    public void payFees(double amount) {
    if (amount <= 0) {
        System.out.println("Invalid payment amount.");
        return;
    }

    if (amount > balance) {
        System.out.println("Payment exceeds pending balance.");
    } else {
        balance -= amount;
        System.out.println("₹" + amount + " paid successfully.");
    }
}
public void displayStudent() {
    System.out.println("ID: " + studentId);
    System.out.println("Name: " + name);
    System.out.println("Email: " + email);
    System.out.println("Balance: ₹" + balance);
}

}