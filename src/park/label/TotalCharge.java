package park.label;

import javax.swing.JLabel;

import park.ReservationInfo;

public class TotalCharge extends JLabel{
	
	
	public TotalCharge(ReservationInfo user) {
		super("���� �ݾ� : "+user.getTotalCharge());
	}

}
