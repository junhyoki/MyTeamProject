package park;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Set;

public class ReservationInfo { // �ν��Ͻ� ���� Ŭ����

	static private String userId;
	static private Integer busId;
	static private Integer seatId;
//	static private Integer[] reservationId; // �¼��� ���Ź�ȣ 1���� �����¼��� �� �����Ƿ� �迭�� ����
	static private String depart;
	static private String arrive;
	static private String price;
	static private String date;
	static private String time;
	static private LinkedHashMap<Integer, Double> seatName = new LinkedHashMap<>(); // �������� ����� �޴°Ŷ�
	static private LinkedHashMap<Integer, String> ageBySeat = new LinkedHashMap<>(); 
	static private ArrayList<Integer> seatKeys = new ArrayList<>(); // �¼���ȣ�ε� �̰͵� ���� �¼��� �� �����Ƿ� �迭
	static private String payWay; // �̰� �ѹ� �����Ҷ� ���� �������� �ϴϱ� �迭 x
	//static private String[] age; // �¼� �� �����̹Ƿ� �̰͵� �迭
	static private double totalCharge=0; // ������ ���� �� �Ҽ��� ���ϱ� ������ double��

	public ReservationInfo() {
		seatName.put(1, null);
		seatName.put(2, null);
//		seatName.put(4, null);
//		seatName.put(8, null);
//		seatName.put(11, null);
//		seatName.put(3, null);
		depart = "������";
		arrive = "�λ�";
		price = "20000";
		date = "2022/06/20";
		time = "17:50";
		userId = "1";
		payWay = "�⺻��";
		busId = 1000;
		seatId = 1;
	}
	
	public static void setSeatKeys() { // Ű ���� �̾Ƽ� ��̸���Ʈ�� ����
		Set<Integer> keys = seatName.keySet();
		for(Integer key : keys) {
			seatKeys.add(key);
		}
		for(int i=0;i<seatKeys.size();i++)
			System.out.println(seatKeys.get(i));
	}
	public static ArrayList<Integer> getSeatKeys() {
		return seatKeys;
	}
	public static int getSeatSize() {
		return seatName.size();
	}
	
	
	
	public static void setAgeBySeat(Integer seat, String age) {
		ageBySeat.put(seat, age);
	}
	public static LinkedHashMap<Integer, String> getAgeBySeat() {
		return ageBySeat;
	}
	
	
	public static double getTotalCharge() { // price * seatName.get(key) + price * seatName.get(key)
		Set<Integer> keys = seatName.keySet();
		for(Integer key : keys) { // Ű �ƴϰ� ��� �����ߵ�
			//totalCharge += Integer.parseInt(price)*(Double.parseDouble(seatName.get(key))); // ����(����ȭ) * Ű �� �Ѱ��� �̾Ƽ� �� Ű�� ���(�Ǽ�ȭ)
			totalCharge += Integer.parseInt(price)*seatName.get(key);
		}
		return totalCharge;
	}
	
	public static void setTotalCharge() {
		totalCharge = 0;
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

	public static Integer getSeatId() {
		return seatId;
	}

	public static void setSeatId(Integer seatId) {
		ReservationInfo.seatId = seatId;
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

	public static LinkedHashMap<Integer, Double> getSeatName() {
		return seatName;
	}

	public static void setSeatName(LinkedHashMap<Integer, Double> seatName) {
		ReservationInfo.seatName = seatName;
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
		new ReservationInfo().setSeatKeys();
	}
}
