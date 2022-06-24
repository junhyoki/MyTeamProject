package park.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import park.OjdbcConnection;
import park.ReservationInfo;

public class LoadRVID { // ���� �� db�� ����Ǹ� ���Ź�ȣ�� �����ǰ� �װ� �ٽ� user�� ���Ź�ȣ�� �־��ش�

	public LoadRVID(ReservationInfo user) {
		String sql = "select br_id from bus_reservation where user_id = ? and bi_id = ? and bs_id = ?";
		
		try(Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);

			){
			for(int i=0 ; i<user.getSeatSize();i++) {
				pstmt.setString(1, user.getUserId());
				pstmt.setInt(2,  user.getBusId());
				pstmt.setInt(3, user.getSeatId().get(i));

				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					user.setReservationId(rs.getInt("br_id"));
				}
				System.out.println("db�ҷ����� ����");
			}
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DB�ҷ����� ����");
		}
	}
}
