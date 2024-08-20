package ua.kusakabe.bookservice.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@Table(name = "Book")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
public class Book {

    private String isbn;
    private String book_title;
    private String book_author;
    private String year_of_publication;
    private String publisher;
    private String image_url_s;
    private String image_url_m;
    private String image_url_l;
    @Id
    private long id;

}
