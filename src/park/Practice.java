package park;

import java.util.LinkedHashMap;
import java.util.Set;

import javax.swing.JFrame;

import park.scrollpane.PayInfoScrollpane;

public class Practice extends JFrame{

//    public static void main(String args[]){
//    	// �÷ο췹�̾ƿ� ����
//          JFrame f = new JFrame("FlowLayoutTest");
//          f.setBounds(100,100,200,500);
//          //���� ������ FlowLayout����
//          f.setLayout(new FlowLayout(FlowLayout.LEFT));
//
//          f.add(new JButton("ù��°"));
//          f.add(new JButton("�ι�°"));
//          f.add(new JButton("����°"));
//          f.add(new JButton("�׹�°"));
//          f.add(new JButton("�ټ���°"));
//          f.setVisible(true);
//}

	public Practice() {
		
		add(new PayInfoScrollpane());
		setBounds(100, 100, 500, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		LinkedHashMap<String,String> map = new LinkedHashMap<>();
		
		map.put("21", "����");
		map.put("17", "û�ҳ�");
		map.put("18", "û�ҳ�");
		map.put("11", "���");
		map.put("5", "����");
		
		System.out.println(map.size());
		Set<String> key = map.keySet();
		for(String keys : key) {
			System.out.println(keys);
		}
	}
}
