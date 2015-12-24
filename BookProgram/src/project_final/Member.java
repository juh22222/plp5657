package project_final;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class Member extends JFrame {

	private String mem_name;
	private String mem_tel;
	private String mem_borrow;

	private JButton addBtn, delBtn;
	private JTextField nameTf, telTf;

	public Member() {
		super("ȸ�� �߰�/����");
			
		setPreferredSize(new Dimension(300, 150));
		setLocation(400, 100);

		Container contentPane = getContentPane();

		JPanel panel_b = new JPanel();

		//�Է��ʵ�
		nameTf = new JTextField(17);
		telTf = new JTextField(17);
		//��ư
		addBtn = new JButton("�߰�");
		delBtn = new JButton("����");

		panel_b.add(addBtn);
		panel_b.add(delBtn);

		JPanel panel_tf = new JPanel(new FlowLayout());
		//��
		JLabel label1 = new JLabel("��        ��");
		JLabel label2 = new JLabel("��ȭ��ȣ");

		panel_tf.add(label1, BorderLayout.NORTH);
		panel_tf.add(nameTf, BorderLayout.CENTER);

		panel_tf.add(label2, BorderLayout.NORTH);
		panel_tf.add(telTf, BorderLayout.CENTER);

		contentPane.add(panel_b, BorderLayout.SOUTH);
		contentPane.add(panel_tf, BorderLayout.CENTER);

		//�̺�Ʈó��
		MemberAction action = new MemberAction(mem_name, addBtn, delBtn,
				nameTf, telTf);
		addBtn.addActionListener(action);
		delBtn.addActionListener(action);

		pack();
		setVisible(true);
	}

	public Member(String mem_name, String mem_tel, String mem_borrow) {
		this.mem_name = mem_name;
		this.mem_tel = mem_tel;
		this.mem_borrow = null;
	}

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	public String getMem_tel() {
		return mem_tel;
	}

	public void setMem_tel(String mem_tel) {
		this.mem_tel = mem_tel;
	}

	public String getMem_borrow() {
		return mem_borrow;
	}

	public void setMem_borrow(String mem_borrow) {
		this.mem_borrow = mem_borrow;
	}

	@Override
	public String toString() {
		return "ȸ���� : " + mem_name + ", ȸ����ȭ��ȣ : " + mem_tel
				+ ", �뿩 ���� : " + mem_borrow ;
	}
	
	
}