import javax.swing.*;
import java.lang.*;

public class Project0{
	public static void main(String[] args){
		String inputWord;
		int smallE = 0;
		int bigE = 0;
		while(true){
			inputWord = JOptionPane.showInputDialog(null, "Please enter a sentence."); //receive input from user.
			if(inputWord.equalsIgnoreCase("STOP")) //detect whether the user want ot stop the program.
				System.exit(1);
			smallE = lowerCaseCheck(inputWord); //get counter for 'e'.
			bigE = upperCaseCheck(inputWord); //get counter for 'E'
			JOptionPane.showMessageDialog(null,"Number of lower case e's : " + smallE + "\n" + "Number of upper case e's : " + bigE); //output the total number of 'e' and 'E'
		}

	}
	public static int lowerCaseCheck(String inputWord){
		int counter = 0;
		Character lowerE = new Character('e'); //set the compare object.
		for(int i=0;i<inputWord.length();i++){
			if(lowerE.equals(inputWord.charAt(i))){ //compare the char of the compare object with the input from user
				counter++;	//increment if the char in the input equals to the compare object.
			}
		}
		return counter; //return the total number of 'e'
	}
	public static int upperCaseCheck(String inputWord){
		int counter = 0;
		Character upperE = new Character('E'); //set the compare object.
		for(int i=0;i<inputWord.length();i++){
			if(upperE.equals(inputWord.charAt(i))){ //compare the char of the compare object with the input from user
				counter++; //increment if the char in the input equals to the compare object.
			}
		}
		return counter; //return the total number of 'E'.
	}
}