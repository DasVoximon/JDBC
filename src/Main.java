import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final StudentDOA studentDOA = new StudentDOA();

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== Student Management Menu =====");
            System.out.println("1. Add Student");
            System.out.println("2. Update GPA");
            System.out.println("3. Update Name");
            System.out.println("4. Update Department");
            System.out.println("5. Delete Student");
            System.out.println("6. Display All Students");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // clear newline

            switch (choice) {
                case 1:
                    addStudentMain();
                    break;
                case 2:
                    updateGPAMain();
                    break;
                case 3:
                    updateNameMain();
                    break;
                case 4:
                    updateDept();
                    break;
                case 5:
                    deleteStd();
                    break;
                case 6:
                    dispStd();
                    break;
                case 0:
                    System.out.println("✅ Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("❌ Invalid option. Please try again.");
            }

        } while (choice != 0);

        scanner.close();
    }

    private static void addStudentMain() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter department: ");
        String dept = scanner.nextLine();

        System.out.print("Enter GPA: ");
        Double gpa = scanner.nextDouble();

        Student student = new Student(name, dept, gpa);
        studentDOA.addStudent(student);
    }

    private static void updateGPAMain() {
        System.out.print("Enter student ID: ");
        int idGpa = scanner.nextInt();

        System.out.print("Enter new GPA: ");
        double newGpa = scanner.nextDouble();

        studentDOA.updateStudentGpa(idGpa, newGpa);
    }

    private static void updateNameMain() {
        System.out.print("Enter student ID: ");
        int idName = scanner.nextInt();
        scanner.nextLine(); // clear newline

        System.out.print("Enter new name: ");
        String newName = scanner.nextLine();

        studentDOA.updateStudentName(idName, newName);
    }

    private static void updateDept() {
        System.out.print("Enter student ID: ");
        int idDept = scanner.nextInt();
        scanner.nextLine(); // clear newline

        System.out.print("Enter new department: ");
        String newDept = scanner.nextLine();

        studentDOA.updateStudentDepartMent(idDept, newDept);
    }

    private static void deleteStd() {
        System.out.print("Enter student ID to delete: ");
        int idDelete = scanner.nextInt();
        studentDOA.deleteStudent(idDelete);
    }

    private static void dispStd() {
        studentDOA.displayAllStudent();
    }

}
