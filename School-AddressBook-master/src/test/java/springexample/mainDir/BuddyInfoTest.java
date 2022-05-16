package springexample.mainDir;

import org.junit.Before;
import org.junit.Test;
import springexample.mainDir.BuddyInfo;

import javax.persistence.*;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by akhilaananth on 1/12/2017.
 */
public class BuddyInfoTest {
    BuddyInfo buddy;

    @Before
    public void setUp() throws Exception {
        buddy = new BuddyInfo("Amy Farah Fowler", "243456332", "neuronerd@gmail.com");

    }

    @Test
    public void getEmailAddress() throws Exception {
        assertTrue(buddy.getEmailAddress().equals("neuronerd@gmail.com"));
    }

    @Test
    public void setEmailAddress() throws Exception {

    }

    @Test
    public void getPhoneNumber() throws Exception {
        assertEquals(buddy.getPhoneNumber(), "243456332");
    }

    @Test
    public void setPhoneNumber() throws Exception {

    }

    @Test
    public void getName() throws Exception {
        assertTrue(buddy.getName().equals("Amy Farah Fowler"));
    }

    @Test
    public void testPersistence(){
        BuddyInfo buddy1 = new BuddyInfo("Donald","57009");

        // Connecting to the database through EntityManagerFactory
        // connection details loaded from persistence.xml
        /*
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AddressBookEntities");

        EntityManager em = emf.createEntityManager();

        // Creating a new transaction
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        em.persist(buddy1);

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

}