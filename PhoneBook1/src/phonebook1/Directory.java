package phonebook1;

import java.util.*;

public class Directory {
	
	public static Directory directory = new Directory();
	
	Person[] person = new Person[0]; 
	
	
	// addPerson to array
	public void addPerson(Person newPerson) {
		// create temp array one larger than current array
		Person[] temp = new Person[person.length + 1];
		
		//add people in original array to temp array
		for(int i = 0; i < person.length; i++) {
			temp[i] = person[i];
			
		}
		//at end of array, add new person object
		temp[temp.length - 1] = newPerson;
		
		// reassign the original array to temp 
		person = temp;
		
	}
	
	public Person[] getDirectory() {
		return person;
	}	
	// to print entire directory
	public void printDirectory(Person[] people) {
		for(int i = 0; i < people.length; i++) {
			people[i].getPerson();
		}
	}
	
	public void printDirectoryArray(Person[] searched) {
		for(int i = 0; i < searched.length; i++) {
			searched[i].getPerson();
		}
	}
	
	public Person[] findFirstName(String entry) {

		int count = 0;
		for (int i = 0; i < person.length; i++) {
			if (person[i].getFirstName().equals(entry)) {
				count++;
			}
		}
		Person[] tempArr = new Person[count];

		int x = 0;
		for (int i = 0; i < person.length; i++) {
			if (person[i].getFirstName().equals(entry)) {
				tempArr[x] = person[i];
				x++;

			}
		}
		return tempArr;
	}
	
	public Person[] findLastName(String entry) {
		
		int count = 0;
		for(int i = 0; i < person.length; i++) {
			if(person[i].getLastName().equals(entry)) {
				count++;
			}
		}
		Person[] tempArr = new Person[count];
		
		int x=0; 
		for(int i = 0; i < person.length; i++) {
			if(person[i].getLastName().equals(entry)) {
				tempArr[x] = person[i];
				x++;
			}
		}
		return tempArr;
	}
	
	public Person[] findFullName(String entry) {

		int count = 0;
		for (int i = 0; i < person.length; i++) {
			if ((person[i].getFirstName() + " " + person[i].getLastName()).equals(entry)) {
				count++;
			}
		}
		Person[] tempArr = new Person[count];

		int x = 0;
		for (int i = 0; i < person.length; i++) {
			if ((person[i].getFirstName() + " " + person[i].getLastName()).equals(entry)) {
				tempArr[x] = person[i];
				x++;

			}
		}
		return tempArr;
	}
	
	public Person[] findPhone(Long phone) {

		int count = 0;
		for (int i = 0; i < person.length; i++) {
			if (person[i].getPhone() == phone) {
				count++;
			}
		}
		Person[] tempArr = new Person[count];

		int x = 0;
		for (int i = 0; i < person.length; i++) {
			if (person[i].getPhone() == phone) {
				tempArr[x] = person[i];
				x++;

			}
		}
		return tempArr;
	}	
	
	public Person[] findCity(String city) {
		
		int count = 0;
		for (int i = 0; i < person.length; i++) {
			if (person[i].getAddress().getCity().equals(city)) {
				count++;
			}
		}
		Person[] tempArr = new Person[count];

		int x = 0;
		for (int i = 0; i < person.length; i++) {
			if (person[i].getAddress().getCity().equals(city)) {
				tempArr[x] = person[i];
				x++;

			}
		}
		return tempArr;
	}	

	public Person[] findState(String state) {

		int count = 0;
		for (int i = 0; i < person.length; i++) {
			if (person[i].getAddress().getState().equals(state)) {
				count++;
			}
		}
		Person[] tempArr = new Person[count];

		int x = 0;
		for (int i = 0; i < person.length; i++) {
			if (person[i].getAddress().getState().equals(state)) {
				tempArr[x] = person[i];
				x++;

			}
		}
		return tempArr;
	}	
	
	public Person[] deletePhone(Long phone) {

		int count = 0;
		for (int i = 0; i < person.length; i++) {
			if (person[i].getPhone() == phone) {
				count++;
				
			}
		}
		Person[] tempArr = new Person[count];

		int x = 0;
		for (int i = 0; i < person.length; i++) {
			if (person[i].getPhone() == phone) {
				tempArr[x] = person[i];
				x++;	
				tempArr[x].setPhone((Long)null);
				tempArr[x].deleteAddress(" ");
				tempArr[x].setFirstName(" ");
				tempArr[x].setMiddleName(" ");
				tempArr[x].setLastName(" ");
			}
		}
		return tempArr;
		
		
	}	
	
	
	public Person[] updatePhone(Long phone) {

		int count = 0;
		for (int i = 0; i < person.length; i++) {
			if (person[i].getPhone() == phone) {
				count++;
			}
		}
		Person[] tempArr = new Person[count];

		int x = 0;
		for (int i = 0; i < person.length; i++) {
			if (person[i].getPhone() == phone) {
				tempArr[x] = person[i];
				x++;
				Scanner input = new Scanner(System.in);
				System.out.println("Enter updated phone number");
				Long newPhone = input.nextLong();
				newPhone = tempArr[x].getPhone();
				printDirectory(tempArr);
				
			}
		}
		return tempArr;
	}	
}