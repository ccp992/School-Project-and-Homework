package SurveyDemo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class surveyList {

	private Connection connection;
	private ArrayList<String> uuidList;
	private ArrayList<String> surveyName;
	private ResultSet resultSet = null;
	private Statement st = null;
	
	public surveyList() {
		// TODO Auto-generated constructor stub
		uuidList = new ArrayList<>();
		surveyName = new ArrayList<>();
		try {
			connection = databaseConnection.getConnection();
			getList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void getList() throws SQLException {
		String sql = "select uuid, survey_title"
				+ "	from survey, patient_survey"
				+ "	where survey.SID = patient_survey.SID;";
		st = connection.createStatement();
		resultSet = st.executeQuery(sql);
		
		while(resultSet.next()){
			uuidList.add(resultSet.getString(1));
			surveyName.add(resultSet.getString(2));
		}
	}
	
	public String[] getUUID() {
		String[] uuid;
		uuid = uuidList.toArray(new String[uuidList.size()]);
		
		return uuid;
	}
	
	public String[] getSurveyName() {
		String[] survey;
		survey = surveyName.toArray(new String[surveyName.size()]);
		
		return survey;
	}
}
