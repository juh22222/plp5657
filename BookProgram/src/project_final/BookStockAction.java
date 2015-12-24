package project_final;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class BookStockAction implements ActionListener {
	
	private String book_name;
	private JButton addBtn, delBtn;
	private JTextField bookTf, publisherTf, writerTf;

	static ArrayList<BookStock> blist = new ArrayList<BookStock>();
	
	

	public BookStockAction(String book_name, JButton addBtn,
			JButton delBtn, JTextField bookTf, JTextField publisherTf,
			JTextField writerTf) {
		super();
		this.book_name = book_name;
		this.addBtn = addBtn;
		this.delBtn = delBtn;
		this.bookTf = bookTf;
		this.publisherTf = publisherTf;
		this.writerTf = writerTf;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		// ���� �߰�
		if (obj == addBtn) {

			int check = 1;
			for (int i = 0; i < blist.size(); i++) {
				if (blist.get(i).getBook_name().equals(bookTf.getText())) {
					JOptionPane.showMessageDialog(null, "�̹� ��ϵ� �����Դϴ�.");
					check = -1;
				}
			}

			if (check > 0) {
				JButton b = (JButton) obj;

				BookStock b1 = new BookStock(bookTf.getText(), writerTf.getText(), publisherTf.getText(),  null);

				blist.add(b1);
				bookTf.setText("");
				publisherTf.setText("");
				writerTf.setText("");

				int count = blist.size() - 1;

				// ����Ʈ�� �迭�� �����ؼ� JTable�� ���߰�
				String arr[] = { blist.get(count).getBook_name(),
						blist.get(count).getBook_publisher(),
						blist.get(count).getBook_writer() };
				Main.model2.addRow(arr);

			}

		// ���� ����
		} else if (obj == delBtn) {
			JButton b2 = (JButton) obj;
			int check = -1;

			for (int i = 0; i < blist.size(); i++) {
				if (blist.get(i).getBook_name().equals(bookTf.getText())) {
						blist.remove(i);
						check = 1;
						if (bookTf.getText().equals(
							(String) Main.model2.getValueAt(i, 0))) {
						Main.model2.removeRow(i);
						}	
				}
			}

			if (check <0) {
					JOptionPane.showMessageDialog(null, "�������� �ʴ� �����Դϴ�.");
			}


			bookTf.setText("");
			publisherTf.setText("");
			writerTf.setText("");
		}
	}
}
