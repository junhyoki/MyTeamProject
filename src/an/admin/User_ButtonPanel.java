package an.admin;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class User_ButtonPanel extends JPanel{
	JButton input = new JButton("�Է�");
	JButton modify = new JButton("����");
	JButton output = new JButton("���");
	JButton delete = new JButton("����");
	public User_ButtonPanel(JButton j1,JButton j2,JButton j3,JButton j4) {
		input = j1;
		modify = j2;
		output = j3;
		delete = j4;
		
		setLayout(new FlowLayout());
		add(input);add(modify);add(output);add(delete);
		
	}

}
