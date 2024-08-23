package ua.kusakabe.bookservice.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

//    public List<Book> findAll() {
//        return bookRepository.findAll();
//    }
    public Page<Book> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }
    public Book findById(long id) {
        return bookRepository.findById(id).orElse(null);
    }
    public Book save(Book book) {return bookRepository.save(book);}
    public void delete(long id) {
        bookRepository.deleteById(id);
    }

    public int getBookCount(){
        return (int) bookRepository.count();
    }

    public Page<Book> searchBooksByTitle(String title, Pageable pageable) {
        return bookRepository.findByBookTitle(title, pageable);
    }

    public Page<Book> findByPageAndSize(String title, Pageable pageable){

//        return bookRepository.findByBook_titleContainingIgnoreCase(title, pageable);

        /*
        System.out.println("Values:\n" + "Page: " + page + " Size: " + size + " Title: " + title +"\n");

        if(title.isEmpty()) {
            System.out.println("Searching for book's for page " + page + " and size " + size);
            int tableCount = getBookCount();
            int index = page * size;
            //1. Create new BookList for books on current page
            List<Book> pageBooks = new ArrayList<>();
            //2. Get booksById and put into new list
            // (if page = 0 => get id from 1 to {size})
            // (if page = 1 => get id from size to size*(page+1))
            // (if page = 2 => get id from size*page to size*(page+1))
            //...

            for (int i = size * page; i <= size * (page + 1); i++) {
                if (bookRepository.findById(i).isPresent()) {
                    pageBooks.add(bookRepository.findById(i).orElse(null));
                }
            }

            return pageBooks;
        } else {
            System.out.println("Searching for book's with title " + title);

            return bookRepository.searchBooks(title);
        }
         */
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
        return null;
    }

}

