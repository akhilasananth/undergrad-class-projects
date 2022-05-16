package springexample.XMLImplementation;

import springexample.mainDir.AddressBook;
import springexample.mainDir.BuddyInfo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyActionListener implements ActionListener {

    private BuddyInfo buddy = new BuddyInfo();
    private AddressBook book = new AddressBook();
    private MyJTextField nameText;
    private MyJTextField numberText;
    private MyJTextField eMailText;
    private MyJTextField buddies;


    public void actionPerformed(ActionEvent e) {

        JOptionPane.showMessageDialog(null, "Hello from Spring!");
        buddy.setName(nameText.getText());
        buddy.setPhoneNumber(numberText.getText());
        buddy.setEmailAddress(eMailText.getText());

        book.addNewContact(buddy);

        buddies.setText(book.getBuddies());

    }

    public void setNameText(MyJTextField nameText) {
        this.nameText = nameText;
    }

    public void setNumberText(MyJTextField NumberText) {
        numberText = NumberText;
    }


    public void setEMailText(MyJTextField EMailText) {
        eMailText = EMailText;
    }

    public void setBuddies(MyJTextField buddies) {
        this.buddies = buddies;
    }
}
