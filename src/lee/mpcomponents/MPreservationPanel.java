package lee.mpcomponents;

import java.awt.CardLayout;

import javax.swing.JPanel;

public class MPreservationPanel extends JPanel {
	
	CardLayout MPreservationCard = new CardLayout();

	MPreservationPanel_1 MPreservation_1 = new MPreservationPanel_1();		
	MPreservationPanel_2 MPreservation_2 = new MPreservationPanel_2();
	
	public MPreservationPanel() {
		
		setLayout(MPreservationCard);

				
		add(MPreservation_1, "���ų��� ����");
		add(MPreservation_2, "���ų��� ����");
	}
}
