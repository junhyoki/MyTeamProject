package park.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import an.OjdbcConnection;
import hong.SaveInfo;

public class SaveDB {

	public SaveDB(SaveInfo user) { // �������� , ����, �������̵�, ���� ���̵�, �¼�id
		String sql = "insert into bus_reservation values (br_id_sq.nextval, ?, ?, ?,?,?)"; // ���� 1 ���� 1000 �¼� 1

		String sql2 = "update bus_seat set bs_is_reserved = '1' where bs_id = ?";

		try(Connection conn = OjdbcConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			PreparedStatement pstmt2 = conn.prepareStatement(sql2);
			){		// execute() ������Ʈ�� executeUpdate() int������ ��ȯ, executeQuery() resultset�� ���� �� �ִ�
			System.out.println("db ���� ����");
			for(int i=0;i<user.getSeatSize();i++) {
				System.out.println("���� ����");
				pstmt.setString(1, user.getPayWay()); // �������
				System.out.println(user.getPayWay());
				pstmt.setString(2, user.getAgeBySeat().get(user.getSeatId().get(i))); // �ش� �¼��� ���� ����
				System.out.println(user.getAgeBySeat().get(user.getSeatId().get(i)));
				pstmt.setString(3, user.getUserId()); // ����id
				System.out.println(user.getUserId());
				pstmt.setInt(4, user.getBusId()); // ���� id
				System.out.println(user.getBusId());
				pstmt.setInt(5, user.getSeatId().get(i)); // 0��° ���� ����ִ� �¼��� ��ȣ
				System.out.println(user.getSeatId().get(i));
				pstmt.executeUpdate();
				// -------------------------
				pstmt2.setInt(1, user.getSeatId().get(i));
				pstmt2.execute();
			}
			
			System.out.println("DB���� ����");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DB���� ����");
		}
	}
}

//String sql3 = "select br_id from bus_reservation inner join user_info using(user_id) "
//+ "inner join bus_info using(bi_id) "
//+ "inner join bus_seat using(bs_id) "
//+ "where user_id = ? and bi_id = ? and bs_id ?";