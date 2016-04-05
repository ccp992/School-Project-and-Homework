import java.text.DecimalFormat;
import java.util.*;

import javax.swing.JOptionPane;

public class model extends Observable{
	private database db;
	/**
	 * Store transaction's item information into arraylist
	 * notify observer and transfer arraylist into GUI
	 * @param filename, get selected transaction directory
	 */
	public void OpenTransaction(String filename) {
		DecimalFormat TwoDecimal = new DecimalFormat("##.00"); 
		float total = 0.0f;
		float weight = 0.0f;
		String code,tempName;
		int counter = 0;
		float tempPrice = 0.0f;
		ArrayList<String> myList = new ArrayList<String>();
		myList.add("4");
		myList.add("Name");
		myList.add("\t\tPrice/lb");
		myList.add("\tWeight(LBS)");
		myList.add("\tTotal");
		TextFileInput buyItem = new TextFileInput(filename);
		String line = buyItem.readLine();
		StringTokenizer itemToken;
		 while(line != null){
			itemToken = new StringTokenizer(line, ",");
			code = itemToken.nextToken();
			weight = Float.parseFloat(itemToken.nextToken());
			try {
				myList.add(db.getName(code));
				myList.add("\t$" + Float.toString(db.getPrice(code)));
				myList.add("\t"+Float.toString(weight));
				myList.add("\t$" + TwoDecimal.format(weight*db.getPrice(code)));
				total = total + weight * db.getPrice(code);
			} catch (Exception e) {
				// TODO: handle exception
				tempName = JOptionPane.showInputDialog(null,"Enter Item name");
				tempPrice = Float.parseFloat(JOptionPane.showInputDialog(null, "Enter Price"));
				myList.add(tempName);
				myList.add("\t$" + Float.toString(tempPrice));
				myList.add("\t"+Float.toString(weight));
				myList.add("\t$" + TwoDecimal.format(weight*tempPrice));
				total = total+weight*tempPrice;
			}
			line = buyItem.readLine();
			++counter;
		 }
		myList.add("\n\t\tTotal: $" + TwoDecimal.format(total));
		setChanged();
		notifyObservers(myList);
	}
	/**
	 * store database data to database class
	 * @param filename,get selected database directory
	 */
	public void OpenDatabase(String filename) {
		db = new database(filename);
		JOptionPane.showMessageDialog(null, "Success");
	}
	/**
	 * transfer fruit list to GUI class
	 */
	public void DisplayFruit() {
		setChanged();
		notifyObservers(db.displayFruit());
	}
	/**
	 * transfer vegetable list to GUI class
	 */
	public void DisplayVegetable() {
		setChanged();
		notifyObservers(db.displayVegetable());
	}
	/**
	 * transfer all item to GUI class
	 */
	public void DisplayAll() {
		setChanged();
		notifyObservers(db.displayAll());
	}
}
