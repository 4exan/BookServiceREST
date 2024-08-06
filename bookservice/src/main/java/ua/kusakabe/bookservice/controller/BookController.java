package ua.kusakabe.bookservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.kusakabe.bookservice.model.Book;
import ua.kusakabe.bookservice.service.BookService;

import java.util.List;

@RestController
@RequestMapping("api/book/data")
@AllArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/get-all")
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    public List<Book> getAll(){
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    public Book getById(@PathVariable int id){
        return bookService.findById(id);
    }

}
