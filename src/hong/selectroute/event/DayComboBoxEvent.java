package hong.selectroute.event;

import java.awt.event.ItemEvent;

import hong.selectroute.SelectRouteMainFrame;

public class DayComboBoxEvent extends RouteMainFrameItem {
	
	// ��¥�� ������ �� �ִ� �޺��ڽ�
	
	public DayComboBoxEvent(SelectRouteMainFrame main) {
		super(main);
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		
		// �޺��ڽ��� ���õǸ� true
		if(e.getStateChange() == 1) {
			main.setDay((int)e.getItem());
		}
		
	}
}
