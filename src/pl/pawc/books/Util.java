package pl.pawc.books;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;

import pl.pawc.books.pojo.Book;
import pl.pawc.books.pojo.Comment;

public class Util {

	public static Date getDateFrom(String stringDate){
		String[] temp = stringDate.split("-");
		int year;
		int month;
		int day;
		try{
			year = Integer.parseInt(temp[0]);
			month = Integer.parseInt(temp[1]);
			day = Integer.parseInt(temp[2]);
		}
		catch(NumberFormatException e){
			e.printStackTrace();
			year = 0;
			month = 0;
			day = 0;
		}
		
		GregorianCalendar calendar = new GregorianCalendar(year, month, day);
		Date date = new Date(calendar.getTimeInMillis());
		return date;
	}
	
	private static ArrayList<Comment> getCommentsFrom(String line){
		ArrayList<Comment> result = new ArrayList<Comment>();
		String[] comments = line.split(";");
		for(int i=0; i < comments.length/2; i+=2){
			Comment comment = new Comment(comments[i], comments[i+1]);
			result.add(comment);
		}
		return result;
	}
	
	public static Book getBookFrom(String line){
		String[] record = line.split(";");
		String author = record[0];
		String tittle = record[1];
		Date releaseDate = new Date(Long.parseLong(record[2]));
		int likes = Integer.parseInt(record[3]);
		ArrayList<Comment> comments = getCommentsFrom(extractComments(line));
		log("Extracted comments: "+extractComments(line));
		return new Book(author, tittle, releaseDate, likes, comments);
	}
	
	public static String extractComments(String line){
		String temp[] = line.split(";");
		String result = "";
		for(int i=4; i<temp.length; i++){
			result += temp[i];
			result += ";";
		}
		if(result.length()==0) return "";
		return result.substring(0, result.length()-1);
	}
	
	public static String getStringFrom(Book book){
		String result = "";
		result += book.getAuthor();
		result += ";";
		result += book.getTittle();
		result += ";";
		result += book.getReleaseDate().getTime();
		result += ";";
		result += book.getLikes();
		result += ";";
		result += getStringFrom(book.getComments());
		
		return result;
	}
	
	private static String getStringFrom(ArrayList<Comment> comments){
		String result = "";
		if(comments == null) return "";
		if(comments.isEmpty()) return "";
		for(Comment comment : comments){
			result += comment.getAuthor();
			result += ";";
			result += comment.getText();
			result += ";";
		}
		result = result.substring(0, result.length()-1);
		return result;
	}
	
	public static void list(HashMap<Integer, Book> map){
		for(int i : map.keySet()){
			log(i+": "+map.get(i).toString());
		}
	}
	
	public static void log(String text){
		System.out.println(text);
	}
	
	public static int nextKey(){
		int result = 0;
		for(int i : Main.map.keySet()){
			if(result<=i) result = i;
		}
		return result+1;
	}
	
}