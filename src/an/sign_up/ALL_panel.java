package an.sign_up;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ALL_panel extends JPanel{
	JButton in = new Sign_Button("ȸ������");
	//JButton check = new Sign_Button("���̵� �ߺ�Ȯ��");
	//JButton checkpass = new Sign_Button("��й�ȣ Ȯ��");
	//JButton out = new Sign_Button("������");
	
	JPanel signPanel = new Sign_Panel(in); 
	JPanel imagePanel = new ImagePanel();
	JLabel allLabel = new JLabel();
	//JPanel radioPanel = new Radio_Panel();
	
	public class new_panel extends JPanel{
		public new_panel() {
			setLayout(new FlowLayout());	
			setBackground(new Color(0X4D7F86));
			
			add(in);
		}
	}
	public ALL_panel() {
		setLayout(new GridLayout(1,1));
		allLabel.setLayout(new BorderLayout());
		
		allLabel.add(signPanel,BorderLayout.NORTH);
		allLabel.add(imagePanel,BorderLayout.SOUTH);
		allLabel.add(new new_panel(),BorderLayout.CENTER);
		add(allLabel);
		
		
	}
	
	

}
