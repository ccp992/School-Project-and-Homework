package SurveyDemo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class databaseConnection {
	
	private static String url = "jdbc:mysql://192.168.137.129:3306/survey" +
								"?verifyServerCertificate=false" +
								"&useSSL=true" +
								"&requireSSL=true";
	
	private static String user = "survey";
	
	private static String pass = "survey";
	
	public static Connection getConnection() throws SQLException {

		Connection connection = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			connection = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return connection;
		
	}
}
