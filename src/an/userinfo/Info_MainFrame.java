package an.userinfo;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import an.login.Login_Mainframe;
import hong.SaveInfo;
import hong.selectroute.SelectRouteMainFrame;
import lee.mpcomponents.MPmainFrame;

public class Info_MainFrame extends JFrame{
	JButton Reservation = new Info_JButton("����");
	JButton myinfo 		= new Info_JButton("������");
	JButton logout 		= new Info_JButton("�α� �ƿ�");
	
	JPanel buttonPanel = new Info_Panel(Reservation,myinfo,logout);
	JPanel imagePanel = new Info_ImagePanel();
	JPanel titlePanel = new Info_TitlePanel();

	SaveInfo saveInfo;
	
	
	public Info_MainFrame(SaveInfo saveInfo) {
		
		this.saveInfo = saveInfo;
		
		setTitle("��������");
		
		add(titlePanel,BorderLayout.NORTH);
		add(imagePanel,BorderLayout.CENTER);
		add(buttonPanel,BorderLayout.SOUTH);
		/////////////////////////////////////////
		// ���� �̺�Ʈ
		Reservation.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new SelectRouteMainFrame(saveInfo);
				dispose();
			}
		});
		
		
		//������ �̺�Ʈ
		myinfo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				new MPmainFrame(saveInfo);
				dispose();
			}
		});
		
		//�α׾ƿ� �̺�Ʈ
		logout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Login_Mainframe();
				dispose();
			}
		});
		
		setBounds(500, 200, 800, 500);
		setResizable(false);  
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

}
