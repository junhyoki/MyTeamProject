package an.find;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class IdFind_ALLPanel extends JPanel{
	JTextField nameText = new Find_TextField(10);
	JTextField pnText = new Find_TextField(10);
	JLabel nameLabel = new Find_ErrorLabel("�̸��� �Է��� �ּ���.");
	final String REGEX = "[0-9]+";
	JLabel pnLabel = new Find_ErrorLabel("��ȭ��ȣ�� ������ xxx-xxx-xxxx�Դϴ�.");
	
	
	public IdFind_ALLPanel(JTextField j, JTextField j2) {
		setLayout(new GridLayout(4,1));
		nameText = j;
		pnText = j2;
		
		JPanel name = new IdFind_NamePanel(nameText);
		JPanel pn = new IdFind_PnPanel(pnText);
		
		
		add(name);add(nameLabel);add(pn);add(pnLabel);
		
		
		//��ȭ ��ȣ ��� �̺�Ʈ
		pnText.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				
				String pnnum = pnText.getText();
				System.out.println(pnnum);
				
				if(!Pattern.matches("\\d{3}-\\d{4}-\\d{4}", pnnum)) {
					pnLabel.setForeground(Color.red);
					pnLabel.setText("��ȭ��ȣ�� ������ xxx-xxx-xxxx�Դϴ�.");
				 }else {
					 pnLabel.setForeground(Color.BLUE);
					 pnLabel.setText("�ùٸ� ������ ��й�ȣ �Դϴ�.");
				 }
			}
		});	
		//�̸� ��� �̺�Ʈ
		nameText.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				String name = nameText.getText();
				
				if(name =="") {
					nameLabel.setText("�̸��� �Է��ϼ���.");
					nameLabel.setForeground(Color.red);
				}	
				else if(Pattern.matches(REGEX,name)) {
					nameLabel.setText("�̸����� ���ڸ� �Է��ϽǼ� �����ϴ�.");
					nameLabel.setForeground(Color.RED);
					}
				else {
					nameLabel.setText("�̸��� �Է��ϼ̽��ϴ�.");
					nameLabel.setForeground(Color.blue);
				}
				
			}
			
		});	
	}

}
