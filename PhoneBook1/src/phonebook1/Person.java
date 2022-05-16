	package phonebook1;

	import java.util.*;

	public class Person {

		private String firstName;
		private String lastName;
		private String middleName;
		private long phone;
		private Address address;
		Scanner input = new Scanner(System.in);
		
		// set address in Person and tie to correct Person object
		
		public void addAddress(int stNum, String stName, String city, String state, String zip) {
		
			Address tempAddress = new Address(stNum, stName, city, state, zip);
					address = tempAddress;
		}
		
		public Address getAddress() {
			
			return this.address;	
		}
		
		public Person(String firstName, String lastName, String middleName, long phone) {		
			this.firstName = firstName;
			this.lastName = lastName;
			this.middleName = middleName;
			this.phone = phone;
		}
		
		public Person() {
		}

		public void getPerson() {
		
			if(middleName.length() != 0) {
				System.out.println(firstName + " " + middleName + " " + lastName);
				}else {
					System.out.println(firstName + " " + lastName);
				}
				address.printAddress();
				System.out.println("Phone Number: " + formatPhone(phone));
				System.out.println("-------------------------------");
		}
			//format phone number
		public String formatPhone(long phone) {
				String newPhone = Long.toString(phone);
				String formattedPhone = "(" + newPhone.substring(0,3) + ")" + newPhone.substring(3, 6) 
				+ "-" + newPhone.substring(6);
				return formattedPhone;				
			}
			
		public void display() {

			int phone = input.nextInt();
			System.out.println(phone);
		}
		
		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getMiddleName() {
			return middleName;
		}

		public void setMiddleName(String middleName) {
			this.middleName = middleName;
		}

		public long getPhone() {
			return phone;
		}

		public void setPhone(long phone) {
			this.phone = phone;
		}

		public Scanner getInput() {
			return input;
		}

		public void setInput(Scanner input) {
			this.input = input;
		}

		public void setAddress(Address address) {
			this.address = address;
		}

		public void deleteAddress(String string) {
			this.address.toString().equals(string = null);
			
		}

}