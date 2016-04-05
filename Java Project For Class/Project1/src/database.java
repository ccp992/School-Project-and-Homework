import java.util.*;

public class database {
	private ProduceItem[] Item = new ProduceItem[100];
	private int counter = 0;
	private TextFileInput ItemData;
	private StringTokenizer ItemToken;
	private String line;
	private String code, name;
	private float price;
	/**
	 * Passing data in the database file to ProduceItem class
	 * @param FileName database file name
	 */
	public database(String FileName){
		ItemData = new TextFileInput(FileName);
		line = ItemData.readLine();
		while(line != null){
			ItemToken = new StringTokenizer(line, ",");
			code = ItemToken.nextToken();
			name = ItemToken.nextToken();
			price = Float.parseFloat(ItemToken.nextToken());
			Item[counter] = new ProduceItem(code,name,price);
			counter++;
			line = ItemData.readLine();
		}
	}
	/**
	 * Passing item code to get item name
	 * @param ItemCode
	 * @return Item name that corresponding to the code
	 */
	public String getName(String ItemCode) {
		for(int i=0;i<counter;i++){
			if (Item[i].getCode().equals(ItemCode)) {
				return Item[i].getName();
			}
		}
		throw new IllegalArgumentException("Item not Found");
	}
	/**
	 * Passing item code to get item price
	 * @param ItemCode
	 * @return Item price that corresponding to the code
	 */
	public float getPrice(String ItemCode){
		for(int i=0;i<counter;i++){
			if(Item[i].getCode().equals(ItemCode)){
				return Item[i].getPrice();
			}
		}
		throw new IllegalArgumentException("Item not Found");
	}
}
