import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDOA {
    public void addStudent(Student student){
        String sql = "INSERT INTO students(name, department, gpa) VALUES (?, ?, ?)";
        try{
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, student.getName());
            statement.setString(2, student.getDepartment());
            statement.setDouble(3, student.getGpa());

            statement.executeUpdate();
        }catch (Exception e){
            System.out.println("Could not add this student to the database");
        }
    }
    public void updateStudentGpa(int id, Double gpa){
        String sql = "UPDATE students SET gpa=? where id = ?";
        try{
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setDouble(1, gpa);
            statement.setInt(2, id);

            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error updating student gpa");
        }
    }

    public void updateStudentName(int id, String name){
        String sql = "UPDATE students SET name=? where id = ?";
        try{
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, name);
            statement.setInt(2, id);

            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error updating student name");
        }
    }

    public void updateStudentDepartMent(int id, String dept){
        String sql = "UPDATE students SET gpa=? where id = ?";
        try{
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, dept);
            statement.setInt(2, id);

            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error updating student department");
        }
    }

    public void deleteStudent(int id){
        String sql = "DELETE FROM students where id = ?";
        try{
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(2, id);

            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Failed to delete this student");
        }
    }

    public void displayAllStudent(){
        String sql = "SELECT * FROM students";

        try{
            List<Student> students = new ArrayList<>();

            Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                Student student = new Student();

                student.setName(resultSet.getString("name"));
                student.setDepartment(resultSet.getString("department"));
                student.setGpa(resultSet.getDouble("gpa"));

                students.add(student);
            }
            for (Student student: students){
                System.out.println(student.getName() + "-" + student.getDepartment() + "-" + student.getGpa());
            }
        } catch (Exception e) {
            System.out.println("Failed to Select All the students");
        }
    }
}
