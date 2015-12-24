package project_final;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.List;
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
import javax.swing.table.DefaultTableModel;

public class BookStock extends JFrame{

	private String book_name;
	private String book_publisher;
	private String book_writer;
	private String book_borrow;

	private JButton addBtn, delBtn;
	private JTextField bookTf, publisherTf, writerTf;
	private JTable table;

	public BookStock() {
		super("도서 추가/관리");
		
		setPreferredSize(new Dimension(270, 180));
		setLocation(400, 100);

		Container container = getContentPane();
		
		JPanel p = new JPanel();
		JPanel p2 = new JPanel();

		//버튼
		addBtn = new JButton("추가");
		delBtn = new JButton("삭제");

		//입력필드
		bookTf = new JTextField(17);
		writerTf = new JTextField(17);
		publisherTf = new JTextField(17);

		p.add(addBtn, BorderLayout.EAST);
		p.add(delBtn, BorderLayout.WEST);

		//라벨
		p2.add(new JLabel("도서명:"), BorderLayout.NORTH);
		p2.add(bookTf, BorderLayout.CENTER);
		p2.add(new JLabel("저    자:"), BorderLayout.NORTH);
		p2.add(writerTf, BorderLayout.CENTER);
		p2.add(new JLabel("출판사:"), BorderLayout.NORTH);
		p2.add(publisherTf, BorderLayout.CENTER);
		
		//이벤트처리
		BookStockAction action = new BookStockAction(book_name, addBtn,delBtn, bookTf, publisherTf, writerTf);
		
		addBtn.addActionListener(action);
		delBtn.addActionListener(action);

		container.add(p, BorderLayout.SOUTH);
		container.add(p2, BorderLayout.CENTER);

		pack();
		setVisible(true);
	}

	public BookStock(String book_name, String book_publisher,
			String book_writer, String borrow) {
		this.book_name = book_name;
		this.book_publisher = book_publisher;
		this.book_writer = book_writer;
		this.book_borrow = null;
	}


	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getBook_publisher() {
		return book_publisher;
	}

	public void setBook_publisher(String book_publisher) {
		this.book_publisher = book_publisher;
	}

	public String getBook_writer() {
		return book_writer;
	}

	public void setBook_writer(String book_writer) {
		this.book_writer = book_writer;
	}

	public String getBook_borrow() {
		return book_borrow;
	}

	public void setBook_borrow(String book_borrow) {
		this.book_borrow = book_borrow;
	}

	@Override
	public String toString() {
		return "도서명 : " + book_name + ", 출판사 : "
				+ book_publisher + ", 저자 : " + book_writer
				+ ", 대여자 : " + book_borrow ;
	}

}