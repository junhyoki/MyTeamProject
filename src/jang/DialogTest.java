package jang;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DialogTest extends JFrame {
	
	ActionListener handler = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("�߰�")) {// �������� == �񱳰��ƴ�
				JOptionPane.showMessageDialog(null, "�߰��Ǿ����ϴ�", "����", JOptionPane.WARNING_MESSAGE);
			} else if (e.getActionCommand().equals("����")) {// �������� == �񱳰��ƴ�
				JOptionPane.showMessageDialog(null, "�����Ǿ����ϴ�", "����", JOptionPane.WARNING_MESSAGE);
			} else if (e.getActionCommand().equals("����")) {// �������� == �񱳰��ƴ�
				JOptionPane.showMessageDialog(null, "�����Ǿ����ϴ�", "����", JOptionPane.WARNING_MESSAGE);
			}
		}
	};

}
