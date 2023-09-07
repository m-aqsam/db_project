import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentManager {
    private static final String DB_URL = "jdbc:mysql://localhost/university";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Aqsam1155***";

    public void createNewStudent(int rollNo, String name, int marks) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            String query = "INSERT INTO students (rollno, name, marks) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, rollNo);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, marks);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Student with Roll No. " + rollNo + " has been added.");
            } else {
                System.out.println("Failed to add the student.");
            }

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        StudentManager studentManager = new StudentManager();
        studentManager.createNewStudent(101, "John Doe", 85);
    }
}
