package lee.mpcomponents;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class MPprofilePanel_2 extends JPanel {
	
	JButton MPbackBtn = new JButton("�ڷΰ���");
	JButton MPcompleteBtn = new JButton("�����Ϸ�");
	
	JPanel MPlabelPanel = new JPanel();//���̾ƿ��� �׸���鷹�̾ƿ�����
	
	//�׹鷹
	GridBagLayout gbl = new GridBagLayout();
	GridBagConstraints gblc = new GridBagConstraints();

	JLabel MPviewLb1 = new JLabel("   �̸� "); //�� �길 Ƣ��� ����?��
	JLabel MPviewLb2 = new JLabel("�ڵ��� ��ȣ ");
	JLabel MPviewLb3 = new JLabel("�� ��й�ȣ ");
	
	
	JTextField MPnameTf = new JTextField(25);
	JTextField MPphoneTf = new JTextField(25);
	JPasswordField MPnewpwTf = new JPasswordField(25);
	 
	
	public MPprofilePanel_2() {
		setLayout(null);

		MPviewLb1.setFont(new Font("���", Font.BOLD, 14));
		MPviewLb2.setFont(new Font("���", Font.BOLD, 14));
		MPviewLb3.setFont(new Font("���", Font.BOLD, 14));
	
		
		
		//����й�ȣ �ؽ�Ʈ�ʵ� �Է��� �� �ܷ� ǥ�� 
		MPnewpwTf.setEchoChar('��');
	
		//��й�ȣ���ʿ� �Է��� ���(���� �ٲܰ�) String���� ��������
		MPgetPwd(MPnewpwTf);		
	
		
		MPphoneTf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(Character.isDigit(c) || c=='\b')) {
					MPphoneTf.setText("���ڸ� �Է����ּ���.");
					return;
				}
			}
		}); 
		
			
		
//�׸���鷹�̾ƿ� �����ϴ� �κ�_______________________________________________________________
		//��ǲ�г� ����
		MPlabelPanel.setLayout(new GridLayout());
		MPlabelPanel.setBounds(85, 90, 350, 170);
		//MPlabelPanel.setBackground(Color.pink);
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
		//gridx���� ������� ���ȣ, ����ȣ, �ʺ�, ���̸� �ǹ�
		
		gblc.fill = gblc.BOTH;//��ü�� ä���°ŷ� 
		gblc.gridx = gridx;
		gblc.gridy = gridy;
		gblc.gridwidth = gridwidth;
		gblc.gridheight = gridheight;
		gbl.setConstraints(c,  gblc);
		gblc.insets = new Insets(15, 10, 10, 10);
		MPlabelPanel.add(c);
	}
	
	
	public void tfSetDefaultTexts() {
		MPnameTf.setText("�⺻����");
		MPphoneTf.setText("�⺻����");
		MPnewpwTf.setText("�⺻����");
	}
	
	
	
	public String MPgetPwd(JPasswordField MPnewpwTf) {
		StringBuilder pw = new StringBuilder();
		//tf_pw �ʵ忡�� �н����带 ����, char[] �迭�� ����
		char[] secret_pw = MPnewpwTf.getPassword(); 
		
		//secret_pw �迭�� ����� ��ȣ�� �ڸ��� ��ŭ for�� �����鼭 cha �� �� ���ھ� ����
	    for(char cha : secret_pw){         
	        Character.toString(cha);       //cha �� ����� �� string���� ��ȯ
	       //pw �� �����ϱ�, pw �� ���� ��������� ����, ���� ������ �̾ �����ϴ� ���׿�����
	         //pw += (pw.equals("")) ? ""+cha+"" : ""+cha+"";   
	        pw.append(cha);
	    }
		return pw.toString();
	}
}






