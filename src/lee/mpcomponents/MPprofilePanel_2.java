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
import javax.swing.JPasswordField;
import javax.swing.JTextField;


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
	JPasswordField MPnewpwTf = new JPasswordField(25);
	 
	
	public MPprofilePanel_2() {
		setLayout(null);

		
		//���߿� �۾�ü �ٲ� �� 
//		MPviewLb1.setFont(new Font("�ü�ü", Font.PLAIN, 20));
//		MPviewLb2.setFont(new Font("�ü�ü", Font.PLAIN, 20));
//		MPviewLb3.setFont(new Font("�ü�ü", Font.PLAIN, 20));
	
		//����й�ȣ �ؽ�Ʈ�ʵ� �Է��� �� �ܷ� ǥ�� 
		MPnewpwTf.setEchoChar('��');
	
		
		/*
		JPasswordField �ذ� �������� �� 
		
		String pw = "";
		  
		//tf_pw �ʵ忡�� �н����带 ����, char[] �迭�� ����
		char[] secret_pw = tf_pw.getPassword(); 
		
		//secret_pw �迭�� ����� ��ȣ�� �ڸ��� ��ŭ for�� �����鼭 cha �� �� ���ھ� ����
		     for(char cha : secret_pw){         
		         Character.toString(cha);       //cha �� ����� �� string���� ��ȯ
		       //pw �� �����ϱ�, pw �� ���� ��������� ����, ���� ������ �̾ �����ϴ� ���׿�����
		         pw += (pw.equals("")) ? ""+cha+"" : ""+cha+"";   
		     }
		��ó: https://yonoo88.tistory.com/716 [Blog:Ƽ���丮]
		 */
		
		
		
		//��ǲ�г� ����
		MPlabelPanel.setLayout(new GridLayout());
		MPlabelPanel.setBounds(85, 90, 350, 170);
		//MPlabelPanel.setBackground(Color.pink);
		MPlabelPanel.setLayout(gbl);
		
		
		
		
		//MPnewpwTf.setEchoChar('*');
		
		
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
	
	
	public void setTfEmpty() {
		MPnameTf.setText("");
		MPphoneTf.setText("");
		MPnewpwTf.setText("");
	}
	
	
}






