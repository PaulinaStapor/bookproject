package staporpaulina.projectAcc.book;

import staporpaulina.projectAcc.author.Author;

import javax.persistence.ManyToOne;
import java.util.Date;

public class BookDTO {
    private String title;
    private Long pages;
    private String description;
    private Date dateOfPublication;

    private Author author;
}
