import javax.swing.JOptionPane;

public class ItemList {
	private ListNode first = new ListNode(null);
	private ListNode last = first;
	private int length = 0;
	
/**
 * Add item to the end of the ItemList
 * @param addItem, ProduceItem Object that need to be pass in
 */
	public void append(ProduceItem addItem) {
		ListNode n = new ListNode(addItem);
		if(length == 0){
			first.next = n;
			last = n;
			length++;
		}
		else if(length != 0){
			last.next = n;
			last = n;
			length++;
		}
	}
	/**
	 * use the item code to search the item in the ItemList
	 * @param code, Item code for searching Item
	 * @return Item Name
	 */
	public String getItemName(String code) {
		ListNode temp = first.next;
		String wc = "";
		while(temp != null){
			if(((temp.data).getCode()).equals(code))
				return (temp.data).getName();
			wc = temp.data.getCode() + wc;
			temp = temp.next;
		}
		throw new IllegalArgumentException("Item name not found " + wc);
	}
	/**
	 * use the item code to search the item in the ItemList
	 * @param code, Item code for searching Item
	 * @return Item price
	 */
	public float getItemPrice(String code) {
		ListNode temp = first.next;
		while(temp != null){
			if(((temp.data).getCode()).equals(code))
				return (temp.data).getPrice();
			temp = temp.next;
		}
		throw new IllegalArgumentException("Item price not found ");
	}
	/**
	 * Find the Length of the List
	 * @return, the total length of the ListNode
	 */
	public int getLength(){
		return this.length;
	}

	/**Print ItemList
	 * @return String that represent the whole ItemList
	 */
	public String toString() {
		ListNode p = first.next;
		String returnString = "";
		while (p != null) {
			returnString += p.data.getName() + " ";
			p = p.next;
		}
		return returnString;
	}
}
