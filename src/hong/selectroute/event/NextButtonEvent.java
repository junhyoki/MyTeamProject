package hong.selectroute.event;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import hong.selectroute.SelectRouteMainFrame;

public class NextButtonEvent extends RouteMainFrameAction {
	
	public NextButtonEvent(SelectRouteMainFrame main) {
		super(main);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			main.save();
			main.showSeatFrame();
			main.thisFrameClose();			
		} catch (IndexOutOfBoundsException iobe) {
			JOptionPane.showMessageDialog(null, "������ ���� �������ּ���!!", "���!!", JOptionPane.WARNING_MESSAGE);
		} catch (NullPointerException np) {
			JOptionPane.showMessageDialog(null, "������ ���� �������ּ���!!", "���!!", JOptionPane.WARNING_MESSAGE);
		}
	}
}