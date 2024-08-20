package ua.kusakabe.bookservice.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kusakabe.bookservice.model.Book;
import ua.kusakabe.bookservice.repositories.BookRepository;

import java.util.ArrayList;
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

        //1. Create new BookList for books on current page
        List<Book> pageBooks = new ArrayList<>();
        //2. Get booksById and put into new list
        // (if page = 0 => get id from 1 to {size})
        // (if page = 1 => get id from size to size*(page+1))
        // (if page = 2 => get id from size*page to size*(page+1))
        //...
        if(page == 0){
            for(int i = 1 ; i <= size ; i++){
                pageBooks.add(bookRepository.findById(i).orElse(null));
            }
        } else if(page == 1){
            for(int i = size ; i <= size*2 ; i++){
                pageBooks.add(bookRepository.findById(i).orElse(null));
            }
        } else {
            for (int i = size * page; i <= size * (page + 1); i++) {
                pageBooks.add(bookRepository.findById(i).orElse(null));
            }
        }
        return pageBooks;

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
