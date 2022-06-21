package lee.mpcomponents;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import lee.OjdbcConnection;
import lee.mpmodel.MPreservationlistModel;

//���ų��� ���� �� �г�
public class MPreservationPanel_2 extends JPanel {
	
	//��񿡼� ���ų��� ������ �� ���� ��¥ ������ ���ų����� �����;� ��... 
	
	String user_id = "abc123";// �ϴ� �ӽ÷�(�ٸ� �����ӿ��� ���޹��� ����) 
	
	JButton MPreservationcancleBtn = new JButton("�������");
	
	BorderLayout MPborderlayout = new BorderLayout();
	
	JPanel MPreservation_3 = new JPanel();
	BoxLayout MPboxlayout = new BoxLayout(MPreservation_3, BoxLayout.Y_AXIS);
	JScrollPane MPscroll = new JScrollPane(MPreservation_3, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	
	
	public MPreservationPanel_2() {  
		
		setLayout(MPborderlayout);
		MPreservation_3.setLayout(MPboxlayout);


		
		//���� Ƽ�� ���� ���� ��������Ʈ�г� �߰�
		ArrayList<MPreservationlistPanel> MPreservationlistArrList = new ArrayList<>();
	
		try (Connection conn = OjdbcConnection.getConnection();){	
			
			//�ϴ� �̳����� �˻������ ����� �ް�
			ArrayList<MPreservationlistModel> sqlResults = MPreservationlistModel.get(conn, user_id, "22/06/20");
			int ticketNum = sqlResults.size();
			
			//int spHeight = 0;
			for(int i = 0; i < ticketNum; ++i) {  			
				MPreservationlistArrList.add(new MPreservationlistPanel(sqlResults.get(i).getBr_id(), sqlResults.get(i).toString()));
				MPreservation_3.add(MPreservationlistArrList.get(i));  
				MPreservation_3.setPreferredSize(new Dimension(500, 180*ticketNum));//����Ʈ�г��� ���̿� Ƽ�ϼ� ������ߵʡ�
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		MPscroll.getVerticalScrollBar().setUnitIncrement(6);// ��ũ�� �ӵ� ����
		
		
		
		
		
		
		
		MPreservationcancleBtn.setBorderPainted(false);
		
		add(MPreservationcancleBtn, "South");
		add(MPscroll, "Center");
	}
}
