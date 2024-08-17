package ua.kusakabe.bookservice.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.kusakabe.bookservice.model.Book;
import ua.kusakabe.bookservice.service.BookService;

import java.util.List;

@RestController
@RequestMapping("api/book/data")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/get-all")
    public List<Book> getAll(){
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable int id){
        return bookService.findById(id);
    }

    @PostMapping("/new")
    @CrossOrigin("http://127.0.0.1:3000")
    public void saveBook(@RequestBody Book book){
        System.out.println("Book saved");
        bookService.save(book);
    }
}
