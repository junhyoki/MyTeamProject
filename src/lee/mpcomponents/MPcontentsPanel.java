package lee.mpcomponents;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class MPcontentsPanel extends JPanel {
	
	
	MPprofilePanel MPprofile = new MPprofilePanel();
	MPleavePanel MPleave = new MPleavePanel();
	MPreservationPanel MPreservation = new MPreservationPanel();
	
	//ī�巹�̾ƿ�
	CardLayout MPcontentsCard = new CardLayout();
	
	public MPcontentsPanel() {

		
		setLayout(MPcontentsCard);	
		
		add("������", MPprofile);
		add("���ų���", MPreservation);
		add("����Ż��", MPleave);
		
		setBounds(230, 110, 510, 460);
		setVisible(true);
	}
}
