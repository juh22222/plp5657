package project_final;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Book extends JFrame {

	private JTextField memTf, bookTf; // ȸ���̸�, �����̸� �Է��ʵ�
	private JButton borrowBtn, returnBtn; // �뿩, �ݳ� ��ư
	private JButton search1Btn, search2Btn; // ȸ��, �����˻� ��ư

	public Book() {
		super("���� �뿩 / �ݳ�");
		setPreferredSize(new Dimension(330, 170));
		setLocation(400, 100);

		Container contentPanel = getContentPane();

		JPanel panel = new JPanel();
		JPanel panel1 = new JPanel();
		
		//�Է��ʵ�
		memTf = new JTextField(15);
		bookTf = new JTextField(15);
		//��ư
		search1Btn = new JButton("�˻�");
		search2Btn = new JButton("�˻�");
		borrowBtn = new JButton("�뿩");
		returnBtn = new JButton("�ݳ�");

		panel.add(borrowBtn);
		panel.add(returnBtn);
		panel1.add(new Label("����"));
		panel1.add(bookTf);
		panel1.add(search2Btn);
		panel1.add(new Label(" ȸ��"));
		panel1.add(memTf);
		panel1.add(search1Btn);
		

		contentPanel.add(panel, BorderLayout.SOUTH);
		contentPanel.add(panel1, BorderLayout.CENTER);

		// �̺�Ʈ ó��
		BookAction action = new BookAction(memTf, bookTf, borrowBtn,
				returnBtn, search1Btn, search2Btn);
		memTf.addActionListener(action);
		bookTf.addActionListener(action);
		borrowBtn.addActionListener(action);
		returnBtn.addActionListener(action);
		search1Btn.addActionListener(action);
		search2Btn.addActionListener(action);

		pack();
		setVisible(true);
	}

	
}
