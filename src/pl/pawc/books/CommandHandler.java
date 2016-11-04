package pl.pawc.books;

import java.util.Date;
import java.util.GregorianCalendar;

import pl.pawc.books.pojo.Book;

public class CommandHandler {

	public static void handle(String command){
		
		switch(command){
		
		case "exit" : exit(); break;
		case "load" : load(); break;
		case "save" : save(); break;
		case "add" : add(); break;
		case "list" : list(); break;
		//case "remove" : remove(); break;
		//case "like" : like(); break;
		//case "top": top(); break;
		//case "worst" : worst(); break;
		//case "recent" : recent(); break;
		//case "oldest" : oldest(); break;
		//case "help" : help(); break;
		
		}
		
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