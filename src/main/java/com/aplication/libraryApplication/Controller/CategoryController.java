package com.aplication.libraryApplication.Controller;

import com.aplication.libraryApplication.Service.AuthorService;
import com.aplication.libraryApplication.Service.BookService;
import com.aplication.libraryApplication.Service.CategoryService;
import com.aplication.libraryApplication.Service.PublisherService;
import com.aplication.libraryApplication.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private PublisherService publisherService;


    @GetMapping("/categories")
    public String findAllCategories(Model model){
        List<Category> categories = categoryService.findAllCategory();
        model.addAttribute("categories", categories);
        return "categories";
    }

    @GetMapping("/remove-category/{id}")
    public String removeCategory(@PathVariable Long id, Model model){
        categoryService.deleteCategory(id);
        model.addAttribute("categories", categoryService.findAllCategory());
        return "categories";
    }

    @GetMapping("update-category/{id}")
    public String updateCategory(@PathVariable Long id, Model model){
        model.addAttribute("category", categoryService.findCategoryById(id));
        return "update-category";
    }

    @PostMapping("/update-category/{id}")
    public String saveCategory(@PathVariable Long id,Category category, BindingResult bindingResult ,Model model ){
        if(bindingResult.hasErrors()){
            return "update-category";
        }
        categoryService.updateCategory(category);
        model.addAttribute("categories", categoryService.findAllCategory());
        return "redirect:/categories";
    }

    @GetMapping("/add-category")
    public String showCreateCategory(Category category){
        return "add-category";
    }

    @PostMapping("/save-category")
    public String saveCategory(Category category, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors())
            return "add-category";
        categoryService.CreateCategory(category);
        model.addAttribute("categories", categoryService.findAllCategory());
        return "redirect:/categories";


    }
}
