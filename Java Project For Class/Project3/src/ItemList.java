import java.io.*;
import java.util.*;

import javax.swing.JOptionPane;

public class ItemList {
	private ListNode first;
	private ListNode last;
	private int length =0;
	
	public ItemList() {
		first = new ListNode(null);
		last = first;
	}
	
/**
 * Add item to the end of the ItemList
 * @param addItem, ProduceItem Object that need to be pass in
 */
	public void append(ProduceItem addItem) {
		ListNode n = new ListNode(addItem);
		if(length == 0){
			first.setNext(n);;
			last = n;
			length++;
		}
		if(length != 0){
			last.setNext(n);;
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
		ListNode temp = first.getNext();
		String wc = "";
		while(temp != null){
			if(((temp.getProduceItem()).getCode()).equals(code))
				return (temp.getProduceItem()).getName();
			wc = temp.getProduceItem().getCode() + wc;
			temp = temp.getNext();
		}
		throw new ItemNotFoundException("Item name not found ");
	}
	/**
	 * use the item code to search the item in the ItemList
	 * @param code, Item code for searching Item
	 * @return Item price
	 */
	public float getItemPrice(String code) {
		ListNode temp = first.getNext();
		while(temp != null){
			if((temp.getProduceItem().getCode()).equals(code))
				return (temp.getProduceItem()).getPrice();
			temp = temp.getNext();
		}
		throw new ItemNotFoundException("Item price not found ");
	}
	/**
	 * Find the Length of the List
	 * @return, the total length of the ListNode
	 */
	public int getLength(){
		return length;
	}

	/**Print ItemList
	 * @return String that represent the whole ItemList
	 */
	public String Print() {
		ListNode ListPrint = first.getNext();
		String ListReturn = "";
		while(ListPrint != null){
				ListReturn = ListPrint.getProduceItem().getName() + " " + ListReturn;
				ListPrint = ListPrint.getNext();
		}
		return ListReturn;
	}
	/**
	 * Return fruit arraylist
	 * @return
	 */
	public ArrayList<String> DisplayFruit() {
		ArrayList<String> myList = new ArrayList<String>();
		ListNode p = new ListNode();
		p = first.getNext();
		int count = 0;
		myList.add("2");
		myList.add("Name");
		myList.add("\t\tPrice/lb");
		while(p != null){
			if(p.getProduceItem() instanceof Fruit){
				myList.add(p.getProduceItem().getName());
				myList.add("\t $" + Float.toString(p.getProduceItem().getPrice()));
			}
			p = p.getNext();
			count++;
		}
		return myList;
	}
	/**
	 * Return vegetable arraylist
	 * @return
	 */
	
	public ArrayList<String> DisplayVegetable() {
		ArrayList<String> myList = new ArrayList<String>();
		ListNode p = new ListNode();
		p = first.getNext();
		int count = 0;
		myList.add("2");
		myList.add("Name");
		myList.add("\t\tPrice/lb");
		while(p != null){
			if(p.getProduceItem() instanceof Vegetable){
				myList.add(p.getProduceItem().getName());
				myList.add("\t $" + Float.toString(p.getProduceItem().getPrice()));
			}
			p = p.getNext();
			count++;
		}
		return myList;
	}
	/**
	 * Return all item list
	 * @return
	 */
	public ArrayList<String> DisplayAll() {
		ArrayList<String> myList = new ArrayList<String>();
		ListNode p = new ListNode();
		p = first.getNext();
		int count = 0;
		myList.add("2"); 
		myList.add("Name");
		myList.add("\t\tPrice/lb");
		while(p != null){
			myList.add(p.getProduceItem().getName());
			myList.add("\t $" + Float.toString(p.getProduceItem().getPrice()));
			p = p.getNext();
			count++;
		}
		return myList;
	}
	
}
