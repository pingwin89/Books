package pl.pawc.books;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import pl.pawc.books.pojo.Book;
import pl.pawc.books.Util;

public class Database {

	public static HashMap<Integer, Book> load(){
		HashMap result = new HashMap<Integer, Book>();
		FileReader fr = null;
		BufferedReader bfr = null;
		
		try{
			fr = new FileReader("books");
			bfr = new BufferedReader(fr);
			String line;
			int key = 1;
			while((line = bfr.readLine()) != null){
				result.put(key, Util.getBookFrom(line));
				key++;
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}
		finally{
			close(bfr);
		}	
		return result;
	}
	
	public static void save(HashMap<Integer, Book> map){
		FileWriter fw = null;
		try{
			fw = new FileWriter("books");
			for(int i : map.keySet()){
				String singleRecord = Util.getStringFrom(map.get(i));
				fw.write(singleRecord+"\n");
				fw.flush();
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}
		finally{
			close(fw);
		}		
	}
	
	private static void close(BufferedReader bfr){
		try{
			bfr.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	private static void close(FileWriter fw){
		try{
			fw.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
}