package park.combobox;

import javax.swing.JComboBox;

public class SelectSeatNumBox extends JComboBox{ // ���ɺ� �¼������� �� �޺��ڽ�
	
	String person;
	int num;
	
	public SelectSeatNumBox(String person, int num) {
		this.person = person;
		this.num = num;
	}

}
