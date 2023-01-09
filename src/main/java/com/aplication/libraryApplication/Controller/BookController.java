package com.aplication.libraryApplication.Controller;

import com.aplication.libraryApplication.Service.AuthorService;
import com.aplication.libraryApplication.Service.BookService;
import com.aplication.libraryApplication.Service.CategoryService;
import com.aplication.libraryApplication.Service.PublisherService;
import com.aplication.libraryApplication.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private PublisherService publisherService;

    @GetMapping("/books")
    public String findAllBooks(Model model){
        List<Book> books = bookService.findAllBooks();
        model.addAttribute("books",books);
        return "books";
    }
    @GetMapping("/book/{id}")
    public String findBook(@PathVariable Long id, Model model){
        Book book = bookService.findBookById(id);
        model.addAttribute("book",book);
        return "list-book";

    }

    @GetMapping("remove-book/{id}")
    public String deleteBook(@PathVariable Long id, Model model){
        bookService.DeleteBook(id);
        model.addAttribute("books", bookService.findAllBooks());
        return "books";
    }

    @GetMapping("/update-book/{id}")
    public String updateBook(@PathVariable Long id, Model model){
        Book book = bookService.findBookById(id);
        model.addAttribute("categories", categoryService.findAllCategory());
        model.addAttribute("publishers", publisherService.findAllPublishers());
        model.addAttribute("authors", authorService.findAllAuthors());
        model.addAttribute("book", book);
        return "update-book";

    }

    @PostMapping("/save-update/{id}")
    public String updateBook(@PathVariable Long id, Book book, BindingResult result, Model model){
        if(result.hasErrors()){
            return "update-book";
        }
        bookService.UpdateBook(book);
        model.addAttribute("books", bookService.findAllBooks());
        return "redirect:/books";
    }

    @GetMapping("/add-book")
    public String addBook(Book book, Model model){
        model.addAttribute("categories", categoryService.findAllCategory());
        model.addAttribute("publishers", publisherService.findAllPublishers());
        model.addAttribute("authors", authorService.findAllAuthors());
        return "add-book";

    }

    @PostMapping("/save-book")
    public String saveBook(Book book, BindingResult result, Model model){
        if(result.hasErrors()){
            return "add-book";
        }
        bookService.CreateBook(book);
        model.addAttribute("books", bookService.findAllBooks());
        return "redirect:/books";
    }


}
