package project_final;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import project_final.Main;

public class BookAction implements ActionListener {

	private JTextField memTf, bookTf; // 회원이름, 도서이름 입력필드
	private JButton borrowBtn, returnBtn; // 대여, 반납 버튼
	private JButton search1Btn, search2Btn; // 회원, 도서검색 버튼
	private MemberAction m;
	private BookStockAction s;

	static int b_check = -1;
	static int m_check = -1;

	public BookAction(JTextField memTf, JTextField bookTf, JButton borrowBtn,
			JButton returnBtn, JButton search1Btn, JButton search2Btn) {
		super();
		this.memTf = memTf;
		this.bookTf = bookTf;
		this.borrowBtn = borrowBtn;
		this.returnBtn = returnBtn;
		this.search1Btn = search1Btn;
		this.search2Btn = search2Btn;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		Calendar gc = Calendar.getInstance();

		String rental_day = (gc.get(Calendar.MONTH) + 1) + "월"
				+ gc.get(Calendar.DATE) + "일";
		String return_day = (gc.get(Calendar.MONTH) + 1) + "월"
				+ (gc.get(Calendar.DATE) + 7) + "일";

		// 도서 검색
		if (obj == search2Btn) {
			b_check = 0;
			for (int i = 0; i < s.blist.size(); i++) {
				if (s.blist.get(i).getBook_name().equals(bookTf.getText())) {
					if (s.blist.get(i).getBook_borrow() != null) {
						JOptionPane.showMessageDialog(null, "대여자는 "
								+ s.blist.get(i).getBook_borrow() + "입니다");
						b_check = 1;
						break;
					} else if (s.blist.get(i).getBook_borrow() == null) {
						JOptionPane.showMessageDialog(null, "대여 가능합니다.");
						b_check = 2;
						break;
					}
				} else if (!s.blist.get(i).getBook_name()
						.equals(bookTf.getText()))
					b_check = 3;
			}
			if (b_check == 3)
				JOptionPane.showMessageDialog(null, "등록되지 않은 도서입니다.");

			// 회원 검색
		} else if (obj == search1Btn) {
			m_check = 0;
			for (int i = 0; i < m.mlist.size(); i++) {
				if (m.mlist.get(i).getMem_name().equals(memTf.getText())) {
					if (m.mlist.get(i).getMem_borrow() != null) {
						JOptionPane.showMessageDialog(null, "대여도서는 "
								+ m.mlist.get(i).getMem_borrow() + "입니다");
						m_check = 1;
						break;
					} else if (m.mlist.get(i).getMem_borrow() == null) {
						JOptionPane.showMessageDialog(null, "대여 가능합니다.");
						m_check = 2;
						break;
					}
				} else if (!m.mlist.get(i).getMem_name()
						.equals(memTf.getText()))
					m_check = 3;
			}
			if (m_check == 3)
				JOptionPane.showMessageDialog(null, "등록되지 않은 회원입니다.");

			// 대여
		} else if (obj == borrowBtn) {
			borrowBtn = (JButton) obj;

			if ((b_check + m_check != 4))
				JOptionPane.showMessageDialog(null, "회원/도서 검색을 다시 해주세요.");

			for (int i = 0; i < m.mlist.size(); i++) {
				for (int j = 0; j < s.blist.size(); j++) {

					if (b_check == 2 && m_check == 2) {
						if (s.blist.get(j).getBook_name()
								.equals(bookTf.getText())) {
							s.blist.get(j).setBook_borrow(memTf.getText());
							Main.model2.setValueAt(memTf.getText(), j, 3);
						}
						if (m.mlist.get(i).getMem_name()
								.equals(memTf.getText())) {
							m.mlist.get(i).setMem_borrow(bookTf.getText());
							Main.model.setValueAt(bookTf.getText(), i, 2);
							Main.model.setValueAt(return_day, i, 3);
							
						}
					}
				}
			}

			// 반납
		} else if (obj == returnBtn) {
			returnBtn = (JButton) obj;

			if ((b_check + m_check != 2))
				JOptionPane.showMessageDialog(null, "회원/도서 검색을 다시 해주세요.");

			for (int i = 0; i < m.mlist.size(); i++) {
				for (int j = 0; j < s.blist.size(); j++) {
					if (b_check == 1 && m_check == 1) {
						if (s.blist.get(j).getBook_name()
								.equals(bookTf.getText())) {
							s.blist.get(j).setBook_borrow(null);
							Main.model2.setValueAt(null, j, 3);
						}
						if (m.mlist.get(i).getMem_name()
								.equals(memTf.getText())) {
							m.mlist.get(i).setMem_borrow(null);
							Main.model.setValueAt(null, i, 2);
							Main.model.setValueAt(null, i, 3);
						}
					}

				}
			}

		}
	}

}
