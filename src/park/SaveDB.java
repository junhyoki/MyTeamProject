package park;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SaveDB {

	public SaveDB(ReservationInfo user) { // �������� , ����, �������̵�, ���� ���̵�, �¼�id
		String sql = "insert into bus_reservation values (br_id_sq.nextval, ?, ?, ?,?,?) "; // ���� 1 ���� 1000 �¼� 1
		
		String sql2 = "update bus_seat set bu_is_reserved = '0' where bs_id = ?";

		try(Connection conn = OjdbcConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			PreparedStatement pstmt2 = conn.prepareStatement(sql2);
		){		// execute() ������Ʈ�� executeUpdate() int������ ��ȯ, executeQuery() resultset�� ���� �� �ִ�
			System.out.println("db ���� ����");
			for(int i=0;i<user.getSeatSize();i++) {
		    // 	int i=0;
				System.out.println("���� ����");
				pstmt.setString(1, user.getPayWay());
				pstmt.setString(2, user.getAgeBySeat().get(user.getSeatKeys().get(i)));
				pstmt.setString(3, user.getUserId());
				pstmt.setInt(4, user.getBusId());
				pstmt.setInt(5, user.getSeatKeys().get(i));
				System.out.println("�ͽ�ťƮ ����");
				pstmt.executeUpdate();
				System.out.println("sql1 ���� ��");
				
				pstmt2.setInt(1, user.getSeatKeys().get(i));
				pstmt2.execute();
				System.out.println("���� ��");
		
			}
			
			System.out.println("DB���� ����");
				
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DB���� ����");
		}
	}
		//String sql = "insert into bus_reservation values (br_id_sq.nextval, ?, ?, ?,?,?) ";
		//+ "\r\n";
		//String sql =  "delete from artist where artist_name = ? "; 
 //String sql = "insert into artist values(?, ?, ?, ?); ";
//
//		try(Connection conn = OjdbcConnection.getConnection();
//				PreparedStatement pstmt = conn.prepareStatement(sql);	
//				) {
//			pstmt.setString(1,  "nell");
////			pstmt.setString(2,  "��");
////			pstmt.setInt(3,  1111);
////			pstmt.setString(4,  "t");
//			//pstmt.setInt(5,  1);
//			//pstmt.setString(1, "��Ǹ�" );
//
//			int row = pstmt.executeUpdate();
//
//			System.out.println(row + " row(s) update");
//
//		}catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
	public static void main(String[] args) {
		new SaveDB(new ReservationInfo());
	}
}

//String sql3 = "select br_id from bus_reservation inner join user_info using(user_id) "
//+ "inner join bus_info using(bi_id) "
//+ "inner join bus_seat using(bs_id) "
//+ "where user_id = ? and bi_id = ? and bs_id ?";