import java.util.*;

public class database {
	private ItemList ProduceList = new ItemList();
	private TextFileInput ItemData;
	private StringTokenizer ItemToken;
	private String line;
	private String type,code, name;
	private float price;
	/**
	 * Passing data in the database file and store items in the ItemList
	 * @param FileName database file name
	 */
	public database(String FileName){
		ItemData = new TextFileInput(FileName);
		line = ItemData.readLine();
		while(line != null){
			ItemToken = new StringTokenizer(line, ",");
			type = ItemToken.nextToken();
			code = ItemToken.nextToken();
			name = ItemToken.nextToken();
			price = Float.parseFloat(ItemToken.nextToken());
			addProduce(type,code,name,price);
			line = ItemData.readLine();
		}
	}
	/**
	 * Help method to pass items information into ItemList
	 * @param type, "F" or "V"
	 * @param code, item code
	 * @param name, item name
	 * @param price, item price
	 */
	private void addProduce(String type, String code, String name, float price){
		ProduceItem addItem;
		if(type.equals("F")){
			addItem = new Fruit(code,name,price);
			ProduceList.append(addItem);
		}
		if (type.equals("V")) {
			addItem = new Vegetable(code,name,price);
			ProduceList.append(addItem);
		}
	}
	
	/**
	 * Passing item code to get item name
	 * @param ItemCode
	 * @return Item name that corresponding to the code
	 */
	public String getName(String ItemCode) {
		return ProduceList.getItemName(ItemCode);
	}
	/**
	 * Passing item code to get item price
	 * @param ItemCode
	 * @return Item price that corresponding to the code
	 */
	public float getPrice(String ItemCode){
		return ProduceList.getItemPrice(ItemCode);
	}
}
