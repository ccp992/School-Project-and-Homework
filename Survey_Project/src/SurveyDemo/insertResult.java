package SurveyDemo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class insertResult {
	private Connection connection;
	private ResultSet resultSet = null;
	private Statement st = null;
	
	public insertResult() {
		try {
			connection = databaseConnection.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insertSql(String uuid,String sid, String qid, String anString) {

		if (anString.contains("'")) {
			anString = anString.replaceAll("'", "\'\'");
		}
		
		String sql = "INSERT INTO survey_result VALUES( " + "'" + uuid + "'" + "," + "'" + sid + "'" + "," + "'"
				+ qid + "'" + "," + "'" + anString + "'" + ");";
		
		System.out.println(sql);
		try {
			connection.createStatement().executeUpdate(sql);
			System.out.println("successfully inserted");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 

	}

	public boolean isExist(String uuid) throws SQLException {
		String sql = "select * from survey_result;";
		st = connection.createStatement();
		resultSet = st.executeQuery(sql);
		
		while (resultSet.next()) {
			if (resultSet.getString(1).equals(uuid)) {
				String tempSQL = "delete from survey_result where uuid='"+uuid+"';";
				connection.createStatement().executeUpdate(tempSQL);
				return true;
			}
		}
		
		return false;
	}
	
	/*public String SQLfilter(String sql) {
		StringBuffer stringBuffer = new StringBuffer();
		char temp = ' ';
		for(int i=0;i<sql.length(); i++){
			temp = sql.charAt(i);
			if (temp == '\'') {
				stringBuffer.append('\'').append('\'');
			}
			stringBuffer.append(temp);
		}
		
		return stringBuffer.toString();
	}*/
	
	/*public void updateTable(String uuid,String sid, String qid, String anString) {
		String sql = "update survey_result set feedback='"+anString + "' where uuid='"+uuid+"' and qid='"+qid+"' and sid='"+sid+"';";
		try {
			connection.createStatement().executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}*/
}
