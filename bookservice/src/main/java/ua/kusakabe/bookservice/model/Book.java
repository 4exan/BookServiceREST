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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String author;
    private String isbn;
    private String publisher;

}
