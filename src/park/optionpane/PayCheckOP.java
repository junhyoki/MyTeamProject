package park.optionpane;

import javax.swing.JOptionPane;

import park.ReservationInfo;

public class PayCheckOP extends JOptionPane{
	
	public PayCheckOP(ReservationInfo user) {
		showConfirmDialog(null, String.format(" ���� �ݾ� : %d\n���� �Ͻðڽ��ϱ�?", (int)(user.getTotalCharge())), "���� Ȯ��", OK_CANCEL_OPTION, INFORMATION_MESSAGE );
	}
}
