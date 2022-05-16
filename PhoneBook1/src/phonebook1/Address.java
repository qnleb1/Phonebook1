package phonebook1;

public class Address {
	
	private int stNum;
	private String stName;
	private String city;
	private String state;
	private String zip;
	
	public Address(int stNum, String stName, String city, String state, String zip) {
		
		this.stNum = stNum;
		this.stName = stName;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	// set just the street 
	public void setStreetAddress(String newAddress) {
		// split the new address entered into an array of String
		String[] temp = newAddress.split(" ");
		String newStName = "";
				// set the number to the private variable above
		this.stNum = Integer.parseInt(temp[0]);
		
		//create String for stName
		for(int i = 1; i < temp.length; i++) {
			newStName = temp[1];
			if(i != temp.length - 2) {
				newStName += " ";
			}
		}
		this.stName = newStName;
		
	}
	
	public int getStNum() {
		return stNum;
	}
	public void setStNum(int stNum) {
		this.stNum = stNum;
	}
	public String getStName() {
		return stName;
	}
	public void setStName(String stName) {
		this.stName = stName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}	
	public void printAddress() {
		
		System.out.println(stNum + " " + stName + ", " + city + ", " + state + ", " + zip);
		
	}

	

}