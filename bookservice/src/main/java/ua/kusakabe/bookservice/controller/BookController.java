package ua.kusakabe.bookservice.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.kusakabe.bookservice.model.Book;
import ua.kusakabe.bookservice.service.BookService;

import java.util.List;

@RestController
@CrossOrigin(originPatterns = "*", allowedHeaders = "*", allowCredentials = "true")
@RequestMapping("api/book/data")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    //Commented for safety purpose
//    @GetMapping("/get-all")
//    public List<Book> getAll(){
//        return bookService.findAll();
//    }

    @GetMapping("/get-book")
    public List<Book> getBooksByPage(@RequestParam(defaultValue = "1") int page,
                                                     @RequestParam(defaultValue = "20") int size) {
        return bookService.findByPageAndSize(page, size);
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable int id){
        return bookService.findById(id);
    }

    @PostMapping("/add-new")
    public ResponseEntity<Book> saveBook(@RequestBody Book book){
        System.out.println("Book saved");
        Book savedBook = bookService.save(book);
        System.out.println(book.getBook_title() + " " + book.getBook_author());
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }
}
