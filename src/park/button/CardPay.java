package park.button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class CardPay extends JButton {
	public CardPay() {
		super("ī�� ����");
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//JOptinopane
				
			}
		});
		setBounds(50,10,50,50);
	}

}
