package hong;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MainPanel extends JPanel {
	
	GridBagLayout gbl = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();
	HomeButton homeButton = new HomeButton();
	ArrivalButton arvButton = new ArrivalButton();
	DestinationButton desButton = new DestinationButton();
	
	public MainPanel() {
		// layout�� GridBagLayout���� ����
		
		setLayout(gbl);
		
		gbc.fill= GridBagConstraints.BOTH;

		// GridBagLayout Ȱ���ϱ�
		// 1�� ����
		gbc.weighty = 0.07;
		gbInsert(new BackGroundLabel(), 0, 0, 7, 1);
		
		// 2�� ����
		gbc.weighty = 0.2;
		gbc.weightx = 0.5;
		gbInsert(new BackGroundLabel(), 0, 1, 1, 1);
		gbInsert(new BackGroundLabel(), 6, 1, 1, 1);
		
		// 2�� Ȩ��ư
		gbc.weighty = 0.1;
		gbInsert(homeButton, 1, 1, 5, 1);
		
		// 3�� ����
		gbc.weighty = 0.3;
		gbc.weightx = 0.5;
		gbInsert(new BackGroundLabel(), 0, 2, 1, 1);
		gbInsert(new BackGroundLabel(), 6, 2, 1, 1);
		
        // 3�� �����
		gbc.weightx = 4.0;
		gbInsert(arvButton, 1, 2, 2, 1);
		
		gbc.weightx = 1.0;
		gbInsert(new BackGroundLabel(), 3, 2, 1, 1);
		
		// 3�� ������
		gbc.weightx = 4.0;
		gbInsert(desButton, 4, 2, 2, 1);
		
		// 4�� ����
		gbc.weighty = 0.03;
		gbInsert(new BackGroundLabel(), 0, 3, 7, 1);
		
		// 5�� ����
		gbc.weightx = 0.5;
		gbc.weighty = 0.03;
		gbInsert(new BackGroundLabel(), 0, 4, 1, 1);
		gbInsert(new BackGroundLabel(), 6, 4, 1, 1);
		
		// ��߳�¥?
		gbc.weightx = 1.0;
		BackGroundLabel chulbal = new BackGroundLabel();
		chulbal.setText("��� ��¥ : ");
		gbInsert(chulbal, 1, 4, 1, 1);
		// �� �޺��ڽ�
		gbInsert(new MonthComboBox(), 2, 4, 1, 1);
		
		// �� ��
		BackGroundLabel wol = new BackGroundLabel();
		wol.setText("��");
		gbInsert(wol, 3, 4, 1, 1);
		
		// �� �޺��ڽ�
		gbInsert(new DayComboBox(), 4, 4, 1, 1);
		gbc.weightx = 1.0;
		// �� ��
		BackGroundLabel il = new BackGroundLabel();
		il.setText(" ��");
		il.leftSort();
		gbInsert(il, 5, 4, 1, 1);
		
		// 6�� ����
		gbc.weighty = 0.03;
		gbInsert(new BackGroundLabel(), 0, 5, 7, 1);
		
		// 7�� ����
		gbc.weighty = 0.04;
		gbc.weightx = 0.5;
		gbInsert(new BackGroundLabel(), 0, 6, 1, 1);
		gbInsert(new BackGroundLabel(), 6, 6, 1, 1);
		
		// ��ȸ�ϱ� ��ư
		gbc.weightx = 1.0;
		gbInsert(new SerchButton(), 1, 6, 5, 1);
		
		// 8�� ����
		gbc.weightx = 0.5;
		gbInsert(new BackGroundLabel(), 0, 7, 1, 1);
		gbInsert(new BackGroundLabel(), 6, 7, 1, 1);
		
		gbc.weightx = 1.0;
		gbInsert(new BackGroundLabel(), 1, 7, 1, 1);
		gbInsert(new BackGroundLabel(), 2, 7, 4, 1);
			
		// 9�� ����
		gbc.weightx = 0.5;
		gbInsert(new BackGroundLabel(), 0, 8, 1, 1);
		gbInsert(new BackGroundLabel(), 6, 8, 1, 1);
		
		gbc.weightx = 1.0;
		gbInsert(new BackGroundLabel(), 1, 8, 1, 1);
		gbInsert(new JButton(), 2, 8, 1, 1);
		gbInsert(new BackGroundLabel(), 3, 8, 1, 1);
		gbInsert(new JButton(), 4, 8, 1, 1);
		gbInsert(new BackGroundLabel(), 5, 8, 1, 1);
		
		// 10��
		gbc.weighty = 0.07;
		gbInsert(new BackGroundLabel(), 0, 9, 7, 1);
	}
	
	 public void gbInsert(Component c, int x, int y, int w, int h){
	        gbc.gridx = x;
	        gbc.gridy = y;
	        gbc.gridwidth = w;
	        gbc.gridheight = h;
	        gbl.setConstraints(c, gbc);
	        this.add(c);
	    }
}
