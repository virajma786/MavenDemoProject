package mvndemo;

public class Person {

	private String name; 
	private String address;
	private int pin;
	
	public Person() {
		
	}
	public Person(String name, String address, int pin) {
		super();
		this.name = name;
		this.address = address;
		this.pin = pin;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", address=" + address + ", pin=" + pin + ", getName()=" + getName()
				+ ", getAddress()=" + getAddress() + ", getPin()=" + getPin() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
