import java.util.*;

/**
 * AddressBook : Maintains a list of buddies 
 * @author aananth
 *
 */
public class AddressBook {
	private List<BuddyInfo> addressBook = new ArrayList<BuddyInfo>(); 
	
	/**
	 * Adds a buddy to the address book
	 * @param buddy
	 * @return true (added) or false (not added)
	 */
	public boolean addBuddy(BuddyInfo buddy){
		return(this.addressBook.add(buddy));
	}
	
	/**
	 * Removes buddy from the addressbook
	 * @param buddy
	 * @return true (removed) or false (not removed)
	 */
	public boolean removeBuddy(BuddyInfo buddy){
		return(this.addressBook.remove(buddy));
	}
	

	public static void main(String[] args) {
		
		System.out.println("Address Book!");

	}

}
