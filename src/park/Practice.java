package park;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import park.scrollpane.PayInfoScrollpane;

public class Practice extends JFrame{

    public static void main(String args[]){
    	// �÷ο췹�̾ƿ� ����
          JFrame f = new JFrame("FlowLayoutTest");
          JPanel p = new JPanel();
          f.setBounds(100,100,400,500);
          //���� ������ FlowLayout����
          Dimension size = new Dimension();
          size.setSize(400, 500);
          
          JScrollPane scroll = new JScrollPane();
          f.setLayout(new BorderLayout());
          f.add(scroll,"Center");
          LayoutManager manager = new FlowLayout(FlowLayout.LEFT);
          p.setPreferredSize(size);
          p.setLayout(manager);
          p.add(new JButton("ù��°"));
          p.add(new JButton("�ι�°"));
          p.add(new JButton("����°"));
          p.add(new JButton("�׹�°"));
          p.add(new JButton("�ټ���°"));
          p.add(new JButton("�ټ���°"));
          p.add(new JButton("�ټ���°"));
          p.add(new JButton("�ټ���°"));
          p.add(new JButton("�ټ���°"));
          
          scroll.setViewportView(p);          
          f.setVisible(true);
}

	public Practice() {
		
		add(new PayInfoScrollpane());
		setBounds(100, 100, 500, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
}
