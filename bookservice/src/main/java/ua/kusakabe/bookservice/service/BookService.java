package ua.kusakabe.bookservice.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kusakabe.bookservice.model.Book;
import ua.kusakabe.bookservice.repositories.BookRepository;

import java.util.List;

@Service
@Transactional
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }
    public Book findById(int id) {
        return bookRepository.findById(id).orElse(null);
    }
    public Book save(Book book) {return bookRepository.save(book);}
    public void delete(int id) {
        bookRepository.deleteById(id);
    }

    public List<Book> findByPageAndSize(int page, int size){
        List<Book> allBooks = bookRepository.findAll();
        return allBooks.subList(page*size, (page+1)*size);

//        int startIndex = 0;
//
//        if(page==1){
//            startIndex = size;
//        } else {
//            startIndex = page*size;
//        }
//
//        for(int i = startIndex; i < startIndex+size; i++) {
//
//        }
//
//        return null;
    }

}
