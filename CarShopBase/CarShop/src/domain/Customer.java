package domain;

public class Customer implements IHaveId{

	private int id;
	private String name;
	private String adress;
	private String phone;
	
	public Customer() {}
	
	public Customer(String name, String adress, String phone)
	{
		this.name = name;
		this.adress = adress;
		this.phone = phone;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}

