package park;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

public class ReservationInfo { // �ν��Ͻ� ���� Ŭ����

	static private String userId;
	static private Integer busId;
	
	static private ArrayList<Integer> reservationId = new ArrayList<>();; // �¼��� ���Ź�ȣ 1���� �����¼��� �� �����Ƿ� �迭�� ����
	static private String depart;
	static private String arrive;
	static private String price;
	static private String date;
	static private String time;
//	static private HashMap<Integer, Double> dcBySeat = new HashMap<>(); // �¼��� ���η� ���� Ű���� �¼� id //����� �Ѱ��ֽô°�
//	static private HashMap<Integer, String> ageBySeat = new HashMap<>(); // �¼��� ����
	static private HashMap<Integer, Double> dcBySeat = new HashMap<>(); // �¼��� ���η� ���� Ű���� �¼� id //����� �Ѱ��ֽô°�
	static private HashMap<Integer, String> ageBySeat = new HashMap<>(); // �¼��� ����
	static private HashMap<String, Integer> seatNameBySeatId = new HashMap<>();// �¼��̸��� �ش��ϴ� �¼� id
	static private ArrayList<Integer> seatId = new ArrayList<>(); // �¼� id��
	static private ArrayList<String> seatNames = new ArrayList<>(); // �¼��̸� ����Ʈ // ����� �Ѱ��ֽô°�
	static private String payWay; // �̰� �ѹ� �����Ҷ� ���� �������� �ϴϱ� �迭 x
	//static private String[] age; // �¼� �� �����̹Ƿ� �̰͵� �迭
	static private double totalCharge=0; // ������ ���� �� �Ҽ��� ���ϱ� ������ double��

	public ReservationInfo() {
		dcBySeat.put(1, null);
		dcBySeat.put(2, null);
		seatNameBySeatId.put("a-21",1);
		seatNameBySeatId.put("a-04",2 );

		depart = "������";
		arrive = "�λ�";
		price = "20000";
		date = "2022/06/20";
		time = "17:50";
		userId = "1";
		payWay = "���þ���";
		busId = 1000;
		
	}
	
//	public static void setSeatNamesBySeatId() { // �¼� id�� �̾Ƽ� �װ� Ű ������ �ϰ� �¼��̸��� ����Ʈ���� �ҷ��ͼ� ����� �ִ´�
//		Set<Integer> keys = dcBySeat.keySet();
//		int i=0;
//		for(Integer key : keys) {
//			seatNameBySeatId.put(key, seatNames.get(i++));
//		}
//		for(int j=0;j<seatNameBySeatId.size();j++)
//			System.out.println(seatNameBySeatId.get(j));
//	}
	
	
	public static void setSeatNames() { 		// 
		Set<String> keys = seatNameBySeatId.keySet();
		for(String key : keys) {
			seatNames.add(key);
		}
			for(int i=0;i<seatNames.size();i++)
				System.out.println(i+"��° �¼�ID "+seatNames.get(i)+"����");
		
	}
	public static HashMap<String, Integer> getSeatNameBySeatId() {
		return seatNameBySeatId;
	}
	
	public static ArrayList<String> getSeatNames(){
		return seatNames;
	}
	public static void setSeatId() { 
		Set<Integer> keys = dcBySeat.keySet();
		for(Integer key : keys) {
			seatId.add(key);
		}
		for(int i=0;i<seatId.size();i++)
			System.out.println("�¼�Id "+seatId.get(i)+"�߰�");
	}

	public static ArrayList<Integer> getSeatId() {
		return seatId;
	}
	public static int getSeatSize() {
		return dcBySeat.size();
	}
	
	
	public static void setAgeBySeat(Integer seat, String age) {
		ageBySeat.put(seat, age);
	}
	public static HashMap<Integer, String> getAgeBySeat() {
		return ageBySeat;
	}
	
	public static HashMap<Integer, Double> getDcBySeat() {
		return dcBySeat;
	}
	
	
	
	//---------------------------------------------
	public static double getTotalCharge() { // price * dcBySeat.get(key) + price * dcBySeat.get(key)
		Set<Integer> keys = dcBySeat.keySet();
		for(Integer key : keys) { // Ű �ƴϰ� ��� �����ߵ�
			//totalCharge += Integer.parseInt(price)*(Double.parseDouble(dcBySeat.get(key))); // ����(����ȭ) * Ű �� �Ѱ��� �̾Ƽ� �� Ű�� ���(�Ǽ�ȭ)
			totalCharge += Integer.parseInt(price)*dcBySeat.get(key);
		}
		return totalCharge;
	}
	
	public static void setTotalCharge() {
		totalCharge = 0;
	}
	
	
	
	
	public static void setReservationId(int rvid) {
		reservationId.add(rvid);
	}

	public static String getUserId() {
		return userId;
	}

	public static void setUserId(String userId) {
		ReservationInfo.userId = userId;
	}

	public static Integer getBusId() {
		return busId;
	}

	public static void setBusId(Integer busId) {
		ReservationInfo.busId = busId;
	}

	public static String getDepart() {
		return depart;
	}

	public static void setDepart(String depart) {
		ReservationInfo.depart = depart;
	}

	public static String getArrive() {
		return arrive;
	}

	public static void setArrive(String arrive) {
		ReservationInfo.arrive = arrive;
	}

	public static String getPrice() {
		return price;
	}

	public static void setPrice(String price) {
		ReservationInfo.price = price;
	}

	public static String getDate() {
		return date;
	}

	public static void setDate(String date) {
		ReservationInfo.date = date;
	}

	public static String getTime() {
		return time;
	}

	public static void setTime(String time) {
		ReservationInfo.time = time;
	}

	public static HashMap<Integer, Double> getdcBySeat() {
		return dcBySeat;
	}

	public static void setdcBySeat(LinkedHashMap<Integer, Double> dcBySeat) {
		ReservationInfo.dcBySeat = dcBySeat;
	}

	public static String getPayWay() {
		return payWay;
	}

	public static void setPayWay(String payWay) {
		ReservationInfo.payWay = payWay;
	}



	public static void setTotalCharge(double totalCharge) {
		ReservationInfo.totalCharge = totalCharge;
	}
	
	
	
	private static void main(String[] args) {
		//new ReservationInfo().setseatNames();
	}
}
