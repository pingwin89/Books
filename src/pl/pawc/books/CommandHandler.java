package pl.pawc.books;

import java.util.Date;
import java.util.GregorianCalendar;

import pl.pawc.books.pojo.Book;
import pl.pawc.books.pojo.Comment;

public class CommandHandler {

	public static void handle(String command){
		
		switch(command){
		
		case "exit" : exit(); break;
		case "load" : load(); break;
		case "save" : save(); break;
		case "add" : add(); break;
		case "list" : list(); break;
		case "comment" : comment(); break;
		//case "remove" : remove(); break;
		//case "like" : like(); break;
		//case "top": top(); break;
		//case "worst" : worst(); break;
		//case "recent" : recent(); break;
		//case "oldest" : oldest(); break;
		//case "help" : help(); break;
				
		}
		
	}
	
	private static void comment(){
		int number;
		String author = null;
		String text = null;
		try{
			Util.log("your name: ");
			author = Main.sc.nextLine();
			Util.log("your comment: ");
			text = Main.sc.nextLine();
			Util.log("Number of the book to comment:");
			number = Main.sc.nextInt();
		}
		catch(Exception e){
			e.printStackTrace();
			return;
		}
		Comment comment = new Comment(author, text);
		if(Main.map.get(number)==null) return;
		Main.map.get(number).addComment(comment);	
	}
	
	private static void exit(){
		Util.log("Goodbye");
	}
	
	private static void load(){
		Main.map = Database.load();
	}
	
	private static void save(){
		Database.save(Main.map);
	}
	
	private static void add(){
		Util.log("new Author: ");
		String author = Main.sc.nextLine();
		Util.log("new Tittle: ");
		String tittle = Main.sc.nextLine();
		Util.log("release date (format yyyy-mm-dd)");
		String dateString = Main.sc.nextLine();
		Date date = Util.getDateFrom(dateString);
		Book book = new Book(author, tittle, date);
		Main.map.put(Util.nextKey(), book);	
	}
	
	private static void list(){
		Util.list(Main.map);
	}	
	
}