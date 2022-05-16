
/**
 * Address : Describes the address of a person
 * @author aananth
 *
 */
public class Address {
	private int streetNumber;
	private String streetName;
	private String streetType;
	private String city;
	private String province;
	private String country;
	private String postalCode;
	
	/**
	 * @param streetNumber
	 * @param streetName
	 * @param streetType
	 * @param city
	 * @param province
	 */
	public Address(int streetNumber, String streetName, String streetType, String city, String province) {
		this.streetNumber = streetNumber;
		this.streetName = streetName;
		this.streetType = streetType;
		this.city = city;
		this.province = province;
	}
	
	/**
	 * @param streetNumber
	 * @param streetName
	 * @param streetType
	 * @param city
	 * @param province
	 * @param country
	 * @param postalCode
	 */
	public Address(int streetNumber, String streetName, String streetType, String city, String province, String country,
			String postalCode) {
		super();
		this.streetNumber = streetNumber;
		this.streetName = streetName;
		this.streetType = streetType;
		this.city = city;
		this.province = province;
		this.country = country;
		this.postalCode = postalCode;
	}

	/**
	 * @return the streetNumber
	 */
	public int getStreetNumber() {
		return streetNumber;
	}

	/**
	 * @param streetNumber the streetNumber to set
	 */
	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}

	/**
	 * @return the streetName
	 */
	public String getStreetName() {
		return streetName;
	}

	/**
	 * @param streetName the streetName to set
	 */
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	/**
	 * @return the streetType
	 */
	public String getStreetType() {
		return streetType;
	}

	/**
	 * @param streetType the streetType to set
	 */
	public void setStreetType(String streetType) {
		this.streetType = streetType;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the province
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * @param province the province to set
	 */
	public void setProvince(String province) {
		this.province = province;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * @param postalCode the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

}
