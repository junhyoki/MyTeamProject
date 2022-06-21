package park;

import java.util.LinkedHashMap;
import java.util.Set;

public class ReservationInfo { // �ν��Ͻ� ���� Ŭ����

	static public String userId;
	static public String depart;
	static public String arrive;
	static public String price;
	static public String date;
	static public String time;
	static public LinkedHashMap<String, Double> seatName = new LinkedHashMap<>(); // �������� ����� �޴°Ŷ�
//	static public LinkedHashMap<String, String> seatName = new LinkedHashMap<>(); // ��Ʈ������ �޾Ƽ� �Ľ��ϴ� ��� �ΰ� ����
	static public String payWay;
	static public double totalCharge=0; // ������ ���� �� �Ҽ��� ���ϱ� ������ double��

	public ReservationInfo() {
		seatName.put("1", 0.7);
		seatName.put("4", 0.85);
		depart = "������";
		arrive = "�λ�";
		price = "20000";
		date = "2022/06/20";
		time = "17:50";
	
	}

	public static double getTotalCharge() { // price * seatName.get(key) + price * seatName.get(key)
		Set<String> keys = seatName.keySet();

		for(String key : keys) { // Ű �ƴϰ� ��� �����ߵ�
			//totalCharge += Integer.parseInt(price)*(Double.parseDouble(seatName.get(key))); // ����(����ȭ) * Ű �� �Ѱ��� �̾Ƽ� �� Ű�� ���(�Ǽ�ȭ)
			totalCharge += Integer.parseInt(price)*seatName.get(key);
		}
		return totalCharge;
	}
	
	public static void setTotalCharge() {
		totalCharge = 0;
	}
//	public static void main(String[] args) {
//		System.out.println(new ReservationInfo().getTotalCharge());
//	}
}
