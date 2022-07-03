package lee.mpcomponents;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import an.OjdbcConnection;
import hong.SaveInfo;
import lee.RoundedButton;
import lee.mpevents.MPcheckboxIL;
import lee.mpmodel.MPreservationlistModel;

//���ų��� ���� �� �г�
public class MPreservationPanel_2 extends JPanel {
	 
	SaveInfo saveInfo;
	String user_id; 
	
	JCheckBox chkAll = new JCheckBox(" ��ü ����");//��ü���� üũ�ڽ�
	
	RoundedButton MPreservationcancleBtn = new RoundedButton("�������");// ������� ��ư
	
	BorderLayout MPborderlayout = new BorderLayout(); //MPreservation_2�� ������ �������̾ƿ�
	 
	JPanel MPreservation_3 = new JPanel();//Ƽ���� �� ������ ������ Ȯ���س��� �г�(�ڽ����̾ƿ� ����)
	
	JCheckBox[] cbArr; //���ų�������ŭ ���� üũ�ڽ��� ��� üũ�ڽ� �迭
	
	public MPreservationPanel_2(SaveInfo saveInfo) {  

		this.saveInfo = saveInfo;
		this.user_id = saveInfo.get_user_id();

		setLayout(MPborderlayout);
		
		//MPreservation_3�� ��ũ�� �ޱ�
		JScrollPane MPscroll = new JScrollPane(MPreservation_3, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		add(MPscroll, "Center");
		
		//MPresrevation_3�� ���̾ƿ��� BoxLayout
		BoxLayout MPboxlayout = new BoxLayout(MPreservation_3, BoxLayout.Y_AXIS);		
		
		//��ũ�ѹٶ� �ڽ����̾ƿ� ������ MPresevation_3�г� ����
		MPreservation_3.setLayout(MPboxlayout);
		MPreservation_3.setBackground(Color.WHITE);
	
		//��ũ�ѹ� ��� ����
		MPscroll.getVerticalScrollBar().setBackground(Color.WHITE);
		MPscroll.setBorder(null);	
		
		//���� Ƽ�� ���� ���� ��������Ʈ�г� �߰�
		ArrayList<MPreservationlistPanel> MPreservationlistArrList = new ArrayList<>();
		
		int ticketNum = 0;
		ArrayList<MPreservationlistModel> sqlResults = null;
		try (Connection conn = OjdbcConnection.getConnection();){	
			//�̳����� �˻������ ����� ����           
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
			cbArr[i].setBackground(Color.WHITE);
			
			//���� ����Ʈ �г��� �� ����
			MPreservationlistArrList.add(new MPreservationlistPanel(br_id, sqlResults.get(i).toString()));
			MPreservationlistArrList.get(i).add(cbArr[i]);//üũ�ڽ��� ���⼭ �޾���
			
			MPreservation_3.add(MPreservationlistArrList.get(i)); //�ϼ��� ���Ÿ���Ʈ �г�(��+�n�� ��� ����) �� MPreservation_3(��ũ�� ���� JPanel) �� ���̱� 
		}
		
		MPreservation_3.setPreferredSize(new Dimension(500, 180*ticketNum));//����Ʈ�г��� ���̿� Ƽ�ϼ� ������ߵʡ�
		//��ũ�� �۵��Ϸ��� setPreferredSize�� ������ ��������� �ߴ���
		
		MPscroll.getVerticalScrollBar().setUnitIncrement(6);// ��ũ�� �ӵ� ����
		
		MPreservationcancleBtn.setBorderPainted(false);
		MPreservationcancleBtn.setFont(new Font("�޸�����ü", Font.BOLD, 17));
		add(MPreservationcancleBtn, "South");
		
		
		//��ü���� üũ�ڽ� ������ ������
		chkAll.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(chkAll.isSelected() == true) {
					for(JCheckBox cb : cbArr) {
						cb.setSelected(true);
					}
				} else if(chkAll.isSelected() == false) {
					for(JCheckBox cb : cbArr) {
						cb.setSelected(false);
					}
				}
			}
		});
		
		//��ü���� üũ�ڽ� ����
		chkAll.setBackground(Color.WHITE);
		chkAll.setFocusPainted(false);
		chkAll.setFont(new Font("���", Font.BOLD, 14));
		add(chkAll, "North");
		setBackground(Color.WHITE);
	}
	
	
	public void setChkAllUnselected() { //��ü���� üũ�ڽ� üũ ���� �޼���
		chkAll.setSelected(false);
	}
}
