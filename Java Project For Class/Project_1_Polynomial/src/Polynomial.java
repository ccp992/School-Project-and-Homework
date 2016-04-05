import java.util.StringTokenizer;
/**
 * 
 * @author Cai Peng Chen
 *
 */
public class Polynomial {
	private StringTokenizer dataToken;
	private DataProcess process;
	private DoublyLinkedList<Term> func;
	private DoublyLinkedList<Term> func_one;
	private DoublyLinkedList<Term> func_two;
	private DoublyLinkedList<Term> func_result;
	private Term func_term;
	
	public Polynomial() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Receive expression_one and expression_two and operator string from project1.txt file
	 * Check both expressions string if there is a none digit char then print out illegal input data warning
	 * After string checking has done, then convert expression strings into function one and function two DoublyLinkList class;
	 * Then call a specific operation method based on the operator string
	 * @param expression_one
	 * @param expression_two
	 * @param operator
	 */
	public void createPolynomial(String expression_one, String expression_two, String operator){
		func_one = new DoublyLinkedList<Term>();
		func_two = new DoublyLinkedList<Term>();
		process = new DataProcess();
		
		if (!process.dataCheck(expression_one) || !process.dataCheck(expression_two) || !process.dataCheck(operator)) {
			illegalInput();
			return;
		}
		if (operator.equalsIgnoreCase("add")) {
			func_one = createFunction(expression_one);
			func_two = createFunction(expression_two);
			add();
			return;
		}
		if (operator.equalsIgnoreCase("subtract")) {
			func_one = createFunction(expression_one);
			func_two = createFunction(expression_two);
			subtract();
			return;
		}
		if (operator.equalsIgnoreCase("multiply")) {
			func_one = createFunction(expression_one);
			func_two = createFunction(expression_two);
			multiply();
			return;
		}
	}
	/**
	 * This method converts string to DoublyLinkList method
	 * Use the string pass from creatPolynomial method
	 * Take each char data from string data put them into Term class
	 * @param data function String data
	 * @return
	 */
	public DoublyLinkedList<Term> createFunction(String data) {
		double tempCoefficient = 0.0d;
		int tempExponent = 0;
		dataToken = new StringTokenizer(data, " ");
		func = new DoublyLinkedList<Term>();
		while (dataToken.hasMoreTokens()) {
			func_term = new Term();
			tempCoefficient = Double.parseDouble(dataToken.nextToken());
			tempExponent = Integer.parseInt(dataToken.nextToken());
			func_term.setCoefficient(tempCoefficient);
			func_term.setExponent(tempExponent);
			addToList(func_term, func);
		}
		return func;
	}
	
	/**
	 * Add function one and function two
	 */
	public void add() {
		func_result = new DoublyLinkedList<Term>();
		for (int i = 0; i < func_one.size(); i++) {
			addToList(func_one.get(i), func_result);
		}
		for (int i = 0; i < func_two.size();i++) {
			addToList(func_two.get(i), func_result);
		}
		System.out.println(outputToString("+"));
	}
	
	/**
	 * Multiply the second function by -1 first
	 * then add function one and two together
	 */
	private void subtract() {
		func_result = new DoublyLinkedList<Term>();
		DoublyLinkedList<Term> tempFunc = new DoublyLinkedList<>();
		
		for (int i = 0; i < func_two.size(); i++) {
			Term tempTerm = new Term();
			tempTerm.setCoefficient(-1*func_two.get(i).getCoefficient());
			tempTerm.setExponent(func_two.get(i).getExponent());
			tempFunc.add(tempTerm);
		}
		
		for (int i = 0; i < tempFunc.size();i++) {
			addToList(tempFunc.get(i), func_result);
		}
		for (int i = 0; i < func_one.size(); i++) {
			addToList(func_one.get(i), func_result);
		}
		System.out.println(outputToString("-"));
	}
	/**
	 * Multiply function one and function two terms together and put them into result function
	 */
	private void multiply() {
		func_result = new DoublyLinkedList<Term>();
		for (int i = 0; i < func_one.size(); i++) {
			for (int j = 0; j < func_two.size(); j++) {
				Term tempTerm = new Term();
				tempTerm.setCoefficient(func_one.get(i).getCoefficient() * func_two.get(j).getCoefficient());
				tempTerm.setExponent(func_one.get(i).getExponent() + func_two.get(j).getExponent());
				addToList(tempTerm, func_result);
			}
		}
		System.out.println(outputToString("*"));
	}
	
