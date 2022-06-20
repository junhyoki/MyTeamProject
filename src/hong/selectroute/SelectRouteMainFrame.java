package hong.selectroute;

import java.awt.Color;

import javax.swing.JFrame;

public class SelectRouteMainFrame extends JFrame {
	
	SelectRouteMainPanel mainPanel = new SelectRouteMainPanel();
	
	public SelectRouteMainFrame() {
		
		setTitle("���� ���� �ý���");
		
		add(mainPanel);
		
		setBounds(300, 100, 600, 650);
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new SelectRouteMainFrame();
	}
}
