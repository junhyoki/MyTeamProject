package lee.mpcomponents;

import javax.swing.JFrame;

public class MPsmallFrame extends JFrame{
	
	public MPsmallFrame() {
		setTitle("����â_�����");
		setBounds(0, 0, 400, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new MPsmallFrame();
	}
}
