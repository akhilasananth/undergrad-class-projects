package springexample.mainDir;

import org.junit.Before;
import org.junit.Test;
import springexample.mainDir.AddressBook;
import springexample.mainDir.BuddyInfo;

import javax.persistence.*;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by akhilaananth on 1/12/2017.
 */
public class AddressBookTest {
    AddressBook contacts;

    @Before
    public void setUp() throws Exception {
        contacts = new AddressBook();
    }

    @Test
    public void addNewContact() throws Exception {
        BuddyInfo buddy1 = new BuddyInfo("John Doe", "613123512");
        BuddyInfo buddy2 = new BuddyInfo("John Doo", "613123513");
        BuddyInfo buddy3 = new BuddyInfo("John Doeb", "613123514");

        contacts.addNewContact(buddy1);
        assertTrue(contacts.getContacts().contains(buddy1));
        contacts.addNewContact(buddy2);
        assertTrue(contacts.getContacts().contains(buddy2));
        contacts.addNewContact(buddy3);
        assertTrue(contacts.getContacts().contains(buddy3));


    }

    @Test
    public void testPersistence(){
        BuddyInfo entry1 = new BuddyInfo("John Doel", "613123515");
        BuddyInfo entry2 = new BuddyInfo("John Dool", "613123517");
        BuddyInfo entry3 = new BuddyInfo("John Doebl", "613123518");

        // Connecting to the database through EntityManagerFactory
        // connection details loaded from persistence.xml
        /*
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AddressBookEntities");

        EntityManager em = emf.createEntityManager();

        // Creating a new transaction
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        em.persist(entry1);
        em.persist(entry2);
        em.persist(entry3);

        tx.commit();


        Query q = em.createQuery("SELECT b FROM BuddyInfo b");

        List<BuddyInfo> results = q.getResultList();

        System.out.println("List of products\n----------------");

        for (BuddyInfo b : results) {

            System.out.println(b.getName() + " (id=" + b.getPhoneNumber() + ")");
        }


        em.close();

        emf.close();
        */
    }

    @Test
    public void main() throws Exception {

    }

}