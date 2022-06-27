package an.sign_up;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import an.OjdbcConnection;
import an.sign_up.action.Sign_ButtonAction;
import an.sign_up.action.Sign_IdButtonAction;
import an.sign_up.action.Sign_PassButtonAction;


public class Sign_Panel extends JPanel{
	JButton button;
	JButton button2;
	JButton button3;
	String id = "", pass = "", passRe = "", name = "", phone = "", check ="" ,passck ="";
	
	JTextField idtext = new Sign_TextFeild(12);
	JButton checkid = new Action_button("���̵� �ߺ�Ȯ��");
	JPanel idPanel = new Id_Panel(idtext,checkid);
	
	JLabel idcheckLabel = new ErrorLabel("���̵�� ����+���� �ּ� 5�ڿ��� �ִ� 11�ڷ� ����");
	
	JTextField passtext= new Sign_TextFeild(12);
	JButton checkpass = new Action_button("��й�ȣ Ȯ��");
	JPanel passPanel = new Password_Panel(passtext,checkpass);
	JLabel passLabel = new ErrorLabel("��й�ȣ�� ����+Ư������+���� �ּ� 8�ڿ��� �ִ�20�ڷ� ����");
	
	JTextField passCktext= new Sign_TextFeild(12);
	JPanel passCkPanel = new Pass_CheckPanel(passCktext);
	JLabel passcheckLabel = new ErrorLabel("��й�ȣ�� �����ϰ� �Է����ּ���");
	
	
	JTextField nametext = new Sign_TextFeild(12);
	JPanel namePanel = new Name_panel(nametext);
	
	JTextField pntext = new Sign_TextFeild(3);
	JTextField pntext2 = new Sign_TextFeild(3);
	JTextField pntext3 = new Sign_TextFeild(3);
	JPanel pnPanel = new Pn_Panel(pntext,pntext2,pntext3);
	
	JComboBox<String> combo = new Combo();
	JPanel comboPanel = new Combo_Panel(combo);
	
	
	//JRadioButton client = new RadioButton("�մ�");
	//JRadioButton manager = new RadioButton("������");
	//ButtonGroup bg = new ButtonGroup();
	//JPanel radioPanel = new Radio_Panel(client,manager,bg);
	
