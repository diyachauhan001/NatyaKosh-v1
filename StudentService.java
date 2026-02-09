import java.util.ArrayList;

public class StudentService {

    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully. ID: " + student.getStudentId());
    }

    public Student findStudentById(int studentId) {
        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                return student;
            }
        }
        return null;
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student student : students) {
            System.out.println(
                "ID: " + student.getStudentId() +
                ", Name: " + student.getName() +
                ", Balance: ₹" + student.getBalance()
            );
        }
    }
}
