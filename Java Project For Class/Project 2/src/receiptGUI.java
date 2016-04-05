import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.*;

public class receiptGUI{
	/**
	 * Passing the item info that store in info array, 
	 * counter is the number of items that in the array, 
	 * total is the total price of all items
	 * @param info
	 * @param counter
	 * @param total
	 */
	public receiptGUI(String[][] info, int counter, String total) {
		JFrame receipt = new JFrame();
		Container receiptContent = receipt.getContentPane();
		receipt.setSize(400,200);
		receipt.setLocation(100,100);
		receipt.setTitle("Receipt");
		receipt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		receiptContent.setLayout(new GridLayout(counter+2, 4));
		receipt.add(new JLabel("Name"));
		receipt.add(new JLabel("Price/lb"));
		receipt.add(new JLabel("Weight"));
		receipt.add(new JLabel("Total"));
		for(int r=0;r<counter+1;r++){
			for(int c=0;c<4;c++){
				if (r<counter && c%2 !=0) {
					receipt.add(new JLabel("$" + info[r][c]));
				}
				if (r<counter && c%2 ==0) {
					receipt.add(new JLabel(info[r][c]));
				}
				/**
				 * leave last row with three columns empty
				 */
				if (r == counter && c < 3) {
					receipt.add(new JLabel());
				}
				/**
				 * put total price on last row and last column
				 */
				if (r == counter && c==3) {
					receipt.add(new JLabel("Total Price: $" + total));	
				}
			}
		}
		receipt.pack();
		receipt.setVisible(true);
	}
	
}
