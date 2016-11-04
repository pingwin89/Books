package pl.pawc.books;

import pl.pawc.books.pojo.Book;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static HashMap<Integer, Book> map = new HashMap<Integer, Book>();
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String args[]){
		
		String input = null;
		
		while(!"exit".equals(input)){
			input = sc.nextLine();
			CommandHandler.handle(input);
		}	
	}
	
}