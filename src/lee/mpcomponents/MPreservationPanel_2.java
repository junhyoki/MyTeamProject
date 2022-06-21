package lee.mpcomponents;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import lee.OjdbcConnection;
import lee.mpevents.MPcheckboxIL;
import lee.mpmodel.MPreservationlistModel;

//���ų��� ���� �� �г�
//��񿡼� ���ų��� ������ �� ���� ��¥ ������ ���ų����� �����;� ��...
public class MPreservationPanel_2 extends JPanel {
	 
	String user_id = "abc123";// �ϴ� �ӽ÷�(�ٸ� �����ӿ��� ���޹��� ����) 
	
	JButton MPreservationcancleBtn = new JButton("�������");
	
	BorderLayout MPborderlayout = new BorderLayout();
	
	JPanel MPreservation_3 = new JPanel();
	BoxLayout MPboxlayout = new BoxLayout(MPreservation_3, BoxLayout.Y_AXIS);
	JScrollPane MPscroll = new JScrollPane(MPreservation_3, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	
	JCheckBox[] cbArr;
	
	public MPreservationPanel_2() {  
		
		setLayout(MPborderlayout);
		MPreservation_3.setLayout(MPboxlayout);
	
		//�̰� �޼���ȭ �ؼ� ���ΰ�ħ �ϴ� ����� ����? �������������������������������
		//���� Ƽ�� ���� ���� ��������Ʈ�г� �߰�
		ArrayList<MPreservationlistPanel> MPreservationlistArrList = new ArrayList<>();
	
		//JCheckBox[] cbArr = null;
		int ticketNum = 0;
		
		try (Connection conn = OjdbcConnection.getConnection();){	
			
			//�ϴ� �̳����� �˻������ ����� �ް�
			ArrayList<MPreservationlistModel> sqlResults = MPreservationlistModel.get(conn, user_id, "22/06/20");
			ticketNum = sqlResults.size();
			
			//üũ�ڽ� �ֱ�
			cbArr =new JCheckBox[ticketNum];//Ƽ�ϼ���ŭ üũ�ڽ� ������ �Ŵϱ� 
			
			//int spHeight = 0;
			for(int i = 0; i < ticketNum; ++i) {  			
				
				int br_id = sqlResults.get(i).getBr_id();
				
				
				//���� ����Ʈ �г��� ý�� ����
				cbArr[i] = new JCheckBox(Integer.toString(br_id));
				cbArr[i].setBounds(400, 77, 18, 18);
				cbArr[i].addItemListener(new MPcheckboxIL()); //----���� ���� ������ Ŭ���� �����
				
				
				//���� ����Ʈ �г��� �� ����
				MPreservationlistArrList.add(new MPreservationlistPanel(br_id, sqlResults.get(i).toString()));
				MPreservationlistArrList.get(i).add(cbArr[i]);
				
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
