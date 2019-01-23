package staporpaulina.projectAcc.book;

import lombok.Getter;
import lombok.Setter;
import staporpaulina.projectAcc.author.Author;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Long pages;
    @Column(length = 400)
    private String description;
    private Date dateOfPublication;
    @ManyToOne
    private Author author;

}
