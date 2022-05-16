package springexample.mainDir;


import java.util.ArrayList;

/**
 * Created by akhilaananth on 1/12/2017.
 */

public class AddressBook {


    private ArrayList<BuddyInfo> contacts;

    public AddressBook()
    {
        contacts = new ArrayList<BuddyInfo>();

    }
    public ArrayList<BuddyInfo> getContacts() {

        return contacts;
    }
    public void addNewContact(BuddyInfo buddy)
    {
        contacts.add(buddy);
    }

    public String getBuddies(){
        String buddies = "";
        for(int i=0; i<contacts.size(); i++){
            buddies += ("printBuddies: "+contacts.get(i).getName() +"/n");
        }
        return buddies;

    }

    public static void main(String [ ] args)
    {
        AddressBook contacts = new AddressBook();

        BuddyInfo buddy1 = new BuddyInfo("John Doe", "613123512");
        BuddyInfo buddy2 = new BuddyInfo("John Doo", "613123513");
        BuddyInfo buddy3 = new BuddyInfo("John Doeb", "613123514");

        contacts.addNewContact(buddy1);
        contacts.addNewContact(buddy2);
        contacts.addNewContact(buddy3);
    }

}

