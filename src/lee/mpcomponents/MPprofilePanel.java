package lee.mpcomponents;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class MPprofilePanel extends JPanel {

	MPprofilePanel_1 MPprofile_1 = new MPprofilePanel_1();
	MPprofilePanel_2 MPprofile_2 = new MPprofilePanel_2();
	
	CardLayout MPprofileCard = new CardLayout();
	
	
	
	public MPprofilePanel() {
		
		setLayout(MPprofileCard);
		
		
		add("������ ����", MPprofile_1);
		add("������ ����", MPprofile_2);

	}

	
	public void showMPprofile_2() {
		MPprofileCard.show(this, "������ ����");
	}
	
	
	public void showMPprofile_1() {
		MPprofileCard.show(this, "������ ����");
	}
	
}
