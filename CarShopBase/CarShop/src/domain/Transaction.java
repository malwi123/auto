package domain;

public class Transaction implements IHaveId{

	private int id;
	private int carId;
	private int customerId;
	
	public Transaction() {}
	
	public Transaction(int carId, int customerId)
	{
		this.carId = carId;
		this.customerId = customerId;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getCarId() {
		return carId;
	}
	
	public void setCarId(int carId) {
		this.carId = carId;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}	
}
