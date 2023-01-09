package com.aplication.libraryApplication;

import com.aplication.libraryApplication.Service.BookService;
import com.aplication.libraryApplication.entity.Author;
import com.aplication.libraryApplication.entity.Book;
import com.aplication.libraryApplication.entity.Category;
import com.aplication.libraryApplication.entity.Publisher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Calendar;

@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

    @Bean
	public CommandLineRunner initialCreate(BookService bookService){
		return (args) ->{
			Book book1 = new Book ("ABC", "Book name", "My first book");
			Author author1 = new Author( "Test name1", "Test description");
			Category category1 = new Category("Business books");
			Publisher publisher1 = new Publisher("First Publisher");
			book1.AddAuthor(author1);
			book1.AddCategory(category1);
			book1.AddPublisher(publisher1);
			bookService.CreateBook(book1);

			Book book2 = new Book ("CDS", "Gosho", "My second book");
			Author author2 = new Author( "Ivan", "Test description2");
			Category category2 = new Category("Science books");
			Publisher publisher2 = new Publisher("Second Publisher");
			book2.AddAuthor(author2);
			book2.AddCategory(category2);
			book2.AddPublisher(publisher2);
			bookService.CreateBook(book2);

			Book book3 = new Book ("ABC3", "Book name3", "My first book3");
			Author author3 = new Author( "Test name3", "Test description3");
			Category category3 = new Category("Sci-fi books");
			Publisher publisher3 = new Publisher("Third Publisher");
			book3.AddAuthor(author3);
			book3.AddCategory(category3);
			book3.AddPublisher(publisher3);
			bookService.CreateBook(book3);



		};
	}

}
