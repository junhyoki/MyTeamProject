package park;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Practice {

    public static void main(String args[]){

    	// �÷ο췹�̾ƿ� ����
          JFrame f = new JFrame("FlowLayoutTest");

          f.setBounds(100,100,200,500);

          //���� ������ FlowLayout����

          f.setLayout(new FlowLayout(FlowLayout.LEFT));

         

          f.add(new JButton("ù��°"));

          f.add(new JButton("�ι�°"));

          f.add(new JButton("����°"));

          f.add(new JButton("�׹�°"));

          f.add(new JButton("�ټ���°"));

          f.setVisible(true);

    }

}
