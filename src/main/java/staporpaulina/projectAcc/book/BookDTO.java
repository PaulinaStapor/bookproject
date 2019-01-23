package staporpaulina.projectAcc.book;

import lombok.Getter;
import lombok.Setter;
import staporpaulina.projectAcc.author.Author;

import javax.persistence.ManyToOne;
import java.util.Date;
@Getter
@Setter
public class BookDTO {
    private String title;
    private Long pages;
    private String description;
    private Date dateOfPublication;
    private String isbn;
    private Author author;
}
