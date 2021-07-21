import java.sql.*;

public class TabelleErstellen {

    public static void main (String args[]) {
        String url = "jdbc:mysql://localhost:3306/falconbyte";
        String name = "root";
        String pass = "";

        String sql = "CREATE TABLE meine_tabelle (id INTEGER, name VARCHAR(20), betrag DECIMAL(6,2));";
        String abfrage = "SHOW COLUMNS FROM meine_tabelle";
        String insert = "INSERT INTO meine_tabelle (id, name, betrag) VALUES (1, 'IPhone', 899.9)";

        try {
            Connection con = DriverManager.getConnection(url, name, pass);
            System.out.println("Verbindung erfolgreich hergestellt.");

            Statement stm = con.createStatement();

            // Create Table
            /*
            stm.execute(sql);
            */

            //Show Columns
            ResultSet rs = stm.executeQuery(abfrage);
            while(rs.next()) {
                System.out.println(rs.getString(1) + " " +
                        rs.getString(2));
            }

            // Insert
            stm.execute(insert);
            abfrage = "SELECT * FROM meine_tabelle";
            rs = stm.executeQuery(abfrage);
            while(rs.next()) {
                System.out.println(rs.getString(1) + " " +
                        rs.getString(2) + " " +
                        rs.getString(3));
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
