package lee.mpcomponents;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

//���ų��� ���� �� �г�
public class MPreservationPanel_2 extends JPanel {
	
	//��񿡼� ���ų��� ������ �� ���� ��¥ ������ ���ų����� �����;� ��... 
	
	JButton MPreservationcancleBtn = new JButton("�������");
	
	ArrayList<MPreservationlistPanel> MPreservationlistArrList = new ArrayList<>();

	BorderLayout MPborderlayout = new BorderLayout();
	
	JPanel MPreservation_3 = new JPanel();
	BoxLayout MPboxlayout = new BoxLayout(MPreservation_3, BoxLayout.Y_AXIS);
	JScrollPane MPscroll = new JScrollPane(MPreservation_3, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	
	
	public MPreservationPanel_2() {  
		
		setLayout(MPborderlayout);
		MPreservation_3.setLayout(MPboxlayout);
		
	
		MPreservationcancleBtn.setBorderPainted(false);
		
		 
		
		int spHeight = 0;
		//�ϴ� ���� Ƽ�� ���� 3���̶�� ���� 
		for(int i = 0; i < 4; ++i) { //�̰� �� Ƽ�� �� �þ�� ��ũ�� �Ǿ� �Ǵµ� ��ũ���� �� �ǰ� ���� ���ļ� ��Ÿ���� 
			MPreservationlistArrList.add(new MPreservationlistPanel());
			MPreservation_3.add(MPreservationlistArrList.get(i));
			spHeight++;//�ϴ��� �ӽ÷� spHeight ���� �����ؼ� �ű⿡ Ƽ�ϼ� ����ִµ� ���߿� DB �����ϸ� ����� �װɷ� �ϱ�  
		}
		MPreservation_3.setPreferredSize(new Dimension(500, 180*spHeight)); //����Ʈ�г��� ���̿� Ƽ�ϼ� ������ߵʡ�
		
		MPscroll.getVerticalScrollBar().setUnitIncrement(6);// ��ũ�� �ӵ� ����
		
		
		
		
		add(MPreservationcancleBtn, "South");
		add(MPscroll, "Center");
	}
}
