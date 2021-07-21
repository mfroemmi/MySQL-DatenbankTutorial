import java.sql.*;

public class Testverbindung {
    public static void main (String args[]) {
        String url = "jdbc:mysql://localhost:3306/falconbyte";
        String user = "root";
        String pass = "";

        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            System.out.println("Verbindung erfolgreich hergestellt.");

            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM staedteUSA");

            while (rs.next()) {
                System.out.println(rs.getString(1) + " " +
                        rs.getString(2) + " " +
                        rs.getString(3) + " " +
                        rs.getString(4));
            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
