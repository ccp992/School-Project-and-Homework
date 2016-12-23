package SurveyDemo;


public class surveyQuestion {
	
	private String type = "";
	private String name = "";
	private String question = "";
	private String[] choice = null;
	private String length = "";
	
	
	public void setMaxLength(String length) {
		this.length = length;
	}
	
	public String getLength() {
		return this.length;
	}
	
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public String getQuestion() {
		return question;
	}
	
	public void setChoice(String[] choice) {
		this.choice = choice;
	}
	
	public String[] getChoice() {
		return choice;
	}
	
	public void setType(String type) {
		this.type=type;
	}
	
	public String getType() {
		return type;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

}
