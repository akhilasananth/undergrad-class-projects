package springexample.mainDir;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by akhilaananth on 1/12/2017.
 */

@Entity
public class BuddyInfo {

    private String name;
    @Id
    private String phoneNumber;
    private String emailAddress;

    public BuddyInfo(String name){
        this.name = name;
    }
    public BuddyInfo(String name, String phoneNumber){
        this.name = name;
        this.phoneNumber =  phoneNumber;
    }

    public BuddyInfo(String name, String phoneNumber, String emailAddress){
        this.name = name;
        this.phoneNumber =  phoneNumber;
        this.emailAddress = emailAddress;
    }

    public BuddyInfo() {
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BuddyInfo{" + "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }
}
