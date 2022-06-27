package an.sign_up;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import an.OjdbcConnection;
import an.sign_up.action.Sign_ButtonAction;
import an.sign_up.action.Sign_IdButtonAction;
import lee.mpcomponents.MPincorrectphonenumSF;


public class Sign_Panel extends JPanel{
	JButton button;
	JButton button2;
	String id = "", pass = "", passRe = "", name = "", phone = "", check ="";
	
	JTextField idtext = new Sign_TextFeild(10);
	JPanel idPanel = new Id_Panel(idtext);
	
	JTextField passtext= new Sign_TextFeild(10);
	JPanel passPanel = new Password_Panel(passtext);
	
	JTextField nametext = new Sign_TextFeild(10);
	JPanel namePanel = new Name_panel(nametext);
	
	JTextField pntext = new Sign_TextFeild(10);
	JPanel pnPanel = new Pn_Panel(pntext);
	
	JComboBox<String> combo = new Combo();
	
	
	//JRadioButton client = new RadioButton("�մ�");
	//JRadioButton manager = new RadioButton("������");
	//ButtonGroup bg = new ButtonGroup();
	//JPanel radioPanel = new Radio_Panel(client,manager,bg);
	
	public Sign_Panel(JButton button,JButton button2) {
		setLayout(new GridLayout(5, 1));
		
		
		this.button = button ;
		
		add(idPanel);
		add(passPanel);
		add(namePanel);
		add(pnPanel);
		add(combo);
		
		Sign_ButtonAction btevent = new Sign_ButtonAction(this);
		Sign_IdButtonAction idevent = new Sign_IdButtonAction(this);
		
		button.addActionListener(btevent);
		button2.addActionListener(idevent);
		
		
	}
	
	//ȸ������ �̺�Ʈ
	public void signupAction() {
		id = idtext.getText();
		pass = new String(passtext.getText());
		name = nametext.getText();
		phone = pntext.getText();
		check = combo.getSelectedItem().toString();

		String sql = "INSERT into user_info(user_id,user_passenger_manager,user_name,user_password,user_phonenum)"
				+ " values (?,?,?,?,?)"; 

		Pattern passPattern1 = Pattern.compile("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*\\W).{8,20}$"); //8�� ����+Ư��+����
		Matcher passMatcher = passPattern1.matcher(pass);
		
		
		boolean result = Pattern.matches("\\d{3}-\\d{4}-\\d{4}", phone);
		
		if (!passMatcher.find()) {
			JOptionPane.showMessageDialog(null, "��й�ȣ�� ����+Ư������+���� 8�ڷ� �����Ǿ�� �մϴ�", "��й�ȣ ����", 1);
		} if(!result) {
			JOptionPane.showMessageDialog(null, "xxx-xxxx-xxxx�� �Է��� �ּ���", "��ȣ ����", 1);
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
				if (e1.getMessage().contains("PRIMARY")) {
					JOptionPane.showMessageDialog(null, "���̵� �ߺ�!", "���̵� �ߺ� ����", 1);
				} else
					JOptionPane.showMessageDialog(null, "������ ����� �Է����ּ���!", "����", 1);
			} 
		}
	}
	
	//���̵� �ߺ� üũ
	public void checkid() {
		id = idtext.getText();
		
		
		String sql1 = String.format("SELECT user_id from user_info where user_id = '%s'",id);
		
		boolean result = Pattern.matches("^[a-zA-Z]{1}[a-zA-Z0-9_]{4,11}$", id);
		
		
		
		try(Connection conn = OjdbcConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql1);
		) {
			ResultSet rset = pstmt.executeQuery();
			if(!result) {
				JOptionPane.showMessageDialog(null, "���̵�� �������ڷ��̷���� 5~12���ڷ� ���� ���ּ���", "��ȣ ����", 1);
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
}
