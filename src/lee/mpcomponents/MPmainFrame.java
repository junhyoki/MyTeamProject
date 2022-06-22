package lee.mpcomponents;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import lee.OjdbcConnection;
import lee.mpevents.MPBackBtnEvent;
import lee.mpevents.MPcheckboxIL;
import lee.mpevents.MPcompleteBtnEvent;
import lee.mpevents.MPeditBtnEvent;
import lee.mpevents.MPnavBtnsEvent;
import lee.mpevents.MPreservationCancleBtnEvent;
import lee.mpmodel.MPreservationlistModel;

public class MPmainFrame extends JFrame {

	String user_id = "abc123";
	
	JButton MPhomeBtn = new JButton();
	JLabel MPcategoryLb = new JLabel("ī�װ���");
	
	MPnavPanel MPnav = new MPnavPanel();
	MPcontentsPanel MPcontents = new MPcontentsPanel();
	
	//üũ�� üũ�ڽ��� ��� ���Ź�ȣ ��� ��� 
	ArrayList<Integer> br_id_list = new ArrayList<>();
	

//�׼Ǹ����ʿ��� ���� �޼���� ����_____________________________________________________________________________________________________________
	
	//ī�װ��� �� �ؽ�Ʈ �ٲٴ� �޼���
		public void setCategoryLabelText(String title) {
			MPcategoryLb.setText(title);	
		}
	
	//�׺���̼� 3��ư �׼�
	public void navBtnCtrl (JButton btn) {
		if(btn.getText().equals("�� ���� ��ȸ/����")) {
			setCategoryLabelText("�� ���� ��ȸ");
			MPcontents.MPcontentsCard.show(MPcontents, "������");
			MPcontents.MPprofile.showMPprofile_1();
		} else if(btn.getText().equals("���� Ȯ��")) {
			setCategoryLabelText(btn.getText());
			MPcontents.MPcontentsCard.show(MPcontents, "���ų���");
		} else if(btn.getText().equals("���� Ż��")) {
			setCategoryLabelText(btn.getText());
			MPcontents.MPcontentsCard.show(MPcontents, "����Ż��");
		}
	}	
	
	
	//�����ʼ����ϱ� ��ư ������ ��
	public void editBtnCtrl () {		
		setCategoryLabelText("�� ���� ����");
		MPcontents.MPprofile.showMPprofile_2(); 
		MPcontents.MPprofile.MPprofile_2.setTfEmpty();
	}

	
	//�����ʼ����ϱ� ȭ�鿡�� �ڷΰ��� ��ư ������ �� (������ �����ϸ� �� �� ��) �ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�
	public void backBtnCtrl () {
		setCategoryLabelText("�� ���� ��ȸ");
		MPcontents.MPprofile.MPprofile_2.setTfEmpty();
		MPcontents.MPprofile.showMPprofile_1();
	}
	
	
	//�����ʼ����ϱ� ȭ�鿡�� ���� �Ϸ� ��ư ������ �� (������ �����ؾߵ� ��) �ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�
	public void completeBtnCtrl() {
		setCategoryLabelText("�� ���� ��ȸ");
			
		//���⿡ ������ ���� �����ϴ� ��� �ֱ� �ڡڡڡڡڡڡڡڡڡڡڡڡڢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�

		MPcontents.MPprofile.MPprofile_2.setTfEmpty();
		MPcontents.MPprofile.showMPprofile_1();		

	} //������ ���� ȭ�鿡�� �׻� �ֽ� ���� �ߵ��� �س��߰ڳ� 

	
	public void reservationcancleBtnCtrl() {
		int checkNum = 0;
		//System.out.println(MPcontents.MPreservation.MPreservation_2.cbArr.length);
		for(JCheckBox cb : MPcontents.MPreservation.MPreservation_2.cbArr) {
			if(cb.isSelected()) {
				br_id_list.add(Integer.parseInt(cb.getText()));
				checkNum++;
			} 
		}
		System.out.println(checkNum);
		//üũ�� üũ�ڽ��� ���� �� ���� â�� �� �߰�, �ϳ��� ������ ���� â(���� ���?) ��
		if(checkNum > 0) {
			
			//���� ����Ͻðڽ��ϱ�? ���� â
			MPreservationSF sf = new MPreservationSF();
			
			//�������?����â���� '��'��ư ������ �� 
			sf.yesBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
					try (Connection conn = OjdbcConnection.getConnection();){
						
						conn.setAutoCommit(false);
						
						int cancleNum = br_id_list.size();
						
						for(int i = 0; i < cancleNum; ++i) {
							
							//üũ�� üũ�ڽ��� �ش��ϴ� ���Ź�ȣ, �¼���ȣ
							int br_id = br_id_list.get(i);
							int bs_id = MPreservationlistModel.get_bs_id(conn, br_id_list.get(i));
							
							//���Ź�ȣ�� �ش��ϴ� �� bus_reservation ���̺��� ����� �¼���ȣ�� �ش��ϴ� �� bus_seat���̺��� ����� ��!
							MPreservationlistModel.delete_br_id_row(conn, br_id);
							MPreservationlistModel.delete_bs_id_row(conn, bs_id);
						}
						
						conn.commit();//Ŀ�� ����Ŭ ���� �� �ص� �ǰ� ���⼭ �ٷ� ��
						sf.dispose();//�� ������ ���� â �ݱ�

						
						//MPcontents.MPreservation.MPreservation_2.MPreservation_3.removeAll();
						
						
						
					
						 //�̷��� ���ΰ�ħ�ϸ� �������� ��ҹ�ư�� ���� ������ �� ��ü�� �����ϰ� �ǰ� �ű⼭ checkNum�� ������ ������ �Ѱܹ��� �� ���ٴ� ��...
						//_______________________________���ų��� ���ΰ�ħ �κ�_________________________________________
						MPcontents.MPreservation.remove(MPcontents.MPreservation.MPreservation_2);
						MPreservationPanel_2 newMPreservationPanel_2 = new MPreservationPanel_2();
						btnAddAction(newMPreservationPanel_2.MPreservationcancleBtn);
						MPcontents.MPreservation.add(newMPreservationPanel_2);
						
						br_id_list = new ArrayList<>(); //üũ�ڽ� ���õ� ���Ź�ȣ(br_id) ��� ��� ����ְ� 
						
						//�� �ؿ� �� ���� navPanel ���� ����Ȯ�� ������ �� ���۵Ǵ� �͵�(��������ȸ/�����̳� ���� Ż�� ��ư �����ٰ� ����Ȯ�� ������ reservation_2 �гο� �ٲ� ���ų������ �߱淡)  
						
						
						//���ų��� �г� ���ΰ�ħ
						dispose();
						MPmainFrame MPnewmainF = new MPmainFrame();
						MPnewmainF.setCategoryLabelText("����Ȯ��");
						MPnewmainF.MPcontents.MPcontentsCard.show(MPnewmainF.MPcontents, "���ų���");

						//�����������������������������������������������������
						//���� �ذ��� �� ��¥ ���� ��¥�� ��ȸ�ϴ� ��		 
						
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			});
		
		}	
	}
	
	
	
	public void btnAddAction(JButton btn) {
		btn.addActionListener(new MPreservationCancleBtnEvent(this));
	}
	
	
