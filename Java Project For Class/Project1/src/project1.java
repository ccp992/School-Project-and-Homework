
import java.text.DecimalFormat;
import java.util.StringTokenizer;


public class project1 {
	public static void main(String[] args){
		/**
		 * format the float into two decimal number of String;
		 */
		DecimalFormat TwoDecimal = new DecimalFormat("##.00"); 
		float total = 0.0f;
		float weight = 0.0f;
		String code;	
		/**
		 * the row of info array contains Name,Price/lb,Weight and total price based on the weight;
		 */
		String[][] info = new String[100][4]; 
		 /**
		  *  counts how many item that has been store in info array;
		  */
		int counter = 0;
		database Item = new database("database.txt");
		TextFileInput buyItem = new TextFileInput("transactions.txt");
		String line = buyItem.readLine();
		StringTokenizer itemToken;
		 while(line != null){
			itemToken = new StringTokenizer(line, ",");
			code = itemToken.nextToken();
			weight = Float.parseFloat(itemToken.nextToken());
			/**
			 * specify each column of info array with particular information
			 * 0 for name
			 * 1 for price
			 * 2 for weight
			 * 3 for total price of the weight
			 */
			info[counter][0] = Item.getName(code);
			info[counter][1] = Float.toString(Item.getPrice(code));
			info[counter][2] = Float.toString(weight);
			info[counter][3] = TwoDecimal.format(weight*Item.getPrice(code));
			total = total + weight * Item.getPrice(code);
			line = buyItem.readLine();
			++counter;
		}
		receiptGUI ItemReceipt = new receiptGUI(info,counter,TwoDecimal.format(total));
	}
}