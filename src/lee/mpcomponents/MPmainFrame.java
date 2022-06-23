package lee.mpcomponents;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import lee.OjdbcConnection;
import lee.mpevents.MPBackBtnEvent;
import lee.mpevents.MPcheckboxIL;
import lee.mpevents.MPcompleteBtnEvent;
import lee.mpevents.MPeditBtnEvent;
import lee.mpevents.MPleaveYesBtnEvent;
import lee.mpevents.MPnavBtnsEvent;
import lee.mpevents.MPreservationCancleBtnEvent;
import lee.mpmodel.MPprofileModel;
import lee.mpmodel.MPreservationlistModel;

public class MPmainFrame extends JFrame {

	String user_id = "abc123";
	
	JButton MPhomeBtn = new JButton();
	JLabel MPcategoryLb = new JLabel("ī�װ���");
	
	MPnavPanel MPnav = new MPnavPanel();
	MPcontentsPanel MPcontents = new MPcontentsPanel();
	
	//üũ�� üũ�ڽ��� ��� ���Ź�ȣ ��� ��� 
	ArrayList<Integer> br_id_list = new ArrayList<>();
	

	
//�׼Ǹ����ʿ��� ���� �޼���� ����##########################################################################################
	
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
			
			//���ų����� ������ ���ų��� ���� �г��� �ߵ���
			try(Connection conn = OjdbcConnection.getConnection();) {
				if(MPreservationlistModel.get(conn, user_id).size() > 0) {
					MPcontents.MPreservation.MPreservationCard.show(MPcontents.MPreservation, "���ų��� ����");
				}
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		} else if(btn.getText().equals("���� Ż��")) {
			setCategoryLabelText(btn.getText());
			MPcontents.MPcontentsCard.show(MPcontents, "����Ż��");
		}
	}	
	
	
	//�����ʼ����ϱ� ��ư ������ ��
	public void editBtnCtrl () {		
		setCategoryLabelText("�� ���� ����");
		dispose();
		MPmainFrame MPnewmainF = new MPmainFrame();
		MPnewmainF.MPcontents.MPprofile.showMPprofile_2(); 		
	}

	//�����ʼ����ϱ� ȭ�鿡�� �ڷΰ��� ��ư ������ �� (������ �����ϸ� �� �ǵ���)
	public void backBtnCtrl () {
		setCategoryLabelText("�� ���� ��ȸ");
		MPcontents.MPprofile.showMPprofile_1();
	}
	
	
	//�����ʼ����ϱ� ȭ�鿡�� ���� �Ϸ� ��ư ������ �� (������ ����ǰ�) 
	public void completeBtnCtrl() {
		if(MPcontents.MPprofile.MPprofile_2.MPnameTf.getText().equals("") 
			|| MPcontents.MPprofile.MPprofile_2.MPphoneTf.getText().equals("") 
			|| MPcontents.MPprofile.MPprofile_2.MPgetPwd(MPcontents.MPprofile.MPprofile_2.MPnewpwTf).equals("")) {
			new MPpreventnulltfSF();
			return;
		}
		
		
		//���� ���� �ƴѰ� ������ ���� â �ߵ��� �ؾߵ�
		boolean result = Pattern.matches("\\d{11}", MPcontents.MPprofile.MPprofile_2.MPphoneTf.getText());
		if(!result) {
			new MPincorrectphonenumSF();
			return;
		}
			
		
		//�̸��̶� ��й�ȣ ���ڼ� �����ϴ� �� �ұ�... ������������������������������������������������������
		if((MPcontents.MPprofile.MPprofile_2.MPnameTf.getText().length() > 10)||(MPcontents.MPprofile.MPprofile_2.MPgetPwd(MPcontents.MPprofile.MPprofile_2.MPnewpwTf).length() > 10)) {		
			new MPnamelengthrestrictSF();
			return;
		}
		

	
		setCategoryLabelText("�� ���� ��ȸ");	
		//������ ���� DB�� ������Ʈ
		try(Connection conn = OjdbcConnection.getConnection()
		) {
			conn.setAutoCommit(false);
			MPprofileModel.MPupdateUserName(conn, user_id, MPcontents.MPprofile.MPprofile_2.MPnameTf.getText());
			MPprofileModel.MPupdateUserPw(conn, user_id, MPcontents.MPprofile.MPprofile_2.MPgetPwd(MPcontents.MPprofile.MPprofile_2.MPnewpwTf));
			//�ڵ�����ȣ�� 01012341234 �� �Է¹޾Ƽ� 010-1234-1234�� ����	
			String str = MPcontents.MPprofile.MPprofile_2.MPphoneTf.getText();
			ArrayList<String> arr = new ArrayList<>();
			arr.add(str.substring(0, 3));
			arr.add(str.substring(3, 7));
			arr.add(str.substring(7, 11));
			MPprofileModel.MPupdateUserPhoneNum(conn, user_id, String.join("-", arr));
			
			conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dispose();
		MPmainFrame MPnewmainF = new MPmainFrame();
		MPcontents.MPprofile.showMPprofile_1();		
	} //������ ���� ȭ�鿡�� �׻� �ֽ� ���� �ߵ��� �س��߰ڳ� 

	
	//������� ��ư ������ ��
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
					
						//_______________________________���ų��� ���ΰ�ħ �κ�_________________________________________
						MPcontents.MPreservation.remove(MPcontents.MPreservation.MPreservation_2);
						MPreservationPanel_2 newMPreservationPanel_2 = new MPreservationPanel_2();
						btnAddAction(newMPreservationPanel_2.MPreservationcancleBtn);
						MPcontents.MPreservation.add(newMPreservationPanel_2);
						
						br_id_list = new ArrayList<>(); //üũ�ڽ� ���õ� ���Ź�ȣ(br_id) ��� ��� ����ְ� 
						
						//���ų��� �г� ���ΰ�ħ
						dispose();
						MPmainFrame MPnewmainF = new MPmainFrame();
						MPnewmainF.setCategoryLabelText("����Ȯ��");
						MPnewmainF.MPcontents.MPcontentsCard.show(MPnewmainF.MPcontents, "���ų���");
						
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
	
	
	
	public void leaveBtnCtrl() {
		
		//���� �����Ͻðڽ��ϱ�? ���� â ����
		MPleaveRealSF sf = new MPleaveRealSF();
		
		//user_info ���̺��� user_info�� �ش��ϴ� �� DELETE 
		sf.yesBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try(Connection conn = OjdbcConnection.getConnection();) {
					conn.setAutoCommit(false);
					
					//�������̺��� user_id ����  ���� �����ϰ� �� ������ user_info�� user_id���� �����ؾߵ�
					MPreservationlistModel.delete_user_id_row(conn, user_id);	
					MPprofileModel.MPdeleteUserInfo(conn, user_id);
					
					conn.commit();
					sf.dispose();
					
					//�����Ǿ����ϴ� ���� â ������ 
					MPleavecompleteSF sf1 = new MPleavecompleteSF();	
					sf1.yesBtn.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							sf1.dispose();
							dispose();
							
							
							
							// ���� �� ���⿡ Ȩȭ������ ���� ��� �߰��ϱ�!!!!�ڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡ�

							
							
						}
					});
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});	
	}
	
	
	
//####################################################################################################################################	
	
	
	
	
	
	
	public MPmainFrame() {

		
		setLayout(null);

		setCategoryLabelText("�� ���� ��ȸ");
		
		MPcategoryLb.setBounds(230, 30, 700, 100);
		MPcategoryLb.setFont(new Font("���", Font.PLAIN, 25));
		this.add(MPcategoryLb);
		
		
		MPhomeBtn.setBounds(10, 10, 50, 50);
		MPhomeBtn.setBorderPainted(false);
		

		/* �ڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡ����� �� �� ��!�ڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡ�
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

		
		//������ҹ�ư �׼� 
		MPcontents.MPreservation.MPreservation_2.MPreservationcancleBtn.addActionListener(new MPreservationCancleBtnEvent(this));
		
		
		//Ż���ϱ� �� ��ư �׼�  
		MPcontents.MPleave.MPleaveYesBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				leaveBtnCtrl();
			}
		});
		
		
		
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
