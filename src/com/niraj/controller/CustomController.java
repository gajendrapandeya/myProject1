package com.niraj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niraj.dao.BookDao;
import com.niraj.entity.Book;
import com.niraj.service.BookService;

@Controller
public class CustomController {

	@Autowired
	BookService bookService;

	@RequestMapping("/display")
	public ModelAndView display() {

		ModelAndView model = new ModelAndView("listBooks");

		List<Book> books = bookService.getBooks();

		model.addObject("books", books);
		return model;

	}

	@RequestMapping("/showFormForAdd")
	public ModelAndView create() {

		ModelAndView model = new ModelAndView("createBook");
		Book book = new Book();
		model.addObject("books", book);

		return model;

	}
	
	@RequestMapping(name = "/saveBook" , method = RequestMethod.POST)
	public String saveBook(@ModelAttribute("book") Book book) {
		
		bookService.saveBook(book);
		return "redirect:/display";
		
	}
	
	@RequestMapping("/showFormForUpdate")
	public ModelAndView showFormForUpdate(@RequestParam("bookId") int theId) {
		
		ModelAndView model = new ModelAndView("createBook");
		
		//get the book from the database
		Book book = bookService.getBook(theId);
		
		//set the book as a model attribute to pre-populated the form
		model.addObject("books", book);
		
		return model;
		
	}
	
	@RequestMapping("/delete")
	public String deleteBook(@RequestParam("bookId") int theId) {
		
		
		bookService.deleteBook(theId);
		
		return "redirect:/display";
	}
	
	@RequestMapping(value = "/search" , method = RequestMethod.POST)
	public ModelAndView search(@ModelAttribute("searchBook") Book book) {
		
		ModelAndView model = new ModelAndView("success");
		List<Book> books = bookService.search(book);
		//List<Book> books = bookService.search(book);
		model.addObject("books", books);
		return model;
	}
}