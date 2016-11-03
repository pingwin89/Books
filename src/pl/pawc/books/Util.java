package pl.pawc.books;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import pl.pawc.books.pojo.Book;
import pl.pawc.books.pojo.Comment;

public class Util {

	private static GregorianCalendar getDateFrom(String stringDate){
		String temp[] = stringDate.split("-");
		int year = 0;
		int month = 0;
		int day = 0;
		try{
			year = Integer.parseInt(temp[0]);
			month = Integer.parseInt(temp[1]);
			day = Integer.parseInt(temp[2]);
		}
		catch(NumberFormatException e){
			e.printStackTrace();
		}
		finally{
			return new GregorianCalendar(year, month, day);
		}
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
		GregorianCalendar releaseDate = getDateFrom(record[2]);
		int likes = Integer.parseInt(record[3]);
		ArrayList<Comment> comments = getCommentsFrom(extractComments(line));
		
		return new Book(author, tittle, releaseDate, likes, comments);
	}
	
	private static String extractComments(String line){
		String temp[] = line.split(";");
		String result = "";
		for(int i=4; i<temp.length; i++){
			result += temp[i];
		}
		return result;
	}
	
	public static String getStringFrom(Book book){
		String result = "";
		result += book.getAuthor();
		result += ";";
		result += book.getTittle();
		result += ";";
		GregorianCalendar releaseDate = book.getReleaseDate();
		result += releaseDate.YEAR+"-"+releaseDate.MONTH+"-"+releaseDate.DAY_OF_MONTH;
		result += ";";
		result += book.getLikes();
		result += ";";
		result += getStringFrom(book.getComments());
		
		return result;
	}
	
	private static String getStringFrom(ArrayList<Comment> comments){
		String result = "";
		for(Comment comment : comments){
			result += comment.getAuthor();
			result += ";";
			result += comment.getText();
			result += ";";
		}
		result = result.substring(0, result.length()-1);
		return result;
	}
	
}