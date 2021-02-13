package com.niraj.dao;

import java.util.List;

import com.niraj.entity.Book;

public interface BookDao {
	
	public List<Book> getBooks();
	public void saveBook(Book book);
	public List<Book> search(Book book);
	public Book getBook(Integer theId);
	public void deleteBook(Integer theId);
	

}
