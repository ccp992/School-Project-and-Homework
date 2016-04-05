import java.awt.Container;
import java.awt.GridLayout;
import java.awt.MenuBar;
import java.awt.TextArea;
import java.lang.reflect.Array;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class FileGUI extends JFrame implements Observer{
	private JMenuBar fileMenuBar = new JMenuBar();
	private Container receiptContent = this.getContentPane();
	private model m = new model();
	private TextArea text = new TextArea();
	
	public FileGUI(){
		setTitle("Receipt");
		setSize(400, 550);
		setLocation(350, 200);
		m.addObserver(this);
		text.setEditable(false);
		this.getContentPane().add(text);
		createFileMenu();
		createDatabaseMenu();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	private void createFileMenu() {
		JMenuItem item;
		JMenu fileMenu = new JMenu("File");
		FileMenuHandler fmh = new FileMenuHandler(this,m);
		
		item = new JMenuItem("Open Transaction File");
		item.addActionListener(fmh);
		fileMenu.add(item);
		
		fileMenu.addSeparator();
		
		item = new JMenuItem("Quit");
		item.addActionListener(fmh);
		fileMenu.add(item);
		
		setJMenuBar(fileMenuBar);
		fileMenuBar.add(fileMenu);
		
	}
	
	private void createDatabaseMenu() {
		JMenuItem item;
		
		JMenu databaseMenu = new JMenu("Database");
		DatabaseMenuHandler dbmh = new DatabaseMenuHandler(this,m);
		
		item = new JMenuItem("Open Database File");
		item.addActionListener(dbmh);
		databaseMenu.add(item);
		
		databaseMenu.addSeparator();
		
		item = new JMenuItem("Fruit");
		item.addActionListener(dbmh);
		databaseMenu.add(item);
		
		databaseMenu.addSeparator();
		
		item = new JMenuItem("Vegetable");
		item.addActionListener(dbmh);
		databaseMenu.add(item);
		
		databaseMenu.addSeparator();
		
		item = new JMenuItem("DisplayAll");
		item.addActionListener(dbmh);
		databaseMenu.add(item);
		
		fileMenuBar.add(databaseMenu);
	}
	/**
	 * Base on the arraylist that passed in determine whether use twoColAppend or fourColAppend
	 * @param myList
	 */
	private void append(ArrayList<String> myList) {
		if (Integer.parseInt(myList.get(0)) == 2) {
			myList.remove(0);
			twoColAppend(myList);
		}
		else if (Integer.parseInt(myList.get(0)) == 4) {
			myList.remove(0);
			fourColAppend(myList);
		}
	}
	/**
	 * display database item list that contain name and price\lb
	 * @param myList, An arraylist contains fruit or vegetable or all item list
	 */
	private void twoColAppend(ArrayList<String> myList) {
		text.setText(null);
		int counter =0;
		for(int r=0;r<myList.size()/2;r++){
			for(int c=0;c<2;c++){
				text.append(myList.get(counter));
				counter++;
			}
			text.append("\n");
		}
	}
	/**
	 * display transaction data that contains name, price\lb, weight, total price
	 * @param myList, An arraylist contains transaction information
	 */
	private void fourColAppend(ArrayList<String> myList) {
		text.setText(null);
		int counter = 0;
		while(counter < myList.size()-1){
			for(int c=0;c<4;c++){
				text.append(myList.get(counter));
				counter++;
			}
			text.append("\n");
		}
		text.append(myList.get(counter));
	}
	@Override
	public void update(Observable o, Object arg) {
		append((ArrayList<String>) arg);		
	}

}
