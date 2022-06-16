package an.sign_up;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import an.OjdbcConnection;
import an.login.Mainframe;

public class Sign_Panel extends JPanel{
	JButton button;
	String id = "", pass = "", passRe = "", name = "", phone = "", check ="";
	
	JTextField idtext = new Sign_TextFeild(10);
	JPanel idPanel = new Id_Panel(idtext);
	
	JTextField passtext= new Sign_TextFeild(10);
	JPanel passPanel = new Password_Panel(passtext);
	
	JTextField nametext = new Sign_TextFeild(10);
	JPanel namePanel = new Name_panel(nametext);
	
	JTextField pntext = new Sign_TextFeild(10);
	JPanel pnPanel = new Pn_Panel(pntext);
	
	JRadioButton client = new RadioButton("�մ�");
	JRadioButton manager = new RadioButton("������");
	ButtonGroup bg = new ButtonGroup();
	JPanel radioPanel = new Radio_Panel(client,manager,bg);
	
	public Sign_Panel(JButton button) {
		setLayout(new GridLayout(5, 1));
		
		
		this.button = button ;
		
		add(idPanel);
		add(passPanel);
		add(namePanel);
		add(pnPanel);
		add(radioPanel);
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			id = idtext.getText();
			pass = new String(passtext.getText());
			name = nametext.getText();
			phone = pntext.getText();
			//check = 

			String sql = "INSERT into sign_up(user_id,su_passenger_manager,su_user_name,su_password,su_phonenum)"
					+ " values (?,1,?,?,?)"; // ���� ��ư... 

			Pattern passPattern1 = Pattern.compile("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*\\W).{8,20}$"); //8�� ����+Ư��+����
			Matcher passMatcher = passPattern1.matcher(pass);

			if (!passMatcher.find()) {
				JOptionPane.showMessageDialog(null, "��й�ȣ�� ����+Ư������+���� 8�ڷ� �����Ǿ�� �մϴ�", "��й�ȣ ����", 1);
			} 

			else {
				try(Connection conn = OjdbcConnection.getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql);
						
						) {
					pstmt.setString(1, id);
					//pstmt.setString(2, check);
					pstmt.setString(2, pass);
					pstmt.setString(3, name);
					pstmt.setString(4, pntext.getText());

					int r = pstmt.executeUpdate();
					JOptionPane.showMessageDialog(null, "ȸ�� ���� �Ϸ�!", "ȸ������", 1);
					//ȭ���̵� ���� �ʿ�(�ʿ����..?)
					
				} catch (SQLException e1) {
					if (e1.getMessage().contains("PRIMARY")) {
						//�ߺ��� �� = PRIMARY �� �Ÿ�������
						JOptionPane.showMessageDialog(null, "���̵� �ߺ�!", "���̵� �ߺ� ����", 1);
					} else
						JOptionPane.showMessageDialog(null, "������ ����� �Է����ּ���!", "����", 1);
				} 
			}
		}
	});
		
	}

}
