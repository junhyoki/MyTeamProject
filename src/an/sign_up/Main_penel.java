package an.sign_up;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;



public class Main_penel extends JPanel{
	
	JLabel signup = new Main_Label("���� ȸ�� ȸ������");
	
	public Main_penel() {
		new JPanel(new FlowLayout(FlowLayout.RIGHT));
		add(signup);
	}

}
