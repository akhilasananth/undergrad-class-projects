
public class BuddyInfo {
	private String name;
	private int phoneNumber;
	private Address address;

	/**
	 * @param name
	 */
	public BuddyInfo(String name) {
		super();
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the phoneNumber
	 */
	public int getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	public static void main(String[] args) {
		System.out.println("Hello "+ new BuddyInfo("Homer").getName()+"!");
		System.out.println("This is part if the innitial branch");
	}

}
