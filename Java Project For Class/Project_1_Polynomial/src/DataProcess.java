/**
 * 
 * @author Cai Peng Chen
 *
 */

import java.util.StringTokenizer;



public class DataProcess {
	private boolean pass = true;
	private String digits,operator;
	private int counter = 0;
	private StringTokenizer digitCheck;
	
	/**
	 * The general entry for String checking.
	 * check the raw data see if it contains either a operator or even number of digits.
	 * @param rawData
	 * @return
	 */
	public boolean dataCheck(String rawData){
		if (isOperator(rawData)) {
			return pass;
		}if (!evenDigits(rawData)) {
			return !pass;
		}else {
			digitCheck = new StringTokenizer(rawData, " ");
			String temp = "";
			while(digitCheck.hasMoreTokens()){
				temp = digitCheck.nextToken();
				if (!isDouble(temp) || !isInteger(temp)) {
					return !pass;
				}
			}
			return pass;
		}
	}
	
	/**
	 * check the string data, if the string data has even number of char return true otherwise false.
	 * @param data
	 * @return
	 */
	private boolean evenDigits(String data) {
		digitCheck = new StringTokenizer(data, " ");
		if (digitCheck.countTokens()%2 != 0) {
			return !pass;
		}
		return pass;
	}
	
	/**
	 * Check the string data, if the string data has char that is not convertible then return false otherwise return true.
	 * @param data
	 * @return
	 */
	private boolean isInteger(String data) {
		int temp;
		try {
			temp = Integer.parseInt(data);
		} catch (NumberFormatException e) {
			// TODO: handle exception
			return !pass;
		}
		return pass;
	}
	/**
	 * Check the string data, if the string data has char that is not convertible then return false otherwise return true
	 * @param data
	 * @return
	 */
	private boolean isDouble(String data) {
		double temp;
		try {
			temp = Double.parseDouble(data);
		} catch (NumberFormatException e) {
			// TODO: handle exception
			return !pass;
		}
		return pass;
	}
	
	/**
	 * Check the string data, if the data is one of the operator string then return true otherwise false
	 * @param data
	 * @return
	 */
	private boolean isOperator(String data) {
		if (data.equalsIgnoreCase("add") || data.equalsIgnoreCase("subtract") || data.equalsIgnoreCase("multiply")){
			return pass;
		}
		return !pass;
	}
}
