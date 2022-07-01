package hong.selectseat.event;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import hong.selectseat.SelectSeatMainFrame;

public class NextButtonEvent extends SeatMainFramAction{
	
	public NextButtonEvent(SelectSeatMainFrame main) {
		super(main);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		main.putSeat();
		if (main.getSelectCnt() == 0) {
			JOptionPane.showMessageDialog(null, "�¼��� ���ڸ� �̻� �������ּ���!", "�¼� Ȯ��", JOptionPane.PLAIN_MESSAGE);
			return;
		}
		main.nextFrame();
		main.thisClose();
	}
}