	/**
	 *
	 * operator parameter use for determine operator sign -, +, * for  output string
	 * then parse function one, two and result function into output string
	 * then return output string for print out.
	 * 
	 * In this method: when coefficient is 1 or -1 and exponent is 0 or 1
	 * 					final output will be x or 1 or -x or -1
	 * @param operator
	 * @return
	 */
	private String outputToString(String operator) {
		String resultFunc = "";
		String funcOne = "";
		String funcTwo = "";
		String outputFunc = "";
		if (func_one.get(0).getCoefficient() == -1 && func_one.get(0).getExponent() != 1 && func_one.get(0).getExponent() != 0) {
			funcOne = "-x^" + Integer.toString(func_one.get(0).getExponent());
		}else if(func_one.get(0).getCoefficient() == -1 && func_one.get(0).getExponent() == 1){
			funcOne = "-x";
		}else if(func_one.get(0).getCoefficient() == 1 && func_one.get(0).getExponent() != 1){
			funcOne = "x^" + Integer.toString(func_one.get(0).getExponent());
		}else if(func_one.get(0).getExponent() == 0){
			funcOne = Double.toString(func_one.get(0).getCoefficient());
		}else if(func_one.get(0).getCoefficient() == 1 && func_one.get(0).getExponent() == 1){
			funcOne = "x";
		}else if(func_one.get(0).getExponent() == 1 && func_one.get(0).getCoefficient() != 1){
			funcOne = Double.toString(func_one.get(0).getCoefficient()) + "x";
		}
		else{
			funcOne = Double.toString(func_one.get(0).getCoefficient()) + "x^" + Integer.toString(func_one.get(0).getExponent());
		}
		
		for (int i = 1; i < func_one.size(); i++) {
			if (func_one.get(i).getCoefficient() == -1 && func_one.get(0).getExponent() != 1 && func_one.get(0).getExponent() != 0) {
				funcOne = funcOne + "-x^" + Integer.toString(func_one.get(i).getExponent());
			}else if(func_one.get(i).getCoefficient() < 0 && func_one.get(i).getExponent() == 1){
				funcOne = funcOne + Double.toString(func_one.get(i).getCoefficient()) + "x";
			}else if(func_one.get(i).getCoefficient() == 1 && func_one.get(i).getExponent() != 1){
				funcOne = funcOne + "+" + "x^" + Integer.toString(func_one.get(i).getExponent());
			}else if(func_one.get(i).getCoefficient() == -1 && func_one.get(i).getExponent() == 1){
				funcOne = funcOne + "-x";
			}else if(func_one.get(i).getCoefficient() > 0 && func_one.get(i).getExponent() == 1){
				funcOne = funcOne + "+" + Double.toString(func_one.get(i).getCoefficient()) + "x";
			}else if (func_one.get(i).getExponent() == 0 && func_one.get(i).getCoefficient() > 0) {
				funcOne = funcOne + "+" + Double.toString(func_one.get(i).getCoefficient());
			}else if (func_one.get(i).getExponent() == 0 && func_one.get(i).getCoefficient() < 0) {
				funcOne = funcOne + Double.toString(func_one.get(i).getCoefficient());
			}else if (func_one.get(i).getCoefficient() < 0 && func_one.get(i).getExponent() != 0) {
				funcOne = funcOne + Double.toString(func_one.get(i).getCoefficient()) + "x" + Integer.toString(func_one.get(i).getExponent());
			}
			else {
				funcOne = funcOne + "+" + Double.toString(func_one.get(i).getCoefficient()) + "x^" + Integer.toString(func_one.get(i).getExponent());
			}
		}
		funcOne = funcOne + "\n";
		
		if (func_two.get(0).getCoefficient() == -1 && func_two.get(0).getExponent() != 1 && func_two.get(0).getExponent() != 0) {
			funcTwo = "-x^" + Integer.toString(func_two.get(0).getExponent());
		}else if(func_two.get(0).getCoefficient() == -1 && func_two.get(0).getExponent() == 1){
			funcTwo = "-x";
		}else if(func_two.get(0).getCoefficient() == 1 && func_two.get(0).getExponent() != 1){
			funcTwo = "x^" + Integer.toString(func_two.get(0).getExponent());
		}else if(func_two.get(0).getExponent() == 0){
			funcTwo = Double.toString(func_two.get(0).getCoefficient());
		}else if(func_two.get(0).getCoefficient() == 1 && func_two.get(0).getExponent() == 1){
			funcTwo = "x";
		}else if(func_two.get(0).getExponent() == 1 && func_two.get(0).getCoefficient() != 1){
			funcTwo = Double.toString(func_two.get(0).getCoefficient()) + "x";
		}
		else{
			funcTwo = Double.toString(func_two.get(0).getCoefficient()) + "x^" + Integer.toString(func_two.get(0).getExponent());
		}
		
		for (int i = 1; i < func_two.size(); i++) {
			if (func_two.get(i).getCoefficient() == -1 && func_two.get(0).getExponent() != 1 && func_two.get(0).getExponent() != 0) {
				funcTwo = funcTwo + "-x^" + Integer.toString(func_two.get(i).getExponent());
			}else if(func_two.get(i).getCoefficient() < 0 && func_two.get(i).getExponent() == 1){
				funcTwo = funcTwo + Double.toString(func_two.get(i).getCoefficient()) + "x";
			}else if(func_two.get(i).getCoefficient() == 1 && func_two.get(i).getExponent() != 1){
				funcTwo = funcTwo + "+" + "x^" + Integer.toString(func_two.get(i).getExponent());
			}else if(func_two.get(i).getCoefficient() == -1 && func_two.get(i).getExponent() == 1){
				funcTwo = funcTwo + "-x";
			}else if(func_two.get(i).getCoefficient() > 0 && func_two.get(i).getExponent() == 1){
				funcTwo = funcTwo + "+" + Double.toString(func_two.get(i).getCoefficient()) + "x";
			}else if (func_two.get(i).getExponent() == 0 && func_two.get(i).getCoefficient() > 0) {
				funcTwo = funcTwo + "+" + Double.toString(func_two.get(i).getCoefficient());
			}else if (func_two.get(i).getExponent() == 0 && func_two.get(i).getCoefficient() < 0) {
				funcTwo = funcTwo + Double.toString(func_two.get(i).getCoefficient());
			}else if (func_two.get(i).getCoefficient() < 0 && func_two.get(i).getExponent() != 0) {
				funcTwo = funcTwo + Double.toString(func_two.get(i).getCoefficient()) + "x" + Integer.toString(func_two.get(i).getExponent());
			}
			else {
				funcTwo = funcTwo + "+" + Double.toString(func_two.get(i).getCoefficient()) + "x^" + Integer.toString(func_two.get(i).getExponent());
			}
		}
		
		funcTwo = funcTwo + "\n";
		
		if (func_result.get(0).getCoefficient() == -1 && func_result.get(0).getExponent() != 1 && func_result.get(0).getExponent() != 0) {
			resultFunc = "-x^" + Integer.toString(func_result.get(0).getExponent());
		}else if(func_result.get(0).getCoefficient() == -1 && func_result.get(0).getExponent() == 1){
			resultFunc = "-x";
		}else if(func_result.get(0).getCoefficient() == 1 && func_result.get(0).getExponent() != 1){
			resultFunc = "x^" + Integer.toString(func_result.get(0).getExponent());
		}else if(func_result.get(0).getExponent() == 0){
			resultFunc = Double.toString(func_result.get(0).getCoefficient());
		}else if(func_result.get(0).getCoefficient() == 1 && func_result.get(0).getExponent() == 1){
			resultFunc = "x";
		}else if(func_result.get(0).getExponent() == 1 && func_result.get(0).getCoefficient() != 1){
			resultFunc = Double.toString(func_result.get(0).getCoefficient()) + "x";
		}
		else{
			resultFunc = Double.toString(func_result.get(0).getCoefficient()) + "x^" + Integer.toString(func_result.get(0).getExponent());
		}
		
		for (int i = 1; i < func_result.size(); i++) {
			if (func_result.get(i).getCoefficient() == -1 && func_result.get(0).getExponent() != 1 && func_result.get(0).getExponent() != 0) {
				resultFunc = resultFunc + "-x^" + Integer.toString(func_result.get(i).getExponent());
			}else if(func_result.get(i).getCoefficient() < 0 && func_result.get(i).getExponent() == 1){
				resultFunc = resultFunc + Double.toString(func_result.get(i).getCoefficient()) + "x";
			}else if(func_result.get(i).getCoefficient() == 1 && func_result.get(i).getExponent() != 1){
				resultFunc = resultFunc + "+" + "x^" + Integer.toString(func_result.get(i).getExponent());
			}else if(func_result.get(i).getCoefficient() == -1 && func_result.get(i).getExponent() == 1){
				resultFunc = resultFunc + "-x";
			}else if(func_result.get(i).getCoefficient() > 0 && func_result.get(i).getExponent() == 1){
				resultFunc = resultFunc + "+" + Double.toString(func_result.get(i).getCoefficient()) + "x";
			}else if (func_result.get(i).getExponent() == 0 && func_result.get(i).getCoefficient() > 0) {
				resultFunc = resultFunc + "+" + Double.toString(func_result.get(i).getCoefficient());
			}else if (func_result.get(i).getExponent() == 0 && func_result.get(i).getCoefficient() < 0) {
				resultFunc = resultFunc + Double.toString(func_result.get(i).getCoefficient());
			}
			else {
				resultFunc = resultFunc + "+" + Double.toString(func_result.get(i).getCoefficient()) + "x^" + Integer.toString(func_result.get(i).getExponent());
			}
		}
		outputFunc = funcOne + operator + "\n" + funcTwo + "=\n" + resultFunc + "\n";
		return outputFunc;
	}
	/*private String toStringTest(DoublyLinkedList<Term> data) {
		String temp = "";
		for (int i = 0; i < data.size(); i++) {
			temp = temp + Double.toString(data.get(i).getCoefficient()) + "x^" + Integer.toString(data.get(i).getExponent()) + " "; 
		}
		return temp;
	}*/
	/**
	 * Each term will be add based on its exponent and sort as descending orders
	 * This method also omit the term which has coefficient 0.
	 * In this method, there is addition operation when termData's exponent is equal to term's exponent in the funcData.
	 * @param termData
	 * @param funcData
	 */
	private void addToList(Term termData, DoublyLinkedList<Term> funcData) {
		Term tempTerm = new Term();
		if (termData.getCoefficient() == 0) {
			return;
		}
		if (funcData.size() == 0) {
			funcData.add(termData);
		}else {
			for (int i = 0; i < funcData.size(); i++) {
				if (termData.getExponent() == funcData.get(i).getExponent()) {
					tempTerm.setCoefficient(termData.getCoefficient() + funcData.get(i).getCoefficient());
					tempTerm.setExponent(termData.getExponent());
					funcData.set(i, tempTerm);
					break;
				}
				if (termData.getExponent() > funcData.get(i).getExponent()) {
					funcData.add(i, termData);
					break;
				}
				if (termData.getExponent() < funcData.get(i).getExponent() && i == funcData.size()-1) {
					funcData.add(termData);
					break;
					}
			}
		}
	}

