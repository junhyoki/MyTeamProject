package lee.mpmodel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;


public class MPreservationlistModel {
	
	// ���Ź�ȣ
	Integer br_id;
	//��¥, �ð�
	String bi_day;
	String bi_time;
	//�����, ������
	String rt_depart_from;
	String rt_arrive_at;
	//�¼���ȣ
	String bs_name;
	//���� ��� ���ϱ� ���ؼ� ���ɱ���, ���
	String br_age_group;
	Integer  rt_charge;
//-------------------------------------
	Integer bs_id; //�¼� id
	
	
	
	public double totalCharge() {
		if(br_age_group.equals("����")) {
			return rt_charge * 1;
		} else if(br_age_group.equals("û�ҳ�")) {
			return rt_charge * 0.85;
		} else if(br_age_group.equals("�Ƶ�")) {
			return rt_charge * 0.7;
		}
		return 0; 
	}
	
	
	
	
	public Integer getBr_id() {
		return br_id;
	}
	
	
	
	public static void delete_user_id_row(Connection conn, String user_id) {
		String sql = "DELETE FROM bus_reservation WHERE user_id = ?";
		try(PreparedStatement pstmt = conn.prepareStatement(sql); ) {
			pstmt.setString(1, user_id);
			System.out.println("user_id�� �� ���� ����? : " + pstmt.executeUpdate());
		} catch (SQLException e) {
			System.out.println("�� ���� �� ��");
		}
	}
	

	
	public static void delete_bs_id_row(Connection conn, int bs_id) {
		String sql = "DELETE FROM bus_seat WHERE bs_id = ?";
		try(PreparedStatement pstmt = conn.prepareStatement(sql); ) {	
			pstmt.setInt(1, bs_id);
			System.out.println("bs_id�� �� ���� ����? : " + pstmt.executeUpdate());	
		} catch (SQLException e) {
			System.out.println("���� �� ��");
		}
	}
	
	public static void delete_br_id_row(Connection conn, int br_id) {
		String sql = "DELETE FROM bus_reservation WHERE br_id = ?";
		try(PreparedStatement pstmt = conn.prepareStatement(sql); ) {
			pstmt.setInt(1, br_id);
			System.out.println("br_id�� �� ���� ����? : " + pstmt.executeUpdate());	
		} catch (SQLException e) {
			System.out.println("");
		}
	}
	
	
	
	
	
	//Bus_Seat + Bus_Reservation �̳����� �ؼ� ���Ź�ȣ�� �Ű������� �����ϸ� bs_id(�¼�id)�� �����ϴ� �޼���
	public static int get_bs_id(Connection conn, int br_id) {
		
		String sql = "SELECT bs_id, br_id FROM bus_seat INNER JOIN bus_Reservation USING(bs_id) WHERE br_id = ?";
				
		int bs_id = 0;
		try(PreparedStatement pstmt = conn.prepareStatement(sql); ) {
			
			pstmt.setInt(1, br_id);
			
			try(ResultSet rs = pstmt.executeQuery();) {
				while(rs.next() ) {
					bs_id = rs.getInt("bs_id");
				}
			}
						
		} catch (SQLException e) {
			System.out.println("");
		}
		return bs_id;
	}
	
	
	
	
	
	
	
	//Ư�� ���Ź�ȣ�� �Է��ϸ� �ش� ���Ź�ȣ�� ���� ��ȯ�ϴ� �޼���
	public static MPreservationlistModel get(Connection conn, int br_id) {
	
		String sql = 
				"SELECT br_id, bi_day, bi_time, rt_depart_from, rt_arrive_at, bs_name, br_age_group, rt_charge"
				+ " FROM user_info"
				+ " INNER JOIN bus_reservation USING(user_id)"
				+ " INNER JOIN bus_info USING (bi_id)"
				+ " INNER JOIN bus_route USING (rt_id)"
				+ " INNER JOIN bus_seat USING (bs_id)"
				+ " WHERE br_id = ?";
		
		MPreservationlistModel result = null;
		try(
				PreparedStatement pstmt = conn.prepareStatement(sql); 
						
		) {
			pstmt.setInt(1, br_id);
			
			try(ResultSet rs = pstmt.executeQuery();) {
				while(rs.next() ) {
					result = new MPreservationlistModel(rs);
				}
			}
						
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	//ȸ�����̵� �Է��ϸ� ���� ��¥ ������ ���� ������ ���� ������(��)�� ��ȯ�ϴ� �޼���
	public static ArrayList<MPreservationlistModel> get(Connection conn, String user_id) {
		ArrayList<MPreservationlistModel> list = new ArrayList<>();
		
		String[] split = LocalDate.now().toString().split("-");
		String join = String.join("/", split);
		String date = join.substring(2);
		
		
		String sql = 
				"SELECT br_id, bi_day, bi_time, rt_depart_from, rt_arrive_at, bs_name, br_age_group, rt_charge"
				+ " FROM user_info"
				+ " INNER JOIN bus_reservation USING(user_id)"
				+ " INNER JOIN bus_info USING (bi_id)"
				+ " INNER JOIN bus_route USING (rt_id)"
				+ " INNER JOIN bus_seat USING (bs_id)"
				+ " WHERE user_id = ?"
				+ " AND bus_info.bi_day >= ?";
		try(
				PreparedStatement pstmt = conn.prepareStatement(sql); 
						
		) {
			
			pstmt.setString(1, user_id);
			pstmt.setString(2, date);
			
			try(ResultSet rs = pstmt.executeQuery();) {
				while(rs.next() ) {
					list.add(new MPreservationlistModel(rs));
				}
			}
					
		} catch (SQLException e) {
			System.out.println("���ų��� ����");
		}
		return list;
	}
	
	
	
	public static ArrayList<MPreservationlistModel> getAll(Connection conn) {
		ArrayList<MPreservationlistModel> list = new ArrayList<>();
		
		String sql = 
				"SELECT br_id, bi_day, bi_time, rt_depart_from, rt_arrive_at, bs_name, br_age_group, rt_charge"
				+ " FROM user_info"
				+ " INNER JOIN bus_reservation USING(user_id)"
				+ " INNER JOIN bus_info USING (bi_id)"
				+ " INNER JOIN bus_route USING (rt_id)"
				+ " INNER JOIN bus_seat USING (bs_id)"
				+ " WHERE user_id = 'abc123'"
				+ " AND bus_info.bi_day >= '22/06/20'";
		try(
				PreparedStatement pstmt = conn.prepareStatement(sql); 
				ResultSet rs = pstmt.executeQuery();		
		) {
			while(rs.next() ) {
				list.add(new MPreservationlistModel(rs));
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public MPreservationlistModel(ResultSet rs) throws SQLException {
		br_id = rs.getInt("br_id");
		bi_day = rs.getString("bi_day");
		bi_time = rs.getString("bi_time");
		rt_depart_from = rs.getString("rt_depart_from");
		rt_arrive_at = rs.getString("rt_arrive_at");
		bs_name = rs.getString("bs_name");
		br_age_group = rs.getString("br_age_group");
		rt_charge = rs.getInt("rt_charge");
	}
	
	
	@Override 
	public String toString() {	
		return String.format("<html><pre style=\"font-family:����;\">���Ź�ȣ : %s<br>"
			+ "%s  %s<br>"
			+ "%s - %s<br>"
			+ "�¼� : %s<br>"
			+ "���ɱ��� : %s<br>"
			+ "��� : %d</pre></html>",
			br_id, bi_day, bi_time, rt_depart_from, rt_arrive_at, bs_name, br_age_group, Math.round(totalCharge()));
	}

	

	
	
} 