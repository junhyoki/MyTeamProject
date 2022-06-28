package lee.mpcomponents;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import an.OjdbcConnection;
import an.login.Login_Mainframe;
import an.userinfo.Info_MainFrame;
import hong.SaveInfo;
import lee.mpevents.MPBackBtnEvent;
import lee.mpevents.MPcompleteBtnEvent;
import lee.mpevents.MPeditBtnEvent;
import lee.mpevents.MPnavBtnsEvent;
import lee.mpevents.MPreservationCancleBtnEvent;
import lee.mpmodel.MPprofileModel;
import lee.mpmodel.MPreservationlistModel;

//�����ߴµ� �ǵ��� �� ���� Ŀ���� �� �� ���常 ��
public class MPmainFrame extends JFrame {

	String user_id;
	SaveInfo saveInfo;
	
	JButton MPhomeBtn = new JButton();
	JLabel MPcategoryLb = new JLabel("ī�װ���");
	
	MPnavPanel MPnav = new MPnavPanel();
	MPcontentsPanel MPcontents;
	
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
			
			//���ų����� ��� üũ�ڽ� ���� ����
			for(JCheckBox cb : MPcontents.MPreservation.MPreservation_2.cbArr) {
				cb.setSelected(false);
			}
			
		} else if(btn.getText().equals("���� Ȯ��")) {
			setCategoryLabelText(btn.getText());
			MPcontents.MPcontentsCard.show(MPcontents, "���ų���");
			
			//���ų����� ������ ���ų��� ���� �г��� �ߵ���
			try(Connection conn = OjdbcConnection.getConnection();) {
				if(MPreservationlistModel.get(conn, user_id).size() > 0) {
					//System.out.println("���ų��� ����...");
					MPcontents.MPreservation.MPreservationCard.show(MPcontents.MPreservation, "���ų��� ����");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		} else if(btn.getText().equals("���� Ż��")) {
			setCategoryLabelText(btn.getText());
			MPcontents.MPcontentsCard.show(MPcontents, "����Ż��");
			
			//���ų����� ��� üũ�ڽ� ���� ����
			for(JCheckBox cb : MPcontents.MPreservation.MPreservation_2.cbArr) {
				cb.setSelected(false);
			}
		}
	}	
	
	
	//�����ʼ����ϱ� ��ư ������ ��
	public void editBtnCtrl () {		
		
	 	MPinputpwSF inputpwSF = new MPinputpwSF();
		
		
		inputpwSF.completeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try (Connection conn = OjdbcConnection.getConnection();){
					
					String str = inputpwSF.MPgetPwd(inputpwSF.inputpwPf);
					
					if(str.equals(MPprofileModel.MPgetUserPw(conn, user_id))) {
						inputpwSF.dispose();
						dispose();
						MPmainFrame MPnewmainF = new MPmainFrame(saveInfo);
						MPnewmainF.MPcontents.MPprofile.showMPprofile_2(); 		
						MPnewmainF.setCategoryLabelText("�� ���� ����");
					} else {
						new MPincorrectpwSF();
					}
				
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
	}

	//�����ʼ����ϱ� ȭ�鿡�� �ڷΰ��� ��ư ������ �� (������ �����ϸ� �� �ǵ���)
	public void backBtnCtrl () {
		setCategoryLabelText("�� ���� ��ȸ");
		MPcontents.MPprofile.showMPprofile_1();
	}
	
	
	//�����ʼ����ϱ� ȭ�鿡�� ���� �Ϸ� ��ư ������ �� (������ ����ǰ�) 
	public void completeBtnCtrl() {
		if(MPcontents.MPprofile.MPprofile_2.MPnameTf.getText().equals("") 
			|| MPcontents.MPprofile.MPprofile_2.MPphoneTf_1.getText().equals("")
			|| MPcontents.MPprofile.MPprofile_2.MPphoneTf_2.getText().equals("")
			|| MPcontents.MPprofile.MPprofile_2.MPphoneTf_3.getText().equals("")
			|| MPcontents.MPprofile.MPprofile_2.MPgetPwd(MPcontents.MPprofile.MPprofile_2.MPnewpwTf).equals("")) {
			
			//new MPpreventnulltfSF();
			JOptionPane.showMessageDialog(null, "�� ĭ�� ��� �Է����ּ���", "�Է� ����", 1);			
			return;
		}
		
			
		//�̸� ���ڼ� ���� 
		if(MPcontents.MPprofile.MPprofile_2.MPnameTf.getText().length() > 10) {		
			//new MPnamelengthrestrictSF();
			JOptionPane.showMessageDialog(null, "�̸��� 10���ڱ��� �Է� �����մϴ�.", "�Է� ����", 1);
			return;
		}
		

		Pattern passPattern1 = Pattern.compile("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*\\W).{8,20}$"); //8�� ����+Ư��+����
		Matcher passMatcher = passPattern1.matcher(MPcontents.MPprofile.MPprofile_2.MPgetPwd(MPcontents.MPprofile.MPprofile_2.MPnewpwTf));
		if (!passMatcher.find()) {
			JOptionPane.showMessageDialog(null, "��й�ȣ�� ����+Ư������+���� 8�ڷ� �����Ǿ�� �մϴ�", "�Է� ����", 1);
			return;
		}
		
		
		if(!MPcontents.MPprofile.MPprofile_2.MPgetPwd(MPcontents.MPprofile.MPprofile_2.MPchknewpwTf).equals(MPcontents.MPprofile.MPprofile_2.MPgetPwd(MPcontents.MPprofile.MPprofile_2.MPnewpwTf))) {
			JOptionPane.showMessageDialog(null, "<html>��й�ȣ�� ��ġ���� �ʽ��ϴ�.</html>", "�Է� ����", 1);
			return;
		}
		
		
		
		
		setCategoryLabelText("�� ���� ��ȸ");	

		//������ ���� DB�� ������Ʈ
		try(Connection conn = OjdbcConnection.getConnection()
		) {
			conn.setAutoCommit(false);
			
			//�� �̸�, �� ��й�ȣ ������Ʈ
			MPprofileModel.MPupdateUserName(conn, user_id, MPcontents.MPprofile.MPprofile_2.MPnameTf.getText());
			MPprofileModel.MPupdateUserPw(conn, user_id, MPcontents.MPprofile.MPprofile_2.MPgetPwd(MPcontents.MPprofile.MPprofile_2.MPnewpwTf));
		
			//�ڵ�����ȣ�� 01012341234 �� �Է¹޾Ƽ� 010-1234-1234�� ����	
			String str = MPcontents.MPprofile.MPprofile_2.MPgetPhoneNum();
			ArrayList<String> arr = new ArrayList<>();
			arr.add(str.substring(0, 3));
			arr.add(str.substring(3, 7));
			arr.add(str.substring(7, 11));
			MPprofileModel.MPupdateUserPhoneNum(conn, user_id, String.join("-", arr));

			conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//���ΰ�ħ
		dispose();
		MPmainFrame MPnewmainF = new MPmainFrame(saveInfo);
		MPcontents.MPprofile.showMPprofile_1();		
	}  

	
	//������� ��ư ������ ��
	public void reservationcancleBtnCtrl() {
		
		//üũ�� üũ�ڽ� ���� ����
		int checkNum = 0;
		for(JCheckBox cb : MPcontents.MPreservation.MPreservation_2.cbArr) {
			if(cb.isSelected()) {
				br_id_list.add(Integer.parseInt(cb.getText()));
				checkNum++;
			} 
		}
		
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
										
							//���Ź�ȣ�� �ش��ϴ� �� bus_reservation ���̺��� ����� 
							MPreservationlistModel.delete_br_id_row(conn, br_id);
							//�¼���ȣ�� �ش��ϴ� bs_is_reserved �� 0���� �ٲٱ� (bus_seat���̺�) 
							MPreservationlistModel.update_bs_is_reserved(conn, bs_id);							
						}
						
						conn.commit(); //Ŀ�� ����Ŭ ���� �� �ص� �ǰ� ���⼭ �ٷ� ��
						sf.dispose(); //�� ������ ���� â �ݱ�
					
						//_______________________________���ų��� ���ΰ�ħ �κ�______________________________________________________________
						
						br_id_list = new ArrayList<>(); //üũ�ڽ� ���õ� ���Ź�ȣ(br_id) ��� ��� ����ְ� 
						
						//���ų��� �г� ���ΰ�ħ
						dispose();
						MPmainFrame MPnewmainF = new MPmainFrame(saveInfo);
						MPnewmainF.setCategoryLabelText("����Ȯ��");
						
						// ���������� ���� Ų �Ŀ� ���ų��� �г��� �ߵ��� �ϴ� �ڵ��
						MPnewmainF.MPcontents.MPcontentsCard.show(MPnewmainF.MPcontents, "���ų���");						
						if(MPreservationlistModel.get(conn, user_id).size() > 0) {
							MPnewmainF.MPcontents.MPreservation.MPreservationCard.show(MPnewmainF.MPcontents.MPreservation, "���ų��� ����");
						}
						//______________________________________________________________________________________________________________
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			});
			
	
		}	
	}
	

	
	
	//���� Ż�� '��' ��ư
	public void leaveBtnCtrl() {
		
		
		String confirmPw = MPcontents.MPleave.MPgetPwd(MPcontents.MPleave.MPleavePf);
		String userPw = "";
		try {
			Connection conn = OjdbcConnection.getConnection();
			userPw = MPprofileModel.MPgetUserPw(conn, user_id);
		} catch (SQLException e2) {
		}
		
		//��й�ȣ ��ġ�ϸ� ���� Ż�� �Ͻðڽ��ϱ�? ���� â ����
		if(confirmPw.equals(userPw)) {
			
			//���� Ż�� �Ͻðڽ��ϱ�? ���� â 
			MPleaveRealSF sf = new MPleaveRealSF();
			//���� Ż��?â '��' ������ bus_seat���� �¼� 1>0���� �ٲٰ�, bus_reservation���� ���ű�� ������ �Ŀ� user_id����  
			sf.yesBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try(Connection conn = OjdbcConnection.getConnection();) {
						conn.setAutoCommit(false);
						
						//user_id�� �ش��ϴ� bs_id���� 1���� 0���� �ٲٱ�
						ArrayList<Integer> bs_id_list = MPreservationlistModel.get_bs_id(conn, user_id);
						for(int bs_id : bs_id_list) {
							MPreservationlistModel.update_bs_is_reserved(conn, bs_id);
						}
						//user_id�� ������ ���ų��� �����
						MPreservationlistModel.delete_user_id_row(conn, user_id);
						//user_info���̺��� user_id�� �ش��ϴ� �� �����
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
								new Login_Mainframe();
							}
						});
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			});	

		} else {
			JOptionPane.showMessageDialog(null, "��й�ȣ�� ��ġ���� �ʽ��ϴ� .", "�Է� ����", 1);
		}	
	}


	
//####################################################################################################################################	
//####################################################################################################################################

	
	
	
	//���� ������
	public MPmainFrame(SaveInfo saveInfo) {
		
		this.saveInfo = saveInfo;
		this.user_id = saveInfo.get_user_id();
		
		MPcontents = new MPcontentsPanel(saveInfo);
	
		setLayout(null);

		//�� ó�� �ε�Ǵ� ȭ���� �� ���� ��ȸ ȭ���̴ϱ� ī�װ� ���� '�� ���� ��ȸ'�� ����
		setCategoryLabelText("�� ���� ��ȸ");
		MPcategoryLb.setBounds(230, 30, 700, 100);
		MPcategoryLb.setFont(new Font("���", Font.PLAIN, 25));
		this.add(MPcategoryLb);
		
		
		MPhomeBtn.setBounds(10, 10, 50, 50);
		MPhomeBtn.setBorderPainted(false);
		
		
		//Ȩ��ư �׼� �ޱ�
		MPhomeBtn.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Info_MainFrame(saveInfo);
			}
		});
		
		
		
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

}
