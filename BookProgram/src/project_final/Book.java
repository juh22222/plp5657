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

	private JTextField memTf, bookTf; // 회원이름, 도서이름 입력필드
	private JButton borrowBtn, returnBtn; // 대여, 반납 버튼
	private JButton search1Btn, search2Btn; // 회원, 도서검색 버튼

	public Book() {
		super("도서 대여 / 반납");
		setPreferredSize(new Dimension(330, 170));
		setLocation(400, 100);

		Container contentPanel = getContentPane();

		JPanel panel = new JPanel();
		JPanel panel1 = new JPanel();
		
		//입력필드
		memTf = new JTextField(15);
		bookTf = new JTextField(15);
		//버튼
		search1Btn = new JButton("검색");
		search2Btn = new JButton("검색");
		borrowBtn = new JButton("대여");
		returnBtn = new JButton("반납");

		panel.add(borrowBtn);
		panel.add(returnBtn);
		panel1.add(new Label("도서"));
		panel1.add(bookTf);
		panel1.add(search2Btn);
		panel1.add(new Label(" 회원"));
		panel1.add(memTf);
		panel1.add(search1Btn);
		

		contentPanel.add(panel, BorderLayout.SOUTH);
		contentPanel.add(panel1, BorderLayout.CENTER);

		// 이벤트 처리
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
