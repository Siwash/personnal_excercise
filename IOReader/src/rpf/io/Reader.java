package rpf.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Reader {

	public static String reader(String url) throws Exception {
		File file=new File(url);
		FileReader fr=new FileReader(file);
		char [] b=new char [1024];
		byte [] cs=new byte[1024];
		int len =fr.read(b);
		System.err.println(":"+new String(new String(b).getBytes("ISO-8859-1")));
		return null;
	}
	public static void reader() {
		File file=new File("D:\\\\a.txt");
		try {
			FileInputStream fileInputStream=new FileInputStream(file);
			byte [] tt=new byte [1024];
			int i=-1;
			String string="";
			while ((i=fileInputStream.read())!=-1) {
				string+=(char)i;
			}
			System.err.println(new String(string.getBytes("ISO-8859-1")));
			fileInputStream.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
		}
		
		
	}
	public static void main(String[] args) throws Exception {
		reader("D:\\a.txt");
		reader();
	}

}
