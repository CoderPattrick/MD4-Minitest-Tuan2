package com.controller;

import com.model.Book;
import com.model.Category;
import com.service.book_service.BookService;
import com.service.book_service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private CategoryService categoryService;
    @ModelAttribute("categories")
    private Iterable<Category> listCategories(){
        return categoryService.findAll();
    }

//    @GetMapping("/list")
//    public ModelAndView getListBook(){
//        Iterable<Book> list = bookService.findAll();
//        return new ModelAndView("home","books",list);
//    }
    @GetMapping("/home")
    public ModelAndView getListBook(){
        Iterable<Book> list = bookService.findAll();
        return new ModelAndView("/home","books",list);
    }
    @GetMapping
    public ResponseEntity<Iterable<Book>> findAll(){
        return new ResponseEntity<>(bookService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    private ResponseEntity<Book> findById(@PathVariable Long id){
        Optional<Book> book = bookService.findById(id);
        if(!book.isPresent()){
            return new ResponseEntity<>(book.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PostMapping
    private ResponseEntity<Book> createBook(@RequestBody Book book){
        bookService.save(book);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/{id}")
    private ResponseEntity<Book> editBook(@PathVariable Long id,@RequestBody Book book){
        book.setId(id);
        bookService.save(book);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    private ResponseEntity<Book> deleteBook(@PathVariable Long id){
        bookService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