//____________________________________________________________________________________________________________________________________	
	
	
	
	public MPmainFrame() {

		
		setLayout(null);

		setCategoryLabelText("�� ���� ��ȸ");
		
		MPcategoryLb.setBounds(230, 30, 700, 100);
		MPcategoryLb.setFont(new Font("���", Font.PLAIN, 25));
		this.add(MPcategoryLb);
		
		
		MPhomeBtn.setBounds(10, 10, 50, 50);
		MPhomeBtn.setBorderPainted(false);
		

		/*
		//Ȩ��ư ������ Ȩȭ������ ���� 
		MPhomeBtn.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				//�� �̰� main ������ �׼� Ŭ���� ���� �ľ��ϳ�? 
			}
		});
		*/
		
		
		//�׺���̼� �� ��ư 3�� �׼�
		MPnav.MPprofileBtn.addActionListener(new MPnavBtnsEvent(this, MPnav.MPprofileBtn));
		MPnav.MPleaveBtn.addActionListener(new MPnavBtnsEvent(this, MPnav.MPleaveBtn));
		MPnav.MPreservationBtn.addActionListener(new MPnavBtnsEvent(this, MPnav.MPreservationBtn));
		
		
		
		// ������ �г� ��ư�� �׼�
		MPcontents.MPprofile.MPprofile_1.MPeditBtn.addActionListener(new MPeditBtnEvent(this));
		MPcontents.MPprofile.MPprofile_2.MPbackBtn.addActionListener(new MPBackBtnEvent(this));
		MPcontents.MPprofile.MPprofile_2.MPcompleteBtn.addActionListener(new MPcompleteBtnEvent(this));

		
		//������ҹ�ư �׼ǡ��������������������������������
		MPcontents.MPreservation.MPreservation_2.MPreservationcancleBtn.addActionListener(new MPreservationCancleBtnEvent(this));
		
		
	
		
		
		
		add(MPnav);
		add(MPcontents);	
		add(MPhomeBtn);
			
		
		//������ ����
		setTitle("����������");
		getContentPane().setBackground(Color.WHITE);//���� ���߿� ���߱�		
		setBounds(0, 0, 800, 650);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	

	
	//�׽�Ʈ�� ���κ�. ���߿� ����
	public static void main(String[] args) {
		new MPmainFrame();
	}
}
