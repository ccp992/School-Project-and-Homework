

public class Project1 {
	public static void main(String args[]) {;
		TextFileInput dataInput = new TextFileInput("project1.txt");
		Polynomial input_data = new Polynomial();
		String expression_one = dataInput.readLine();
		String expression_two = dataInput.readLine();
		String operator = dataInput.readLine();
		while(expression_one != null && expression_two != null && operator != null){
			//System.out.println(operator);
			input_data.createPolynomial(expression_one, expression_two, operator);
			expression_one = dataInput.readLine();
			expression_two = dataInput.readLine();
			operator = dataInput.readLine();
		}
	}

}