	public Sign_Panel(JButton button) {
		setLayout(new GridLayout(9, 0,0,0));
		
		
		this.button = button ;
		//this.button2= button2;
		//this.button3 = button3;
		
		add(idPanel);
		add(idcheckLabel);
		add(passPanel);
		add(passLabel);
		add(passCkPanel);
		add(passcheckLabel);
		add(namePanel);
		add(pnPanel);
		add(comboPanel);
		
		
		//////////////////////////////////////////////////////////////
		Sign_ButtonAction btevent = new Sign_ButtonAction(this);
		Sign_IdButtonAction idevent = new Sign_IdButtonAction(this);
		Sign_PassButtonAction passevent = new Sign_PassButtonAction(this);
		checkid.addActionListener(idevent);
		checkpass.addActionListener(passevent);
		button.addActionListener(btevent);
		//button3.addActionListener(passevent);
		
		
		///////////////////////////////////////////////////////////
		
		//���̵� ��� ��
		idtext.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				id = idtext.getText();
				if (id.length() < 5) {
					idcheckLabel.setForeground(Color.red);
					idcheckLabel.setText("���̵�� 5���� �̻��̿��� �մϴ�");
				} else if (Pattern.matches("^[a-zA-Z]{1}[a-zA-Z0-9_]{4,11}$", id)) {
					idcheckLabel.setForeground(Color.BLUE);
					idcheckLabel.setText("��밡���� ���̵��Դϴ�. ���̵� �ߺ��� �����ּ���");
				}else if(id.length()>=12) {
					idcheckLabel.setForeground(Color.red);
					idcheckLabel.setText("���̵�� 11���� �����̿��� �մϴ�");
				}else {
					idcheckLabel.setForeground(Color.red);
					idcheckLabel.setText("�ǹٸ� ���̵� �Է��ϼ���");
				}
			}
		});
		
		//��й�ȣ ��� ��
		passtext.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				pass = new String(passtext.getText());
				if (pass.length() <= 8) {
					passLabel.setForeground(Color.red);
					passLabel.setText("8���̻����� �Է��ϼ���");
				}
				else if(Pattern.matches("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*\\W).{8,20}$",pass)) {
					 passLabel.setForeground(Color.BLUE);
					 passLabel.setText("��밡���� ��й�ȣ �Դϴ�. ��й�ȣ Ȯ���� �����ּ���");
				}
				else if(pass.length() >=21){
					passLabel.setForeground(Color.red);
					passLabel.setText("��й�ȣ�� 20�� ���Ͽ��� �˴ϴ�.");
				}else {
					passLabel.setForeground(Color.red);
					passLabel.setText("��й�ȣ�� ����+Ư������+���� �ּ� 8�ڿ��� �ִ�20�ڷ� ����");
				}
			}
		});
		
		//�ߺ���й�ȣ Ȯ��
		passCktext.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				pass = new String(passtext.getText());
				passck =new String(passCktext.getText());
				if (!passck.equals(pass)) {
					passcheckLabel.setForeground(Color.red);
					passcheckLabel.setText("��й�ȣ�� ��ġ ���� �ʽ��ϴ�.");
				} else if(passck.equals(pass)) {
					passcheckLabel.setForeground(Color.BLUE);
					passcheckLabel.setText("��й�ȣ�� ��ġ �մϴ�.");
				}else {
					passcheckLabel.setText("��й�ȣ �Է��ϼ���");
				}
			}	
		});
	}
	//////////////////////////////////////////////////�޼���///////////////////////////////////////////////
	
	//ȸ������ �޼���
	public void signupAction() {
		id = idtext.getText();
		pass = new String(passtext.getText());
		passck = new String(passCktext.getText());
		name = nametext.getText();
		phone = (pntext.getText()+"-"+pntext2.getText() +"-"+pntext3.getText());
		check = combo.getSelectedItem().toString();

		String sql = "INSERT into user_info(user_id,user_passenger_manager,user_name,user_password,user_phonenum)"
				+ " values (?,?,?,?,?)"; 

		Pattern passPattern1 = Pattern.compile("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*\\W).{8,20}$"); //8�� ����+Ư��+����
		
		Matcher passMatcher = passPattern1.matcher(pass);
		
		
		boolean idchek = Pattern.matches("^[a-zA-Z]{1}[a-zA-Z0-9_]{4,11}$", id);
		
		boolean phcheck = Pattern.matches("\\d{3}-\\d{4}-\\d{4}", phone);
		if(!passck.equals(pass)) {
			JOptionPane.showMessageDialog(null, "��й�ȣ�� ��й�ȣ Ȯ���� �ٸ��ϴ�.", "��й�ȣ ����", 1);	
			return;
		}	
		if (!passMatcher.find()) {
			JOptionPane.showMessageDialog(null, "��й�ȣ�� ����+Ư������+���� �ּ� 8�ڿ��� �ִ�20�ڷ� �����Ǿ�� �մϴ�", "��й�ȣ ����", 1);
			return;
		} if(!phcheck) {
			JOptionPane.showMessageDialog(null, "xxx-xxxx-xxxx�� �Է��� �ּ���", "��ȣ ����", 1);
			return;
		}if(!idchek) {
			JOptionPane.showMessageDialog(null, "���̵�� �������ڷ��̷���� 5~12���ڷ� ���� ���ּ���", "���̵� ����", 1);
			return;
		}
		
		else {
			try(Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
					
					) {
				
				pstmt.setString(1, id);
				pstmt.setString(2, check);
				pstmt.setString(3, name);
				pstmt.setString(4, pass);
				pstmt.setString(5, pntext.getText());
				pstmt.executeUpdate();
				JOptionPane.showMessageDialog(null, "ȸ�� ���� �Ϸ�!", "ȸ������", 1);
				
				
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, "������ ����� �Է����ּ���!", "����", 1);
			} 
		}
	}
	
	//���̵� �ߺ� üũ �޼���
	public void checkid() {
		id = idtext.getText();
		
		
		String sql1 = String.format("SELECT user_id from user_info where user_id = '%s'",id);
		
		boolean result = Pattern.matches("^[a-zA-Z]{1}[a-zA-Z0-9_]{4,11}$", id);
		
		try(Connection conn = OjdbcConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql1);
		) {
			ResultSet rset = pstmt.executeQuery();
			if(!result) {
				JOptionPane.showMessageDialog(null, "���̵�� �������ڷ��̷���� 5~12���ڷ� ���� ���ּ���", "���̵� ����", 1);
			}else {
			
				if(!rset.next()) {
					JOptionPane.showMessageDialog(null, "��밡���� ���̵� �Դϴ�.", "���̵� �ߺ� üũ", 1);
				}
				else {
					JOptionPane.showMessageDialog(null, "�ߺ��� ���̵� �Դϴ�.", "�ߺ� üũ", 1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	//��й�ȣ üũ �޼���
	public void checkpass() {
		pass = passtext.getText();
		String sql1 = String.format("SELECT user_password from user_info where user_password = '%s'",pass);
		
		Pattern passPattern1 = Pattern.compile("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*\\W).{8,20}$"); //8�� ����+Ư��+����
		
		Matcher passMatcher = passPattern1.matcher(pass);
		
		if(!passMatcher.find()) {
			JOptionPane.showMessageDialog(null, "��й�ȣ�� ����+Ư������+���� �ּ� 8�ڿ��� �ִ�20�ڷ� �����Ǿ�� �մϴ�", "��й�ȣ ����", 1);
		}else {
			try(
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql1);	
			) {
				ResultSet rset = pstmt.executeQuery();
					if(rset.next()) {
						JOptionPane.showMessageDialog(null, "��밡���� ��й�ȣ �Դϴ�.", "��й�ȣ üũ", 1);
					}else {
						JOptionPane.showMessageDialog(null, "��й�ȣ�� ����+Ư������+���� �ּ� 8�ڿ��� �ִ�20�ڷ� �����Ǿ�� �մϴ�.", "��й�ȣ üũ", 1);
					}
				}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
