package an.sign_up;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ALL_panel extends JPanel{
	JButton in = new Sign_Button("ȸ������");
	//JButton check = new Sign_Button("���̵� �ߺ�Ȯ��");
	//JButton checkpass = new Sign_Button("��й�ȣ Ȯ��");
	//JButton out = new Sign_Button("������");
	
	JPanel signPanel = new Sign_Panel(in); 
	//JPanel radioPanel = new Radio_Panel();
	
	public class new_panel extends JPanel{
		public new_panel() {
			setLayout(new FlowLayout());
			add(in);
		}
	}
	public ALL_panel() {
		setLayout(new BorderLayout());
		add(signPanel,BorderLayout.CENTER);//add(radioPanel);
		add(new new_panel(),BorderLayout.SOUTH);
		
	}
	
	

}
