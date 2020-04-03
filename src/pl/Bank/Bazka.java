package pl.Bank;

import java.sql.*;

public class Bazka {
    public final static String createTableSql =
            "CREATE TABLE dbo.Bank_Account" +
            "(" +
            "name nvarchar(100) not null," +
            "pesel nvarchar(11) not null," +
            "account_number nvarchar(28) not null)";
    public void connectionDB() throws SQLException {
        DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
        Connection conn = null;

        try {
            String dbUrl = "jdbc:sqlserver://localhost:1433;";
            //String dbUrl = "jdbc:sqlserver://localhost:1433;integratedSecurity=true;";
            String user = "sa";
            String pass = "tajemnica";
            conn = DriverManager.getConnection(dbUrl, user, pass);
            if (conn != null) {
                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Driver version: " + dm.getDriverVersion());
                System.out.println("Product name: " + dm.getDatabaseProductName());
                System.out.println("Product version: " + dm.getDatabaseProductVersion());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        /*finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        "IF NOT EXISTS" +
            "(SELECT 1" +
            "FROM sysobjects o" +
            "WHERE (o.name = 'Bank_Account')" +
            "AND (OBJECTPROPERTY (o.[id], 'IsUserTable') = 1))" +
            "BEGIN " +*/
        Statement statement = conn.createStatement();
        statement.execute(createTableSql);
    }
}
