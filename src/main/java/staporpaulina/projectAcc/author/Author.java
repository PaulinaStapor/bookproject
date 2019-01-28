package staporpaulina.projectAcc.author;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import staporpaulina.projectAcc.book.Book;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    @ManyToMany
    @JoinTable(name = "author_books")
    private Set<Book> books;

}
