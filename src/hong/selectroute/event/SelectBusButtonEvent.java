package hong.selectroute.event;

import java.awt.event.ActionEvent;

import hong.selectroute.SelectRouteMainFrame;

public class SelectBusButtonEvent extends RouteMainFrameAction {
	
	public SelectBusButtonEvent(SelectRouteMainFrame main) {
		super(main);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		main.busFrameClose();
		// e.toString().indexOf("on ") + 3 �ϸ� ����id �����ϴ� index�� ����
		// e.toStrig().substring���� ���� ���� index���� ������ ����id�� ���� String ���� ����
		main.setBusID(Integer.parseInt(e.toString().substring(e.toString().indexOf("on ") + 3)));
	}
}
