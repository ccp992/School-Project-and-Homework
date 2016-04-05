
public abstract class ProduceItem {
	private String code, name;
	private float price;
	/**
	 * three parameters constructor that store item code, name, price
	 * @param code
	 * @param name
	 * @param price
	 */
	public ProduceItem(String code, String name, float price){
		this.code = code;
		this.name = name;
		this.price = price;
	}
	/**
	 * no parameter constructor for initialization
	 */
	public ProduceItem() {
		code = null;
		name = null;
		price = 0.0f;
	}
	
	public String getCode(){
		return code;
	}
	public String getName(){
		return name;
	}
	public float getPrice(){
		return price;
	}
	public void setCode(String code){
		this.code = code;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setPrice(float price){
		this.price = price;
	}
	public String toString(){
		return code +" "+ name +" "+ price;	
	}
	public boolean equals(Object item){
		return (item != null && this.getClass() == item.getClass());	
	}
}
