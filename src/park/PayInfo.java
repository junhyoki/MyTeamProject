package park;

import javax.swing.JFrame;

import park.button.BackButton;
import park.button.HomeButton;
import park.button.MinusButton;
import park.button.PlusButton;
import park.label.SeatInfoLabel;


public class PayInfo extends JFrame{
	// �׸���� 5,1¥�� ����� ���������� flow, label, combobox, button, label
	

	static HomeButton homeBtn;
	static BackButton backBtn;
	static PlusButton plusBtn;
	static MinusButton minusBtn;
	static SeatInfoLabel seatInfo;
	
	public PayInfo() {
		super("���� ȭ��");
		
		// jcombo.getSelectedItem().toString()
		
		
		
		setLayout(null);
		setResizable(false);
		setBounds(100,100,500,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new PayInfo();
	}

}
