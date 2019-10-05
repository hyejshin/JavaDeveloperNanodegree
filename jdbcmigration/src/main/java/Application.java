import java.sql.*;

import org.flywaydb.core.Flyway;

public class Application {

    public static void main(String[] args) throws Exception{
        // STEP 1: Create the JDBC URL for JDND_C3 database
        try{
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdnd_c3?user=root&password=mysql123")) {
                System.out.println("Connecte to " + conn.getMetaData().getDatabaseProductName());

            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        // STEP 2: Setup and Run Flyway migration that creates the member table using its Java API
        // https://flywaydb.org/getstarted/firststeps/api#integrating-flyway
        // Note the above link talks about connecting to H2 database, for this exercise, MySQL is used. Adapt the code accordingly.
        // Create the Flyway instance and point it to the database
        Flyway flyway = Flyway.configure().dataSource("jdbc:mysql://localhost:3306/jdnd_c3", "root", "mysql123").load();
        // Start the migration
        flyway.migrate();
        System.out.println("Migration is successful");

        // STEP 3: Obtain a connection to the JDND-C3 database
        // STEP 4: Use Statement to INSERT 2 records into the member table
        // NOTE: The member table is created using Flyway by placing the migration file in src/main/resources/db/migration
        // STEP 5: Read ALL the rows from the member table and print them here
        // STEP 6: verify that all inserted rows have been printed
        try{
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdnd_c3?user=root&password=mysql123")) {
                System.out.println("Connect to " + conn.getMetaData().getDatabaseProductName());

                PreparedStatement pstmt = conn.prepareStatement("INSERT INTO MEMBERS (NAME) VALUES (?)");
                pstmt.setString(1, "HYEJUNG");
                pstmt.execute();
                pstmt.setString(1, "JENNY");
                pstmt.execute();

                try (Statement stmt = conn.createStatement()) {
                    try (ResultSet rs = stmt.executeQuery("SELECT ID, NAME from MEMBERS")) {
                        System.out.println("Executed SQL query");

                        while (rs.next()) {
                            int id = rs.getInt("ID");
                            String name = rs.getString("NAME");

                            System.out.println("ID: " + id);
                            System.out.println("Name: " + name);
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

}