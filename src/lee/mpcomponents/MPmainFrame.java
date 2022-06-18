package lee.mpcomponents;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import lee.mpevents.MPBackBtnEvent;
import lee.mpevents.MPcompleteBtnEvent;
import lee.mpevents.MPeditBtnEvent;
import lee.mpevents.MPnavBtnsEvent;
import lee.mpevents.MPreservationCancleBtnEvent;

public class MPmainFrame extends JFrame {

	JButton MPhomeBtn = new JButton();
	JLabel MPcategoryLb = new JLabel("ī�װ���");
	
	MPnavPanel MPnav = new MPnavPanel();
	MPcontentsPanel MPcontents = new MPcontentsPanel();
	
	//ī�װ��� �� �ؽ�Ʈ �ٲٴ� �޼���
	public void setCategoryLabelText(String title) {
		MPcategoryLb.setText(title);	
	}
	
	
//�׼Ǹ����ʿ��� ���� �޼���� ����_____________________________________________________________________________________________________________
	
	//�׺���̼� 3��ư �׼�
	public void navBtnCtrl (JButton btn) {
		if(btn.getText().equals("�� ���� ��ȸ/����")) {
			setCategoryLabelText("�� ���� ��ȸ");
			MPcontents.MPcontentsCard.show(MPcontents, "������");
		} else if(btn.getText().equals("���� Ȯ��")) {
			setCategoryLabelText(btn.getText());
			MPcontents.MPcontentsCard.show(MPcontents, "���ų���");
		} else if(btn.getText().equals("���� Ż��")) {
			setCategoryLabelText(btn.getText());
			MPcontents.MPcontentsCard.show(MPcontents, "����Ż��");
		}
	}	
	
	
	//�����ʼ����ϱ� ��ư ������ ��
	public void editBtnCtrl () {		
		setCategoryLabelText("�� ���� ����");
		MPcontents.MPprofile.showMPprofile_2(); 
	}
	
	//�����ʼ����ϱ� ȭ�鿡�� �ڷΰ��� ��ư ������ �� (������ �����ϸ� �� �� ��)
	public void backBtnCtrl () {
		setCategoryLabelText("�� ���� ��ȸ");
		MPcontents.MPprofile.showMPprofile_1();
	}
	
	//�����ʼ����ϱ� ȭ�鿡�� ���� �Ϸ� ��ư ������ �� (������ �����ؾߵ� ��)
	public void completeBtnCtrl() {
		setCategoryLabelText("�� ���� ��ȸ");
		MPcontents.MPprofile.showMPprofile_1();	
		//���⿡ ������ ���� �����ϴ� ��� �ֱ�� 
	} //������ ���� ȭ�鿡�� �׻� �ֽ� ���� �ߵ��� �س��߰ڳ� 

	
 
	
	public void reservationCancelBtnCtrl () {
		 setVisible(false);//���߿� ���� 
	}
	
//____________________________________________________________________________________________________________________________________	
	
	
	
	public MPmainFrame() {
		
		setLayout(null);

		setCategoryLabelText("�� ���� ��ȸ");
		
		MPcategoryLb.setBounds(230, 30, 700, 100);
		MPcategoryLb.setFont(new Font("���", Font.PLAIN, 25));
		this.add(MPcategoryLb);
		
		
		MPhomeBtn.setBounds(10, 10, 50, 50);
		MPhomeBtn.setBorderPainted(false);
		MPhomeBtn.setBackground(Color.cyan);
			
		
		/*
		//Ȩ��ư ������ Ȩȭ������ ���� 
		//(�� �ٵ� ������ ��ü ī�巹�Ʒ� ���� �ŷ����ϱ� ���߿� ��ġ�� show(ī�巹�ư� �޷� �ִ� �� ,"Ȩ?") ���� �ϸ� �ǰڳ�
		MPhomeBtn.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		*/
		
		
		//�׺���̼� �� ��ư 3�� �׼�
		MPnav.MPprofileBtn.addActionListener(new MPnavBtnsEvent(this, MPnav.MPprofileBtn));
		MPnav.MPleaveBtn.addActionListener(new MPnavBtnsEvent(this, MPnav.MPleaveBtn));
		MPnav.MPreservationBtn.addActionListener(new MPnavBtnsEvent(this, MPnav.MPreservationBtn));
		
		
		
		// ������ �г� ��ư�� �׼�
		MPcontents.MPprofile.MPprofile_1.MPeditBtn.addActionListener(new MPeditBtnEvent(this));
		MPcontents.MPprofile.MPprofile_2.MPbackBtn.addActionListener(new MPBackBtnEvent(this));
		MPcontents.MPprofile.MPprofile_2.MPcompleteBtn.addActionListener(new MPcompleteBtnEvent(this));
		
		
		
		
		
		//������ҹ�ư �׼�
		MPcontents.MPreservation.MPreservationcancleBtn.addActionListener(new MPreservationCancleBtnEvent(this));
		
		
		
		
		
		
		add(MPnav);
		add(MPcontents);	
		add(MPhomeBtn);
			
		
		//������ ����
		setTitle("����������");
		getContentPane().setBackground(Color.WHITE);//���� ���߿� ���߱�		
		setBounds(0, 0, 800, 650);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	

	
	//�׽�Ʈ�� ���κ�. ���߿� ����
	public static void main(String[] args) {
		new MPmainFrame();
	}
}
