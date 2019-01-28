package staporpaulina.projectAcc.book;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import staporpaulina.projectAcc.author.Author;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private Long pages;
    @Column(length = 400)
    private String description;
    private String dateOfPublication;
    private String isbn;
    @ManyToMany
    private Author author;

}
