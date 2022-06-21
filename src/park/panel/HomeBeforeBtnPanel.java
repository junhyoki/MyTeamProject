package park.panel;

import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.JPanel;

import park.ReservationInfo;
import park.button.BeforePayButton;
import park.button.HomeButton;

public class HomeBeforeBtnPanel extends JPanel{ // Ȩ��ư, ������ư �Ϸķ� ��Ÿ�� �г�

	HomeButton homeBtn ;
	BeforePayButton befBtn ;
	
	public HomeBeforeBtnPanel(ReservationInfo user) {
		LayoutManager manager = new FlowLayout(FlowLayout.LEFT); // �ǳ��� ���̾ƿ��� ���ʺ��� �Ϸķ� ������Ʈ�� ����ϴ� ���·� ����
		setLayout(manager);
		
		homeBtn = new HomeButton(user);
		befBtn = new BeforePayButton(user);
		
		add(homeBtn);
		add(befBtn);
			
	
		setBounds(10, 10, 500, 60);
	}
}
