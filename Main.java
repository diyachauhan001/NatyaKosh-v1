import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StudentService service = new StudentService();

        //Predefined courses
        Course c1 = new Course(1, "Prarambhik",1500);
        Course c2 = new Course(2, "Praveshika Pratham",1700);
        Course c3 = new Course(3, "Praveshika Poorna",1900);
        Course c4 = new Course(4, "Madhyama Pratham",2100);
        Course c5 = new Course(5, "Madhyama Poorna",2300);
        Course c6 = new Course(6, "Upantya Visharad",2500);
        Course c7 = new Course(7, "Visharad",3200);
        boolean running = true;

        while (running) {
            System.out.println("\n===== NATYA KOSHA_Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Enroll Student in Course");
            System.out.println("3. View Student Details");
            System.out.println("4. Pay Tuition Fees");
            System.out.println("5. View All Students");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
               case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter student email: ");
                    String email = scanner.nextLine();

                    Student student = new Student(name, email);
                    service.addStudent(student);
                    break;

               case 2:
                    System.out.print("Enter student ID: ");
                    int sid = scanner.nextInt();

                    Student enrollStudent = service.findStudentById(sid);
                    if (enrollStudent == null) {
                        System.out.println("Student not found.");
                        break;
                    }

                    System.out.println("Available Courses:");
                    System.out.println("1. " + c1);
                    System.out.println("2. " + c2);
                    System.out.println("3. " + c3);
                    System.out.print("Choose course: ");

                    int courseChoice = scanner.nextInt();

                    switch (courseChoice) {
                        case 1:
                            enrollStudent.enrollCourse(c1);
                            break;
                        case 2:
                            enrollStudent.enrollCourse(c2);
                            break;
                        case 3:
                            enrollStudent.enrollCourse(c3);
                            break;
                        case 4:
                            enrollStudent.enrollCourse(c4);
                            break;
                        case 5:
                            enrollStudent.enrollCourse(c5);
                            break;
                        case 6:
                            enrollStudent.enrollCourse(c6);
                            break;
                        case 7:
                            enrollStudent.enrollCourse(c7);
                            break;
                        default:
                            System.out.println("Invalid course choice.");
                    }
                case 3:
                    System.out.print("Enter student ID: ");
                    int viewId = scanner.nextInt();

                    Student viewStudent = service.findStudentById(viewId);
                    if (viewStudent == null) {
                        System.out.println("Student not found.");
                        break;
                    }

                    System.out.println("Name: " + viewStudent.getName());
                    System.out.println("Courses Enrolled:");
                    if (viewStudent.getEnrolledCourses().isEmpty()) {
                        System.out.println("No courses enrolled.");
                    } else {
                        for (Course course : viewStudent.getEnrolledCourses()) 
                            {
                            System.out.println("- " + course.getCourseName());
                            }
                        }

                    break;
                case 4:
                    System.out.print("Enter student ID: ");
                    int payId = scanner.nextInt();

                    Student payStudent = service.findStudentById(payId);
                    if (payStudent == null) {
                        System.out.println("Student not found.");
                        break;
                    }

                    System.out.print("Enter amount to pay: ");
                    double amount = scanner.nextDouble();
                    payStudent.payFees(amount);
                    System.out.println("Payment successful.");
                    break;

                case 5:
                    service.displayAllStudents();
                    break;

                case 6:
                    running = false;
                    System.out.println("Exiting Natya Kosha. Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
