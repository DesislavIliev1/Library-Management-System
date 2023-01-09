package com.aplication.libraryApplication.Service;

import com.aplication.libraryApplication.Repository.BookRepository;
import com.aplication.libraryApplication.entity.Book;
import com.aplication.libraryApplication.entity.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;


    public List<Book>findAllBooks(){
        return bookRepository.findAll();
    }

    public Book findBookById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        return book;
    }

    public void CreateBook(Book book){
        bookRepository.save(book);
    }

    public void UpdateBook(Book book){
        bookRepository.save(book);
    }

    public void DeleteBook(Long id){
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        bookRepository.deleteById(book.getId());
    }




}
