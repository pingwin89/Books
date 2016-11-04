package pl.pawc.books.pojo;

import java.util.Date;

import javax.rmi.CORBA.Util;

import java.util.ArrayList;

public class Book {

	private String author;
	private String tittle;
	private Date releaseDate;
	private int likes;
	private ArrayList<Comment> comments;
	
	public Book(String author, String tittle, Date releaseDate){
		this.author = author;
		this.tittle = tittle;
		this.releaseDate = releaseDate;
		likes = 0;
		ArrayList<Comment> comments = new ArrayList<Comment>();
	}
	
	public Book(String author, String tittle, Date releaseDate, int likes, ArrayList<Comment> comments){
		this.author = author;
		this.tittle = tittle;
		this.releaseDate = releaseDate;
		this.likes = likes;
		this.comments = comments;
	}
	
	public String getAuthor(){
		return author;
	}
	
	public String getTittle(){
		return tittle;
	}
	
	public Date getReleaseDate(){
		return releaseDate;
	}
	
	public int getLikes(){
		return likes;
	}
	
	public ArrayList<Comment> getComments(){
		return comments;
	}
	
	public void addLike(){
		likes++;
	}
	
	public void addComment(Comment comment){
		comments.add(comment);
	}
	
	public String toString(){
		return author+" - "+ tittle +", released on:"+releaseDate.toString()+". Likes: "+likes;
	}

}