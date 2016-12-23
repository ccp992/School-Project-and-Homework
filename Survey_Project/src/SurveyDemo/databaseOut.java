package SurveyDemo;
//import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class databaseOut {

	
	private static String url = "jdbc:mysql://192.168.137.129:3306/survey" + "?verifyServerCertificate=false"
			+ "&useSSL=true" + "&requireSSL=true";

	private static String user = "survey";

	private static String pass = "survey";

	@Test
	public void getConnection() throws SQLException {

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

		// sql command testing
		ResultSet resultSet = null;
		Statement st = null;
		try {
			st = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String sql = "select * from patient_survey;";

		try {
			resultSet = st.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (resultSet.next()) {
			try {
				System.out.println(resultSet.getString(1));
				System.out.println("*************************************");
				System.out.println(resultSet.getString(2));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		//return connection;

	}

}
