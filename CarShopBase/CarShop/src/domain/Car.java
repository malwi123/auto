package domain;

public class Car implements IHaveId{

	private int id;
	private String brand;
	private String model;
	private String type;
	private int price;
	
	public Car() {}
	
	public Car(String brand, String model, String type, int price)
	{
		this.brand = brand;
		this.model = model;
		this.type = type;
		this.price = price;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

}
