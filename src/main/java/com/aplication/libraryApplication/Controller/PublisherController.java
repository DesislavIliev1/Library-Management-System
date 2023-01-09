package com.aplication.libraryApplication.Controller;

import com.aplication.libraryApplication.Service.BookService;
import com.aplication.libraryApplication.Service.CategoryService;
import com.aplication.libraryApplication.Service.PublisherService;
import com.aplication.libraryApplication.entity.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @GetMapping("/publishers")
    public String findAllPublishers(Model model){
       List<Publisher>  publishers = publisherService.findAllPublishers();
       model.addAttribute("publishers", publishers);
        return "publishers";
    }

    @GetMapping("/remove-publisher/{id}")
    public String deletePublisher(@PathVariable Long id, Model model){
        publisherService.deletePublisher(id);
        model.addAttribute("publishers", publisherService.findAllPublishers());
        return "publishers";
    }

    @GetMapping("update-publisher/{id}")
    public String updatePublisher(@PathVariable Long id, Model model){
        model.addAttribute("publisher", publisherService.findPublisherById(id));
        return "update-publisher";
    }

    @PostMapping("update-publisher/{id}")
    public String savePublisher(@PathVariable Long id, Publisher publisher, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "update-publisher";
        }
        publisherService.updatePublisher(publisher);
        model.addAttribute("publishers", publisherService.findAllPublishers());
        return "redirect:/publishers";
    }

    @GetMapping("/add-publisher")
    public String showCreatePublisher(Publisher publisher){
        return "add-publisher";
    }

    @PostMapping("/save-publisher")
    public String savePublisher(Publisher publisher, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "add-publisher";
        }
        publisherService.createPublisher(publisher);
        model.addAttribute("publishers", publisherService.findAllPublishers());
        return "redirect:/publishers";
    }


}
