package springexample.XMLImplementation;

import javax.swing.*;
import java.awt.event.ActionListener;

public class MyJButton extends JButton {
    private ActionListener actionListener;
    public void setActionListener(ActionListener actionListener) {
        this.actionListener = actionListener;
    }
        public void init() {
        this.addActionListener(actionListener);
    }
}
