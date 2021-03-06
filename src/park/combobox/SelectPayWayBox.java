package park.combobox;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import hong.SaveInfo;

public class SelectPayWayBox extends JComboBox{ // 결제 방법 선택할 콤보박스
	
	SaveInfo user;
	public SelectPayWayBox(SaveInfo user) {
		
		this.user = user;
		
		addItem("결제 방식");
		addItem("------");
		addItem("신용카드");
		addItem("삼성페이");
		addItem("페이코");
		
		selectPayWay();
		setBackground(Color.white);
		setBounds(190, 440, 100, 30);
	}

	void selectPayWay() {
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String way = (String) getSelectedItem().toString();
				if(way.equals("------")||way.equals("결제 방식")) {// 키 값을 고르거나 ---- 고르면 다시 선택하게
					user.setPayWay(null);
					new JOptionPane().showMessageDialog(null, "결제 방식을 선택하세요.","오류",JOptionPane.ERROR_MESSAGE); 
				}else {
					user.setPayWay((String) getSelectedItem().toString()) ;
					System.out.println(user.getPayWay() + "결제 수단 저장 완료");
				}
			}
		});
	}
}
