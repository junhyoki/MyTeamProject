package an.sign_up;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Name_panel extends JPanel{
	
	JLabel name = new Sign_Label("?̸? :");
	JTextField nametext;
	
public Name_panel(JTextField nametex) {
	
	this.nametext = nametex;
	setLayout(new FlowLayout(FlowLayout.LEFT));
	setBackground(new Color(0X4D7F86));
	add(name);add(nametext);
	
}

}
