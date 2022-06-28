package an.find;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Pattern;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Pass_AllPanel extends JPanel{
	JTextField nameText = new Find_TextField(10);
	JTextField idText = new Find_TextField(10);
	final String REGEX = "[0-9]+";
	
	JLabel nameLabel = new Find_ErrorLabel("�̸��� �Է��� �ּ���."); 
	JLabel idLabel = new Find_ErrorLabel("���̵�� ���� �Ǵ� ���� �ּ� 5�ڿ��� �ִ� 11�� �Դϴ�.");
	
	
	
	public Pass_AllPanel(JTextField j ,JTextField j2) {
		setLayout(new GridLayout(4,1));
		idText = j;
		nameText = j2;
		JPanel name = new Pass_NamePanel(nameText);
		JPanel id = new Pass_IdPanel(idText);	
		
		add(name);add(nameLabel);add(id);add(idLabel);
		
		
		
		//���̵� ��� �޼��� ����
		idText.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				String id = idText.getText();
				if (id.length() < 5) {
					idLabel.setForeground(Color.red);
					idLabel.setText("���̵�� 5���� �̻��̿��� �մϴ�");
				} else if (Pattern.matches("^[a-zA-Z]{1}[a-zA-Z0-9_]{4,11}$", id)) {
					idLabel.setForeground(Color.BLUE);
					idLabel.setText("�ǹٸ� ���̵� �����Դϴ�.");
				}else if(id.length()>=12) {
					idLabel.setForeground(Color.red);
					idLabel.setText("���̵�� 11���� �����̿��� �մϴ�");
				}else {
					idLabel.setForeground(Color.red);
					idLabel.setText("�ǹٸ� ���̵� ������ �Է��ϼ���");
				}
			}
		});
		
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
