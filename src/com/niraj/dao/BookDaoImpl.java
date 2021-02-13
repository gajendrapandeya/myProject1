package com.niraj.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niraj.entity.Book;

@Repository
public class BookDaoImpl implements BookDao {

	@Autowired
	SessionFactory sessionFactory;

	public List<Book> getBooks() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create query
		Query theQuery = currentSession.createQuery("from Book");

		// execute query and get result list
		List<Book> books = theQuery.list();

		return books;

	}

	public void saveBook(Book book) {

		Session session = sessionFactory.getCurrentSession();

		//save/update the book
		session.saveOrUpdate(book);
	}

	public List<Book> search(Book book) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Criteria criteria = session.createCriteria(Book.class);
		
		
			criteria.add(Restrictions.eq("bookId", book.getBookId())).
			add(Restrictions.eq("bookType", book.getBookType())).
			add(Restrictions.eq("bookName", book.getBookName()));
			
			
		
		
		List<Book> list = criteria.list(); 
		
		return list;

	}
	
	public Book getBook(Integer theId) {
		
		//get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		//now retrieve/read from database using primary key
		Book book = (Book)session.get(Book.class, theId);
		
		return book;
		
	}
	
	public void deleteBook(Integer theId) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query theQuery = session.createQuery("delete from Book where bookId=:bookId");
		
		theQuery.setParameter("bookId", theId);
		
		theQuery.executeUpdate();
		
	}

}
