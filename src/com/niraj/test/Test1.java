package com.niraj.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.niraj.entity.Book;

public class Test1 {
	
	public static void main(String[] args) {
		
		 Resource r=new ClassPathResource("/WEB-INF/spring-servlet.xml");  
		    BeanFactory factory=new XmlBeanFactory(r);  
		      
		   Book book = new Book();
		  System.out.println( book.getBookId());
		  System.out.println( book.getBookName());
		  System.out.println( book.getBookType());
		       
	}

}
