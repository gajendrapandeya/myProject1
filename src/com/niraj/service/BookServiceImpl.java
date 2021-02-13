package com.niraj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niraj.dao.BookDao;
import com.niraj.entity.Book;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookDao bookDao;

	@Override
	@Transactional
	public List<Book> getBooks() {
		// TODO Auto-generated method stub
		return bookDao.getBooks();
	}

	@Override
	@Transactional
	public void saveBook(Book book) {
		bookDao.saveBook(book);
	}

	@Override
	@Transactional
	public List<Book> search(Book book) {

		return bookDao.search(book);
	}
	
	
	@Override
	@Transactional
	public Book getBook(Integer theId) {
		return bookDao.getBook(theId);
	}
	
	@Override
	@Transactional
	public void deleteBook(Integer theId) {
		bookDao.deleteBook(theId);
		
	}

}
