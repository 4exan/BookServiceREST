package ua.kusakabe.bookservice.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.kusakabe.bookservice.model.Book;
import ua.kusakabe.bookservice.service.BookService;

import java.util.List;

import static org.springframework.data.web.config.EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO;

@RestController
@CrossOrigin(originPatterns = "*", allowedHeaders = "*", allowCredentials = "true")
@RequestMapping("api/book/data")
@RequiredArgsConstructor
@EnableSpringDataWebSupport(pageSerializationMode = VIA_DTO)
public class BookController {

    private final BookService bookService;

    //Commented for safety purpose
//    @GetMapping("/get-all")
//    public List<Book> getAll(){
//        return bookService.findAll();
//    }

//    @GetMapping("/get-book")
//    public Page<Book> getBooksByPage(@RequestParam(defaultValue = "0") int page,
//                                     @RequestParam(defaultValue = "20") int size
//                                     ) {
//        Pageable pageable = PageRequest.of(page, size);
//        return bookService.findAll(pageable);
//    }

    @GetMapping("/get-book/search")
    public Page<Book> searchBooks(
            @RequestParam String title,
            @RequestParam(defaultValue = "0")int page,
            @RequestParam(defaultValue = "20")int size){
        Pageable pageable = PageRequest.of(page, size);
        if(title.isEmpty()) {return bookService.findAll(pageable);} else {
            return bookService.searchBooksByTitle(title, pageable);
        }
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
