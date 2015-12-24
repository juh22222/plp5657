package project_final;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileSave {
	
	BookStockAction b ;
	MemberAction m ;
	FileWriter writer;
	BufferedWriter bw;
	
	public FileSave(){
				
		try {
			writer = new FileWriter("data.txt");
			bw = new BufferedWriter(writer);
			String book_data = "";
			String mem_data = "";
			
			//���� ����� ���Ϸ� �ѱ�
			bw.write("***********************���� ���*********************");
			bw.newLine();
			for(int i=0; i<b.blist.size(); i++){
				book_data= b.blist.get(i).toString();
				bw.append(book_data);
				bw.newLine();
			}
			
			//ȸ�� ����� ���Ϸ� �ѱ�
			bw.append("***********************ȸ�� ���*********************");
			bw.newLine();
			for(int i=0; i<m.mlist.size(); i++){
				mem_data= m.mlist.get(i).toString();
				bw.append(mem_data);
				bw.newLine();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
