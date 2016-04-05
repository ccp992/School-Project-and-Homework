
public class ListNode {
	private ProduceItem data;
	private ListNode next;
	
	public ListNode(ProduceItem d){
		data = d;
		next = null;
	}
	public ListNode() {
		data = null;
		next = null;
	}
	public ListNode getNext(){
		return next;
	}
	public void setNext(ListNode nextNode) {
		this.next = nextNode;
	}
	public ProduceItem getProduceItem() {
		return data;
	}
	public void setProduceItem(ProduceItem d) {
		this.data = d;
	}
}
