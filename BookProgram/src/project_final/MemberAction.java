package project_final;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class MemberAction implements ActionListener {
	
	private String mem_name;

	private JButton addBtn, delBtn;
	private JTextField nameTf, telTf;
	
	static ArrayList<Member> mlist = new ArrayList<Member>();
	
	public MemberAction(String mem_name, JButton addBtn, JButton delBtn,
			JTextField nameTf, JTextField telTf) {
		super();
		this.mem_name = mem_name;
		this.addBtn = addBtn;
		this.delBtn = delBtn;
		this.nameTf = nameTf;
		this.telTf = telTf;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		//회원 추가
		if (obj == addBtn) {

			JButton b_add = (JButton) obj;
			
			int check = 1;
			for(int i=0; i<mlist.size(); i++){
				if(mlist.get(i).getMem_name().equals(nameTf.getText())){
					JOptionPane.showMessageDialog(null, "이미 등록된 회원입니다.");
					check = -1;
				}
			}
			
			if(check >0){
			Member m = new Member(nameTf.getText(), telTf.getText(),null);
			mlist.add(m);
			int count = mlist.size() - 1;
			nameTf.setText("");
			telTf.setText("");

			// 리스트를 배열로 저장해서 JTable에 열추가
			String arr[] = { mlist.get(count).getMem_name(),
					mlist.get(count).getMem_tel() };
			Main.model.addRow(arr);
			count++;
			}
			
		//회원 삭제	
		} else if (obj == delBtn) {
			JButton b_del = (JButton) obj;
			int check = -1;
			
			for (int i = 0; i < mlist.size(); i++) {
				if (mlist.get(i).getMem_name().equals(nameTf.getText())){
					mlist.remove(i);
					check = 1;
				}
				if (nameTf.getText().equals((String) Main.model.getValueAt(i, 0))) {
					Main.model.removeRow(i);
				}
			}
			
			if(check <0)
				JOptionPane.showMessageDialog(null, "존재하지 않는 회원입니다.");
			
			nameTf.setText("");
			telTf.setText("");

		}

	}

}
