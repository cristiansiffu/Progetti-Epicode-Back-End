package data;

public class Car {
	private String brand;
	private int capacity;
	private String licensePlate;
	private int price;
	private String color;
	private int numberGear;
	private boolean engineOn = false;
	private int gear = 0;

	public Car(String brand, int capacity, String licensePlate, int price, String color, int numberGear) {
		super();
		this.brand = brand;
		this.capacity = capacity;
		this.licensePlate = licensePlate;
		this.price = price;
		this.color = color;
		this.numberGear = numberGear;
	}

	public Car() {
		super();
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getNumberGear() {
		return numberGear;
	}

	public void setNumberGear(int numberGear) {
		this.numberGear = numberGear;
	}

	public boolean isEngineOn() {
		return engineOn;
	}

	public void setEngineOn(boolean engineOn) {
		this.engineOn = engineOn;
	}

	public int getGear() {
		return gear;
	}

	public void setGear(int gear) {
		this.gear = gear;
	}

	@Override
	public String toString() {
		return "brand=" + brand + ", capacity=" + capacity + ", licensePlate=" + licensePlate + ", price=" + price
				+ ", color=" + color;
	}

}
