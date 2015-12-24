package project_final;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.GridLayout;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTable tb_member;
	private JTable tb_book;
	private JMenuItem menu_book, menu_manager, menu_member, menu_file;
	static DefaultTableModel model, model2;

	public static void main(String[] args) {
		new Main();

	}

	public Main() {
		JFrame frame = new JFrame("도서관리프로그램");
		frame.setPreferredSize(new Dimension(1000, 500));
		frame.setLocation(700, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container contentPanel = frame.getContentPane();

		//메뉴바
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		menu_book = new JMenu("도서 추가/삭제");
		menuBar.add(menu_book);
		
		menu_manager = new JMenu("도서 대여/반납");
		menuBar.add(menu_manager);
		
		menu_member = new JMenu("회원 추가/삭제");
		menuBar.add(menu_member);
				
		menu_file = new JMenu("파일 저장");
		menuBar.add(menu_file);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		//테이블
		String colName[] = { "회원이름", "전화번호", "대여도서","반납예정일"};
		model = new DefaultTableModel(colName, 0);

		tb_member = new JTable(model);
		model = (DefaultTableModel) tb_member.getModel();

		tb_member.setBounds(379, 90, 337, 426);
		contentPane.add(tb_member);

		String colName2[] = { "책이름", "저자", "출판사", "대여자" };
		model2 = new DefaultTableModel(colName2, 0);
		tb_book = new JTable(model2);
		model2 = (DefaultTableModel) tb_book.getModel();

		tb_book.setBounds(14, 90, 337, 426);
		contentPane.add(tb_book);

		JScrollPane scrollPanel1 = new JScrollPane(tb_member);
		JScrollPane scrollPanel2 = new JScrollPane(tb_book);

		contentPanel.add(scrollPanel1, BorderLayout.CENTER);
		contentPanel.add(scrollPanel2, BorderLayout.WEST);
		
		//이벤트처리
		MainAction action = new MainAction(menu_book, menu_manager,
			menu_member, menu_file);
		menu_book.addMouseListener(action);
		menu_manager.addMouseListener(action);
		menu_member.addMouseListener(action);
		menu_file.addMouseListener(action);

		frame.add(menuBar, BorderLayout.NORTH);

		frame.pack();
		frame.setVisible(true);
	}


}