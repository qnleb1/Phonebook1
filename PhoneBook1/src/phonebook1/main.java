package phonebook1;

import java.util.*;

	public class main {

	public static Person person = new Person();
	
	public static Directory directory = new Directory();
	
	public static void main(String[] args) {
		Person p1 = new Person("Shawn", "Stacy", "Stick", 123456789L);
		p1.addAddress(123, "Mockingbird Lane", "Macomb", "GA", "12345" );
		
		directory.addPerson(p1);

		menu();
		
	}

	public static void menu() {
		try {
			try (//Menu display and establish Scanner
			Scanner input = new Scanner(System.in)) {
				System.out.println("Welcome to the Phonebook!");
				System.out.println("Enter a number corresponding to the options below to begin: ");
				System.out.println("1. Add new entry");
				System.out.println("2. Search for an existing entry");
				System.out.println("3. Delete a record for a given telephone number");
				System.out.println("4. Update a record for a given telephone number");
				System.out.println("5. Show all records");
				System.out.println("6. Quit Program");
//Scanner input from user
				int item = input.nextInt();

				if (item > 0) {
//Menu Choices
					switch (item) {
					case 1:
						addNewEntry();
						break;
					case 2:
						menuTwo();
						break;
					case 3:
						deletePhone();
						break;
					case 4:
						updatePhone();
						break;
					case 5:
						printDirectory();
						break;
					case 6:
						System.out.println("PROGRAM TERMINATED");
						System.exit(0);
						break;
					}
				} else {
					System.out.println("Please enter a VALID number.");
				}
			}
		} catch (Exception e) {
			System.out.println("That was an invalid entry. Try again.");
			menuTwo();
		}

	}



	public static void menuTwo() {
		try {
			try (//Menu display and establish Scanner
			Scanner input = new Scanner(System.in)) {
				System.out.println("Welcome to the Phonebook!");
				System.out.println("Enter a number corresponding to the options below to begin: ");
				System.out.println("1. Search by first name");
				System.out.println("2. Search by last name");
				System.out.println("3. Search by full name");
				System.out.println("4. Search by telephone number");
				System.out.println("5. Search by city");
				System.out.println("6. Search by state");
				System.out.println("7. Go back to main menu");
//Scanner input from user
				int item = input.nextInt();

				if (item > 0) {
//Menu Choices
					switch (item) {
					case 1:
						findFirstName();
						break;
					case 2:
						findLastName(); 
						break;
					case 3:
						findFullName();
						break;
					case 4:
						findPhone();
						break;
					case 5:
						findCity();
						break;
					case 6:
						findState();
						break;
					case 7:
						menu();
						break;
					}
				} else {
					System.out.println("Please enter a VALID choice.");
				}
			}
		} catch (Exception e) {
			System.out.println("That was an invalid entry. Try again.");
			
		}

	}
	
	public static void addNewEntry() {
		
		Scanner input = new Scanner(System.in);
		
		Directory primary = new Directory();
		
		System.out.println("Please enter new entry below: ");
		System.out.println("(SEE FORMAT---> Name, Street Address, City, State Initials, "
						+ "Zipcode, Phone Number");
		
		String info = input.nextLine();
		
		// separate info into an array of strings
		String[] tempInfo = info.split(", ");
		
		// set variables for each index
		String name = tempInfo[0];
		String street = tempInfo[1];
		String city = tempInfo[2];
		String state = tempInfo[3];
		String zipCode = tempInfo[4];
		long phone = Long.parseLong(tempInfo[5]);
		
		String[] tempName = name.split(" ");
		 
		// first name is always first
		String firstName = tempName[0];
		
		// last name is always last
		String lastName = tempName[tempName.length -1];
		
		//empty container for middle name
		String middleName = "";
		
		for(int i = 1; i < tempName.length -1; i++) {
			middleName += tempName[i];
			if( i != tempName.length -2) {
				middleName += " ";
			}
		}
		
		String[] tempAddress = street.split(" ");
		String streetName = "";
		
		for(int i = 1; i < tempAddress.length; i++) {
			streetName = tempAddress[1];
			if(i != tempAddress.length - 1) {
				streetName += " ";
			}
		}
		
		int streetNum = Integer.parseInt(tempAddress[0]);
		
		Person p3 = new Person(firstName, lastName, middleName, phone);
		p3.addAddress(streetNum, streetName, city, state, zipCode);
		directory.addPerson(p3);
		
		try {
			try (//Menu display and establish Scanner
			Scanner entry = new Scanner(System.in)) {
				System.out.println("Enter a number corresponding to the options below: ");
				System.out.println("1. Add another entry");
				System.out.println("2. Return to main menu");
				System.out.println("3. Quit program");
			
//Scanner input from user
				int item = input.nextInt();

				if (item > 0) {
//Menu Choices
					switch (item) {
					case 1:
						addNewEntry();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.exit(0);
						break;
					}
				} else {
					System.out.println("Please enter a VALID number.");
				}
			}
		} catch (Exception e) {
			System.out.println("That was an invalid entry. Try again.");
			addNewEntry();
		}
	}

	public static void printDirectory() {
		
		directory.printDirectory(directory.getDirectory());
		
		try {
			try (//Menu display and establish Scanner
			Scanner entry = new Scanner(System.in)) {
				System.out.println("Enter a number corresponding to the options below: ");
				System.out.println("1. Return to main menu");
				System.out.println("2. Quit program");
			
//Scanner input from user
				int item = entry.nextInt();

				if (item > 0) {
//Menu Choices
					switch (item) {
					case 1:
						menu();
						break;
					case 2:
						System.exit(0);
						break;
					}
				} else {
					System.out.println("Please enter a VALID number.");
				}
			}
		} catch (Exception e) {
			System.out.println("That was an invalid entry. Try again.");
			printDirectory();
		}
		
	}
	
	public static void findFirstName() {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a first name that you'd like to find below: ");
		String firstName = input.next();
		directory.printDirectoryArray(directory.findFirstName(firstName));{
		}
		try {
			try (//Menu display and establish Scanner
			Scanner entry = new Scanner(System.in)) {
				System.out.println("Enter a number corresponding to the options below: ");
				System.out.println("1. Search for another entry");
				System.out.println("2. Return to main menu");
				System.out.println("3. Quit program");
			
//Scanner input from user
				int item = input.nextInt();

				if (item > 0) {
//Menu Choices
					switch (item) {
					case 1:
						menuTwo();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.exit(0);
						break;
					}
				} else {
					System.out.println("Please enter a VALID number.");
				}
			}
		} catch (Exception e) {
			System.out.println("That was an invalid entry. Try again.");
			menuTwo();
		}
	}
	
	public static void findLastName() {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a last name that you'd like to find below: ");
		String lastName = input.next();
		directory.printDirectoryArray(directory.findLastName(lastName));{
		}
		try {
			try (//Menu display and establish Scanner
			Scanner entry = new Scanner(System.in)) {
				System.out.println("Enter a number corresponding to the options below: ");
				System.out.println("1. Search for another entry");
				System.out.println("2. Return to main menu");
				System.out.println("3. Quit program");
			
//Scanner input from user
				int item = input.nextInt();

				if (item > 0) {
//Menu Choices
					switch (item) {
					case 1:
						menuTwo();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.exit(0);
						break;
					}
				} else {
					System.out.println("Please enter a VALID number.");
				}
			}
		} catch (Exception e) {
			System.out.println("That was an invalid entry. Try again.");
			menuTwo();
		}
		

	}
	
	public static void findFullName() {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the full name that you'd like to find below: ");
		String fullName = input.nextLine();
		directory.printDirectoryArray(directory.findFullName(fullName));{
		}
		try {
			try (//Menu display and establish Scanner
			Scanner entry = new Scanner(System.in)) {
				System.out.println("Enter a number corresponding to the options below: ");
				System.out.println("1. Search for another entry");
				System.out.println("2. Return to main menu");
				System.out.println("3. Quit program");
			
//Scanner input from user
				int item = input.nextInt();

				if (item > 0) {
//Menu Choices
					switch (item) {
					case 1:
						menuTwo();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.exit(0);
						break;
					}
				} else {
					System.out.println("Please enter a VALID number.");
				}
			}
		} catch (Exception e) {
			System.out.println("That was an invalid entry. Try again.");
			menuTwo();
		}
		

	}

	public static void findPhone() {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of a person that you'd like to find below: ");
		Long phone = input.nextLong();
		directory.printDirectoryArray(directory.findPhone(phone));{
		}
		try {
			try (//Menu display and establish Scanner
			Scanner entry = new Scanner(System.in)) {
				System.out.println("Enter a number corresponding to the options below: ");
				System.out.println("1. Search for another entry");
				System.out.println("2. Return to main menu");
				System.out.println("3. Quit program");
			
//Scanner input from user
				int item = input.nextInt();

				if (item > 0) {
//Menu Choices
					switch (item) {
					case 1:
						menuTwo();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.exit(0);
						break;
					}
				} else {
					System.out.println("Please enter a VALID number.");
				}
			}
		} catch (Exception e) {
			System.out.println("That was an invalid entry. Try again.");
			menuTwo();
		}
	}

	public static void findCity() {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a first name that you'd like to find below: ");
		String city = input.next();
		directory.printDirectoryArray(directory.findCity(city));{
		}
		try {
			try (//Menu display and establish Scanner
			Scanner entry = new Scanner(System.in)) {
				System.out.println("Enter a number corresponding to the options below: ");
				System.out.println("1. Search for another entry");
				System.out.println("2. Return to main menu");
				System.out.println("3. Quit program");
			
//Scanner input from user
				int item = input.nextInt();

				if (item > 0) {
//Menu Choices
					switch (item) {
					case 1:
						menuTwo();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.exit(0);
						break;
					}
				} else {
					System.out.println("Please enter a VALID number.");
				}
			}
		} catch (Exception e) {
			System.out.println("That was an invalid entry. Try again.");
			menuTwo();
		}
	}
	
	public static void findState() {
	
	Scanner input = new Scanner(System.in);
	System.out.println("Enter the initials of a state that you'd like to find below: ");
	String state = input.next();
	directory.printDirectoryArray(directory.findState(state));{
	}
	try {
		try (//Menu display and establish Scanner
		Scanner entry = new Scanner(System.in)) {
			System.out.println("Enter a number corresponding to the options below: ");
			System.out.println("1. Search for another entry");
			System.out.println("2. Return to main menu");
			System.out.println("3. Quit program");
		
//Scanner input from user
			int item = input.nextInt();

			if (item > 0) {
//Menu Choices
				switch (item) {
				case 1:
					menuTwo();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.exit(0);
					break;
				}
			} else {
				System.out.println("Please enter a VALID number.");
			}
		}
	} catch (Exception e) {
		System.out.println("That was an invalid entry. Try again.");
		menuTwo();
	}
}
	
	public static void deletePhone() {
		
		Scanner input = new Scanner(System.in);

		System.out.println("This function DOES NOT WORK");
		try {
			try (//Menu display and establish Scanner
			Scanner entry = new Scanner(System.in)) {
				System.out.println("Enter a number corresponding to the options below: ");
				System.out.println("1. Search for a contact");
				System.out.println("2. Return to main menu");
				System.out.println("3. Quit program");
			
//Scanner input from user
				int item = input.nextInt();

				if (item > 0) {
//Menu Choices
					switch (item) {
					case 1:
						menuTwo();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.exit(0);
						break;
					}
				} else {
					System.out.println("Please enter a VALID number.");
				}
			}
		} catch (Exception e) {
			System.out.println("That was an invalid entry. Try again.");
			menuTwo();
		}
	}
	
	public static void updatePhone() {
	
	Scanner input = new Scanner(System.in);

	System.out.println("This function DOES NOT WORK");
	try {
		try (//Menu display and establish Scanner
		Scanner entry = new Scanner(System.in)) {
			System.out.println("Enter a number corresponding to the options below: ");
			System.out.println("1. Search for a contact");
			System.out.println("2. Return to main menu");
			System.out.println("3. Quit program");
		
//Scanner input from user
			int item = input.nextInt();

			if (item > 0) {
//Menu Choices
				switch (item) {
				case 1:
					menuTwo();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.exit(0);
					break;
				}
			} else {
				System.out.println("Please enter a VALID number.");
			}
		}
	} catch (Exception e) {
		System.out.println("That was an invalid entry. Try again.");
		menuTwo();
	}
}
}