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
			
			//도서 목록을 파일로 넘김
			bw.write("***********************도서 목록*********************");
			bw.newLine();
			for(int i=0; i<b.blist.size(); i++){
				book_data= b.blist.get(i).toString();
				bw.append(book_data);
				bw.newLine();
			}
			
			//회원 목록을 파일로 넘김
			bw.append("***********************회원 목록*********************");
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
