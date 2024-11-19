package CheckBalanceGUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Account_Statement_Database {

	
	    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/signup";
	    private static final String USER = "root";
	    private static final String PASS = "123jed";

	    public static Connection getConnection() throws SQLException {
	        return DriverManager.getConnection(DB_URL, USER, PASS);
	    }

	    public static void closeConnection(Connection conn) {
	        if (conn != null) {
	            try {
	                conn.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    public static boolean insertAccountstatement(double balance, double deposit, double withdrawal, long timestamp) {
	        Connection conn = null;
	        PreparedStatement stmt = null;

	        try {
	            conn = getConnection();
	            String sql = "INSERT INTO accountstatement (Balance, Deposit, Withdrawal, Date) VALUES (?, ?, ?, ?)";
	            stmt = conn.prepareStatement(sql);
	            stmt.setDouble(1, balance);   
	            stmt.setDouble(2, deposit);   
	            stmt.setDouble(3, withdrawal); 
	            stmt.setTimestamp(4, new java.sql.Timestamp(timestamp)); 

	            int rowsAffected = stmt.executeUpdate();
	            return rowsAffected > 0;  
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        } finally {
	            if (stmt != null) {
	                try {
	                    stmt.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	            closeConnection(conn);
	        }
	    }
}