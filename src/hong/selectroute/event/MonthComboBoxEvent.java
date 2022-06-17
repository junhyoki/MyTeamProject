package hong.selectroute.event;

import java.awt.event.ItemEvent;

import hong.selectroute.SelectRouteMainPanel;

public class MonthComboBoxEvent extends RouteMainPanelItem {
	
	public MonthComboBoxEvent(SelectRouteMainPanel main) {
		super(main);
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		// ���� �Ǹ� true
		if(e.getStateChange() == 1) {
			int month = (int)e.getItem();
			
			// main�� �ִ� addDays �޼��忡 ���õ� ���� int�� ����
			main.addDays(month);
			main.inputMonth(month);
		} else {
			// ������ ���� ��� �߰��ǹǷ� main�� �ִ� �޼���� ��� ���ŵ� ������Ѵ�.
			main.resetDays();
		}
		
	}
	
}
