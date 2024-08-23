package ua.kusakabe.bookservice.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.kusakabe.bookservice.model.Book;


import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    long count();

    Page<Book> findAll(Pageable pageable);

    @Query("SELECT b FROM Book b WHERE LOWER(b.book_title) LIKE LOWER(CONCAT('%', :bookTitle, '%'))")
    Page<Book> findByBookTitle(@Param("bookTitle") String title, Pageable pageable);

//    @Query("SELECT b FROM Book b where b.book_title like concat('%', :searchTerm, '%')")
//    List<Book> searchBooks(@Param("searchTerm") String searchTerm);

//    Page<Book> findByBook_titleContainingIgnoreCase(String searchTerm, Pageable pageable);
}
