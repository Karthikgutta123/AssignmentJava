//Q9. Write JDBC code to connect to a MySQL database and fetch all records from a students table.


package main;
import java.sql.*;

public class SqlConnection {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/school";
        String user = "root";
        String password = "root";

        String query = "SELECT * FROM students";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, user, password);

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            System.out.println("ID | Name | Age | Grade");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String grade = rs.getString("grade");

                System.out.println(id + " | " + name + " | " + age + " | " + grade);
            }

            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
