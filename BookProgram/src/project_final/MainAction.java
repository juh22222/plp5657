package project_final;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

public class MainAction  implements MouseListener {

	private JMenuItem menu_book, menu_manager, menu_member, menu_file;
	
	
	public MainAction(JMenuItem menu_book, JMenuItem menu_manager,
			JMenuItem menu_member, JMenuItem menu_file) {
		super();
		this.menu_book = menu_book;
		this.menu_manager = menu_manager;
		this.menu_member = menu_member;
		this.menu_file = menu_file;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object obj = e.getSource();
		//도서 추가/삭제
		if (obj == menu_book) {
			JMenuItem mb = (JMenuItem) obj;
			BookStock bs = new BookStock();
		//도서 대여/반납	
		} else if (obj == menu_manager) {
			JMenuItem mb = (JMenuItem) obj;
			Book b = new Book();
		//회원 추가/삭제	
		} else if (obj == menu_member) {
			JMenuItem mb = (JMenuItem) obj;
			Member bs = new Member();
		//파일 저장	
		} else if (obj ==menu_file ){
			JMenuItem mb = (JMenuItem) obj;
			FileSave fs = new FileSave();
			JOptionPane.showMessageDialog(null, "저장 완료");
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
