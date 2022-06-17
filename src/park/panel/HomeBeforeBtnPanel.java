package park.panel;

import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.JPanel;

import park.button.BeforeButton;
import park.button.HomeButton;

public class HomeBeforeBtnPanel extends JPanel{ // Ȩ��ư, ������ư �Ϸķ� ��Ÿ�� �г�

	HomeButton homeBtn = new HomeButton();
	BeforeButton befBtn = new BeforeButton();
	
	public HomeBeforeBtnPanel() {
		LayoutManager manager = new FlowLayout(FlowLayout.LEFT); // �ǳ��� ���̾ƿ��� ���ʺ��� �Ϸķ� ������Ʈ�� ����ϴ� ���·� ����
		setLayout(manager);
		add(homeBtn);
		add(befBtn);
	}
}
