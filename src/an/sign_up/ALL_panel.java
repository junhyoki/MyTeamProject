package an.sign_up;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ALL_panel extends JPanel{
	JButton in = new Sign_Button("ȸ������");
	JButton out = new Sign_Button("������");
	
	JPanel signPanel = new Sign_Panel(in,out); 
	//JPanel radioPanel = new Radio_Panel();
	
	public class new_panel extends JPanel{
		public new_panel() {
			add(in);add(out);
		}
	}
	
	public ALL_panel(JButton out) {
		
		this.out= out;
		setLayout(new GridLayout(1,0));
		add(signPanel);//add(radioPanel);
		add(new new_panel());
		
	}
	
	

}
