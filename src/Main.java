import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentDOA studentDOA = new StudentDOA();
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
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter department: ");
                    String dept = scanner.nextLine();

                    System.out.print("Enter GPA: ");
                    Double gpa = scanner.nextDouble();

                    Student student = new Student(name, dept, gpa);
                    studentDOA.addStudent(student);
                    break;

                case 2:
                    System.out.print("Enter student ID: ");
                    int idGpa = scanner.nextInt();

                    System.out.print("Enter new GPA: ");
                    double newGpa = scanner.nextDouble();

                    studentDOA.updateStudentGpa(idGpa, newGpa);
                    break;

                case 3:
                    System.out.print("Enter student ID: ");
                    int idName = scanner.nextInt();
                    scanner.nextLine(); // clear newline

                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();

                    studentDOA.updateStudentName(idName, newName);
                    break;

                case 4:
                    System.out.print("Enter student ID: ");
                    int idDept = scanner.nextInt();
                    scanner.nextLine(); // clear newline

                    System.out.print("Enter new department: ");
                    String newDept = scanner.nextLine();

                    studentDOA.updateStudentDepartMent(idDept, newDept);
                    break;

                case 5:
                    System.out.print("Enter student ID to delete: ");
                    int idDelete = scanner.nextInt();
                    studentDOA.deleteStudent(idDelete);
                    break;

                case 6:
                    studentDOA.displayAllStudent();
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
}
