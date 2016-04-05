import java.text.DecimalFormat;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

public class Project2 {
	public static void main(String[] args){
		DecimalFormat TwoDecimal = new DecimalFormat("##.00"); 
		float total = 0.0f;
		float weight = 0.0f;
		String code;	
		String[][] info = new String[100][4]; 
		int counter = 0;
		database Item = new database("database2.txt");
		TextFileInput buyItem = new TextFileInput("transactions2.txt");
		String line = buyItem.readLine();
		StringTokenizer itemToken;
		 while(line != null){
			itemToken = new StringTokenizer(line, ",");
			code = itemToken.nextToken();
			weight = Float.parseFloat(itemToken.nextToken());
			info[counter][0] = Item.getName(code);
			info[counter][1] = Float.toString(Item.getPrice(code));
			info[counter][2] = Float.toString(weight);
			info[counter][3] = TwoDecimal.format(weight*Item.getPrice(code));
			total = total + weight * Item.getPrice(code);
			line = buyItem.readLine();
			++counter;
		}
		 ItemList myList = new ItemList();
		 System.out.println("List"+myList);
		receiptGUI ItemReceipt = new receiptGUI(info,counter,TwoDecimal.format(total));
	}
}