	/**
	 * Act as exception call
	 */
	private void illegalInput() {
		System.out.println("Illegal Input Data!\n");
	}
	
	public String toString() {
		String resultFunc = "";
		String funcOne = "";
		String funcTwo = "";
		String outputFunc = "";
		if (func_one.get(0).getCoefficient() == -1 && func_one.get(0).getExponent() != 1 && func_one.get(0).getExponent() != 0) {
			funcOne = "-x^" + Integer.toString(func_one.get(0).getExponent());
		}else if(func_one.get(0).getCoefficient() == -1 && func_one.get(0).getExponent() == 1){
			funcOne = "-x";
		}else if(func_one.get(0).getCoefficient() == 1 && func_one.get(0).getExponent() != 1){
			funcOne = "x^" + Integer.toString(func_one.get(0).getExponent());
		}else if(func_one.get(0).getExponent() == 0){
			funcOne = Double.toString(func_one.get(0).getCoefficient());
		}else if(func_one.get(0).getCoefficient() == 1 && func_one.get(0).getExponent() == 1){
			funcOne = "x";
		}else if(func_one.get(0).getExponent() == 1 && func_one.get(0).getCoefficient() != 1){
			funcOne = Double.toString(func_one.get(0).getCoefficient()) + "x";
		}
		else{
			funcOne = Double.toString(func_one.get(0).getCoefficient()) + "x^" + Integer.toString(func_one.get(0).getExponent());
		}
		
		for (int i = 1; i < func_one.size(); i++) {
			if (func_one.get(i).getCoefficient() == -1 && func_one.get(0).getExponent() != 1 && func_one.get(0).getExponent() != 0) {
				funcOne = funcOne + "-x^" + Integer.toString(func_one.get(i).getExponent());
			}else if(func_one.get(i).getCoefficient() < 0 && func_one.get(i).getExponent() == 1){
				funcOne = funcOne + Double.toString(func_one.get(i).getCoefficient()) + "x";
			}else if(func_one.get(i).getCoefficient() == 1 && func_one.get(i).getExponent() != 1){
				funcOne = funcOne + "+" + "x^" + Integer.toString(func_one.get(i).getExponent());
			}else if(func_one.get(i).getCoefficient() == -1 && func_one.get(i).getExponent() == 1){
				funcOne = funcOne + "-x";
			}else if(func_one.get(i).getCoefficient() > 0 && func_one.get(i).getExponent() == 1){
				funcOne = funcOne + "+" + Double.toString(func_one.get(i).getCoefficient()) + "x";
			}else if (func_one.get(i).getExponent() == 0 && func_one.get(i).getCoefficient() > 0) {
				funcOne = funcOne + "+" + Double.toString(func_one.get(i).getCoefficient());
			}else if (func_one.get(i).getExponent() == 0 && func_one.get(i).getCoefficient() < 0) {
				funcOne = funcOne + Double.toString(func_one.get(i).getCoefficient());
			}
			else {
				funcOne = funcOne + "+" + Double.toString(func_one.get(i).getCoefficient()) + "x^" + Integer.toString(func_one.get(i).getExponent());
			}
		}
		funcOne = funcOne + "\n";
		
		if (func_two.get(0).getCoefficient() == -1 && func_two.get(0).getExponent() != 1 && func_two.get(0).getExponent() != 0) {
			funcTwo = "-x^" + Integer.toString(func_two.get(0).getExponent());
		}else if(func_two.get(0).getCoefficient() == -1 && func_two.get(0).getExponent() == 1){
			funcTwo = "-x";
		}else if(func_two.get(0).getCoefficient() == 1 && func_two.get(0).getExponent() != 1){
			funcTwo = "x^" + Integer.toString(func_two.get(0).getExponent());
		}else if(func_two.get(0).getExponent() == 0){
			funcTwo = Double.toString(func_two.get(0).getCoefficient());
		}else if(func_two.get(0).getCoefficient() == 1 && func_two.get(0).getExponent() == 1){
			funcTwo = "x";
		}else if(func_two.get(0).getExponent() == 1 && func_two.get(0).getCoefficient() != 1){
			funcTwo = Double.toString(func_two.get(0).getCoefficient()) + "x";
		}
		else{
			funcTwo = Double.toString(func_two.get(0).getCoefficient()) + "x^" + Integer.toString(func_two.get(0).getExponent());
		}
		
		for (int i = 1; i < func_two.size(); i++) {
			if (func_two.get(i).getCoefficient() == -1 && func_two.get(0).getExponent() != 1 && func_two.get(0).getExponent() != 0) {
				funcTwo = funcTwo + "-x^" + Integer.toString(func_two.get(i).getExponent());
			}else if(func_two.get(i).getCoefficient() < 0 && func_two.get(i).getExponent() == 1){
				funcTwo = funcTwo + Double.toString(func_two.get(i).getCoefficient()) + "x";
			}else if(func_two.get(i).getCoefficient() == 1 && func_two.get(i).getExponent() != 1){
				funcTwo = funcTwo + "+" + "x^" + Integer.toString(func_two.get(i).getExponent());
			}else if(func_two.get(i).getCoefficient() == -1 && func_two.get(i).getExponent() == 1){
				funcTwo = funcTwo + "-x";
			}else if(func_two.get(i).getCoefficient() > 0 && func_two.get(i).getExponent() == 1){
				funcTwo = funcTwo + "+" + Double.toString(func_two.get(i).getCoefficient()) + "x";
			}else if (func_two.get(i).getExponent() == 0 && func_two.get(i).getCoefficient() > 0) {
				funcTwo = funcTwo + "+" + Double.toString(func_two.get(i).getCoefficient());
			}else if (func_two.get(i).getExponent() == 0 && func_two.get(i).getCoefficient() < 0) {
				funcTwo = funcTwo + Double.toString(func_two.get(i).getCoefficient());
			}
			else {
				funcTwo = funcTwo + "+" + Double.toString(func_two.get(i).getCoefficient()) + "x^" + Integer.toString(func_two.get(i).getExponent());
			}
		}
		
		funcTwo = funcTwo + "\n";
		
		if (func_result.get(0).getCoefficient() == -1 && func_result.get(0).getExponent() != 1 && func_result.get(0).getExponent() != 0) {
			resultFunc = "-x^" + Integer.toString(func_result.get(0).getExponent());
		}else if(func_result.get(0).getCoefficient() == -1 && func_result.get(0).getExponent() == 1){
			resultFunc = "-x";
		}else if(func_result.get(0).getCoefficient() == 1 && func_result.get(0).getExponent() != 1){
			resultFunc = "x^" + Integer.toString(func_result.get(0).getExponent());
		}else if(func_result.get(0).getExponent() == 0){
			resultFunc = Double.toString(func_result.get(0).getCoefficient());
		}else if(func_result.get(0).getCoefficient() == 1 && func_result.get(0).getExponent() == 1){
			resultFunc = "x";
		}else if(func_result.get(0).getExponent() == 1 && func_result.get(0).getCoefficient() != 1){
			resultFunc = Double.toString(func_result.get(0).getCoefficient()) + "x";
		}
		else{
			resultFunc = Double.toString(func_result.get(0).getCoefficient()) + "x^" + Integer.toString(func_result.get(0).getExponent());
		}
		
		for (int i = 1; i < func_result.size(); i++) {
			if (func_result.get(i).getCoefficient() == -1 && func_result.get(0).getExponent() != 1 && func_result.get(0).getExponent() != 0) {
				resultFunc = resultFunc + "-x^" + Integer.toString(func_result.get(i).getExponent());
			}else if(func_result.get(i).getCoefficient() < 0 && func_result.get(i).getExponent() == 1){
				resultFunc = resultFunc + Double.toString(func_result.get(i).getCoefficient()) + "x";
			}else if(func_result.get(i).getCoefficient() == 1 && func_result.get(i).getExponent() != 1){
				resultFunc = resultFunc + "+" + "x^" + Integer.toString(func_result.get(i).getExponent());
			}else if(func_result.get(i).getCoefficient() == -1 && func_result.get(i).getExponent() == 1){
				resultFunc = resultFunc + "-x";
			}else if(func_result.get(i).getCoefficient() > 0 && func_result.get(i).getExponent() == 1){
				resultFunc = resultFunc + "+" + Double.toString(func_result.get(i).getCoefficient()) + "x";
			}else if (func_result.get(i).getExponent() == 0 && func_result.get(i).getCoefficient() > 0) {
				resultFunc = resultFunc + "+" + Double.toString(func_result.get(i).getCoefficient());
			}else if (func_result.get(i).getExponent() == 0 && func_result.get(i).getCoefficient() < 0) {
				resultFunc = resultFunc + Double.toString(func_result.get(i).getCoefficient());
			}
			else {
				resultFunc = resultFunc + "+" + Double.toString(func_result.get(i).getCoefficient()) + "x^" + Integer.toString(func_result.get(i).getExponent());
			}
		}
		outputFunc = funcOne + "\n" + funcTwo + "=\n" + resultFunc + "\n";
		return outputFunc;
	}
}
