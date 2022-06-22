package lee.mpcomponents;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
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
	
	//Ƽ�� Ʋ�� �Ǵ� �г� (�ȿ� ��, �n�� ��) 
	JPanel MPreservation_3 = new JPanel();
	
	JCheckBox[] cbArr;
	
	public MPreservationPanel_2() {  
	
		
		JScrollPane MPscroll = new JScrollPane(MPreservation_3, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		BoxLayout MPboxlayout = new BoxLayout(MPreservation_3, BoxLayout.Y_AXIS);		
		
		setLayout(MPborderlayout);
		MPreservation_3.setLayout(MPboxlayout);
	
		//���� Ƽ�� ���� ���� ��������Ʈ�г� �߰�
		ArrayList<MPreservationlistPanel> MPreservationlistArrList = new ArrayList<>();
		
		int ticketNum = 0;
		ArrayList<MPreservationlistModel> sqlResults = null;
		try (Connection conn = OjdbcConnection.getConnection();){	
			//�̳����� �˻������ ����� ����            �����"22/06/20" �̰� �ӽ÷� ä��� ���� ��¥ ���ؼ� �ִ� �ɷ� �ٲٱ������
			sqlResults = MPreservationlistModel.get(conn, user_id);
			ticketNum = sqlResults.size();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//üũ�ڽ� ���� �迭
		cbArr = new JCheckBox[ticketNum]; //Ƽ�ϼ���ŭ üũ�ڽ� ������ �Ŵϱ� 
		
		for(int i = 0; i < ticketNum; ++i) {  			
			
			int br_id = sqlResults.get(i).getBr_id();
			
			//���� ����Ʈ �г��� ý�� ����
			cbArr[i] = new JCheckBox(Integer.toString(br_id));//üũ�ڽ��� br_id�� �ؽ�Ʈ�� ���� ������ ũ�⸦ 18, 18�� �����ؼ� �� ���̰� ��
			cbArr[i].setBounds(400, 77, 18, 18);
			cbArr[i].addItemListener(new MPcheckboxIL()); //MPcheckboxIL �� �����۸����� ��� ���� Ŭ����. (�n�ڿ��� �����۸����� �� �� ����) 
			
			//���� ����Ʈ �г��� �� ����
			MPreservationlistArrList.add(new MPreservationlistPanel(br_id, sqlResults.get(i).toString()));
			MPreservationlistArrList.get(i).add(cbArr[i]);//üũ�ڽ��� ���⼭ �޾���
			
			MPreservation_3.add(MPreservationlistArrList.get(i)); //�ϼ��� ���Ÿ���Ʈ �г�(��+�n�� ��� ����) �� MPreservation_3(��ũ�� ���� JPanel) �� ���̱� 
			MPreservation_3.setPreferredSize(new Dimension(500, 180*ticketNum));//����Ʈ�г��� ���̿� Ƽ�ϼ� ������ߵʡ�
			//��ũ�� �۵��Ϸ��� setPreferredSize�� ������ ��������� �ߴ���
		}
		
		
		MPscroll.getVerticalScrollBar().setUnitIncrement(6);// ��ũ�� �ӵ� ����

		MPreservationcancleBtn.setBorderPainted(false);
		add(MPreservationcancleBtn, "South");
		add(MPscroll, "Center");
		
	}
	
}
