package park;

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
		new Practice();
	}
}
