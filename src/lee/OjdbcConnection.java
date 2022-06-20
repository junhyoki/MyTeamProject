package lee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OjdbcConnection {
	
/*
<���̺귯�� �����>
	JavaBasic - ���콺 ���� - Build Path - Configure Build Path... 
	- Libraries - ClassPath - AddExternal JARs... - (JavaAWS - database - sqldeveloper - jdbc - ojdbc8 Ŭ��)
	- Classpath �ؿ� ojdbc8.jar - C:\JavaAWS\..��¼�� ��� �߸� �� ���� - Apply and Close
	JavaBasic ������ Referenced Libraries - ojdbc8.jar - C:\JavaAWS\.. ���� �� Ȯ��
 */
	
	public static String driverName = "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
								
	
	private static String user = "hr";
	private static String password = "1234"; 
	
	
	static {
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("driver Name Error : " + driverName);
		}
	}
	
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	} //Connection conn = OjdbcConnection.getConnection(); �̷��� �޾Ƽ� ���
}

