package lee.mpcomponents;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


//�г��� �г� �־�� ��
public class MPprofilePanel_2 extends JPanel {
	
	JButton MPbackBtn = new JButton("�ڷΰ���");
	JButton MPcompleteBtn = new JButton("�����Ϸ�");
	
	JPanel MPlabelPanel = new JPanel();//���⿡ �׹鷹 �� ��
	
	//�׹鷹!!!!!!!!!!!!!!!!
	GridBagLayout gbl = new GridBagLayout();
	GridBagConstraints gblc = new GridBagConstraints();

	JLabel MPviewLb1 = new JLabel("   �̸�:"); //�� �길 Ƣ��� ����?��
	JLabel MPviewLb2 = new JLabel("����ó:");
	JLabel MPviewLb3 = new JLabel("�� ��й�ȣ:");
	
	
	JTextField MPnameTf = new JTextField(25);
	JTextField MPphoneTf = new JTextField(25);
	JTextField MPnewpwTf = new JTextField(25);
	
	
	public MPprofilePanel_2() {
		setLayout(null);

		
		//���߿� �۾�ü �ٲ� �� 
//		MPviewLb1.setFont(new Font("�ü�ü", Font.PLAIN, 20));
//		MPviewLb2.setFont(new Font("�ü�ü", Font.PLAIN, 20));
//		MPviewLb3.setFont(new Font("�ü�ü", Font.PLAIN, 20));
	
		
		
		//��ǲ�г� ����
		MPlabelPanel.setLayout(new GridLayout());
		MPlabelPanel.setBounds(85, 90, 350, 170);
		MPlabelPanel.setBackground(Color.pink);
		MPlabelPanel.setLayout(gbl);
		
		
		
		//�׹鷹 ���� + ������Ʈ �ֱ� 
		gblc.weightx = 1.0;
		gblc.weighty = 1.0;
			
		gbInsert(MPviewLb1, 0, 0, 1, 1);
		gbInsert(MPnameTf, 1, 0, 3, 1);
		gbInsert(MPviewLb2, 0, 1, 1, 1);
		gbInsert(MPphoneTf, 1, 1, 3, 1);
		gbInsert(MPviewLb3, 0, 2, 1, 1);
		gbInsert(MPnewpwTf, 1, 2, 3, 1);
		
	
		
		//�����Ϸ��ư ����
		MPcompleteBtn.setBounds(280, 300, 90, 38);
		MPcompleteBtn.setBorderPainted(false);
		
		//�ڷΰ��� ��ư ����
		MPbackBtn.setBounds(150, 300, 90, 38 );
		MPbackBtn.setBorderPainted(false);
		
		
		
		add(MPcompleteBtn);
		add(MPbackBtn);
		add(MPlabelPanel);
	}
	
	
	
	public void gbInsert(Component c, int gridx, int gridy, int gridwidth, int gridheight) {
		gblc.fill = gblc.BOTH;//��ü�� ä���°ŷ� 
		gblc.gridx = gridx;
		gblc.gridy = gridy;
		gblc.gridwidth = gridwidth;
		gblc.gridheight = gridheight;
		gbl.setConstraints(c,  gblc);
		gblc.insets = new Insets(15, 10, 10, 10);
		MPlabelPanel.add(c);
	}
	
	
}






