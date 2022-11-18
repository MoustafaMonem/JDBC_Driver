import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class jdbcDriver {
    public boolean tryConnection() throws Exception{
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/company?"
                + "user=root&password=pluralsight");) {
            boolean isValid = connection.isValid(2);
            return isValid;
        }

    }

    public void add(int id, String fullName, String phoneNumber) throws Exception{
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/company?"
                + "user=root&password=pluralsight");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT into Employees Values (?, ?, ?)");) {
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, fullName);
            preparedStatement.setString(3, phoneNumber);
            preparedStatement.executeUpdate();
        }
    }
    public void update(int id, String phoneNumber) throws Exception{
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/company?"
                + "user=root&password=pluralsight");
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Employees SET Phone_Number = ? WHERE ID = ?");) {
            preparedStatement.setString(1, phoneNumber);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        }
    }

    public void delete(int id) throws Exception{
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/company?"
                + "user=root&password=pluralsight");
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE from Employees Where ID = ?");) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }

    public void searchId(int id) throws Exception{
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/company?"
                + "user=root&password=pluralsight");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from Employees Where ID = ?");) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeQuery();

            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                while (resultSet.next()) {
                    String fullName = resultSet.getString("Full_Name");
                    String phoneNumber = resultSet.getString("Phone_Number");
                    System.out.print(id + " ");
                    System.out.print(fullName + " ");
                    System.out.println(phoneNumber);
                }
            }
        }
    }

    public void searchName(String fullName) throws Exception{
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/company?"
                + "user=root&password=pluralsight");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from Employees Where Full_Name = ?");) {
            preparedStatement.setString(1, fullName);
            preparedStatement.executeQuery();

            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("ID");
                    String phoneNumber = resultSet.getString("Phone_Number");
                    System.out.print(id + " ");
                    System.out.print(fullName + " ");
                    System.out.println(phoneNumber);
                }
            }
        }
    }

    public void getAllData() throws Exception{
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/company?"
                + "user=root&password=pluralsight");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from Employees ");) {
            preparedStatement.executeQuery();

            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("ID");
                    String fullName = resultSet.getString("Full_Name");
                    String phoneNumber = resultSet.getString("Phone_Number");
                    System.out.print(id + " ");
                    System.out.print(fullName + " ");
                    System.out.println(phoneNumber);
                }
            }
        }
    }
}