package hong.selectroute.event;

import java.awt.event.ActionEvent;

import hong.selectroute.SelectRouteMainFrame;

public class SerchButtonEvent extends RouteMainFrameAction {
	
	// ���, ��¥�� �´� ������ ��ȸ�� �� �ִ� ��ư �̺�Ʈ
	
	public SerchButtonEvent(SelectRouteMainFrame main) {
		super(main);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		main.getRouteID();
		main.showBus();
	}

}
