package SurveyDemo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;


public class translateData {
	private ResultSet resultSet = null;
	private LinkedList<String> questions = new LinkedList<>();
	private LinkedList<String[]> choices = new LinkedList<>();
	private ArrayList<String> questionID = new ArrayList<>();
	private ArrayList<String> questionType = new ArrayList<>();
	private Connection connection = null;
	private Statement st = null;
	private String uuid = "";
	private String SID = "";
	
	
	public translateData() {
		try {
			connection = databaseConnection.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getData(String uuid) throws SQLException {
		this.uuid = uuid;
		
		st = null;
		String sql = "select * from patient_survey;";
		st = connection.createStatement();
		resultSet = st.executeQuery(sql);
		
		questionID.clear();
		questions.clear();
		choices.clear();
		questionType.clear();
		
		getSurvey();
		
	}
	
	private void getSurvey() throws SQLException {
		while(resultSet.next()){
			if (resultSet.getString(1).equals(uuid)) {
				SID = resultSet.getString(2);
				break;
			}
		}
		getQuestions();
	}
	
	private void getQuestions() throws SQLException {
		
		String sql = "select * from survey_question " + "where SID = '" + SID + "';";
		resultSet = st.executeQuery(sql);
		
		while(resultSet.next()){
			questions.add(resultSet.getString(2));
			questionType.add(resultSet.getString(4));
			questionID.add(resultSet.getString(1));
		}
		
		getAnswer();
	}
	
	private void getAnswer() throws SQLException {
		ArrayList<String> qAnswer = new ArrayList<>();
		
		
		for(String QID: questionID){
			String sql = "select * from survey_answer " + "where QID = '" + QID + "';";
			resultSet = st.executeQuery(sql);
			qAnswer.clear();
			if (!resultSet.wasNull()) {
				while(resultSet.next()){
					qAnswer.add(resultSet.getString(2));
				}
				choices.add(qAnswer.toArray(new String[qAnswer.size()]));
			}	
		}
		
	}
	
	public boolean existSurvey(String uuid) {
		String tempUUID = uuid;
		String sql = "select * from patient_survey where uuid='"+tempUUID+"';";
		try {
			st = connection.createStatement();
			resultSet = st.executeQuery(sql);
			while (resultSet.next()) {
				if (resultSet.getString(1).equals(tempUUID)) {
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public ArrayList<String> getQuestionID() {
		return questionID;
	}
	
	public ArrayList<String> getQuestionType() {
		return questionType;
	}
	
	public LinkedList<String[]> getChoices() {
		return choices;
	}
	
	public LinkedList<String> getQuestion() {
		return questions;
	}
	
	public String getSID() {
		return SID;
	}
}
