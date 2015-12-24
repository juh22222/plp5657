package project_final;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import project_final.Main;

public class BookAction implements ActionListener {

	private JTextField memTf, bookTf; // ȸ���̸�, �����̸� �Է��ʵ�
	private JButton borrowBtn, returnBtn; // �뿩, �ݳ� ��ư
	private JButton search1Btn, search2Btn; // ȸ��, �����˻� ��ư
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

		String rental_day = (gc.get(Calendar.MONTH) + 1) + "��"
				+ gc.get(Calendar.DATE) + "��";
		String return_day = (gc.get(Calendar.MONTH) + 1) + "��"
				+ (gc.get(Calendar.DATE) + 7) + "��";

		// ���� �˻�
		if (obj == search2Btn) {
			b_check = 0;
			for (int i = 0; i < s.blist.size(); i++) {
				if (s.blist.get(i).getBook_name().equals(bookTf.getText())) {
					if (s.blist.get(i).getBook_borrow() != null) {
						JOptionPane.showMessageDialog(null, "�뿩�ڴ� "
								+ s.blist.get(i).getBook_borrow() + "�Դϴ�");
						b_check = 1;
						break;
					} else if (s.blist.get(i).getBook_borrow() == null) {
						JOptionPane.showMessageDialog(null, "�뿩 �����մϴ�.");
						b_check = 2;
						break;
					}
				} else if (!s.blist.get(i).getBook_name()
						.equals(bookTf.getText()))
					b_check = 3;
			}
			if (b_check == 3)
				JOptionPane.showMessageDialog(null, "��ϵ��� ���� �����Դϴ�.");

			// ȸ�� �˻�
		} else if (obj == search1Btn) {
			m_check = 0;
			for (int i = 0; i < m.mlist.size(); i++) {
				if (m.mlist.get(i).getMem_name().equals(memTf.getText())) {
					if (m.mlist.get(i).getMem_borrow() != null) {
						JOptionPane.showMessageDialog(null, "�뿩������ "
								+ m.mlist.get(i).getMem_borrow() + "�Դϴ�");
						m_check = 1;
						break;
					} else if (m.mlist.get(i).getMem_borrow() == null) {
						JOptionPane.showMessageDialog(null, "�뿩 �����մϴ�.");
						m_check = 2;
						break;
					}
				} else if (!m.mlist.get(i).getMem_name()
						.equals(memTf.getText()))
					m_check = 3;
			}
			if (m_check == 3)
				JOptionPane.showMessageDialog(null, "��ϵ��� ���� ȸ���Դϴ�.");

			// �뿩
		} else if (obj == borrowBtn) {
			borrowBtn = (JButton) obj;

			if ((b_check + m_check != 4))
				JOptionPane.showMessageDialog(null, "ȸ��/���� �˻��� �ٽ� ���ּ���.");

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

			// �ݳ�
		} else if (obj == returnBtn) {
			returnBtn = (JButton) obj;

			if ((b_check + m_check != 2))
				JOptionPane.showMessageDialog(null, "ȸ��/���� �˻��� �ٽ� ���ּ���.");

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
