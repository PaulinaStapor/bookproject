package staporpaulina.projectAcc.book;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import staporpaulina.projectAcc.author.Author;


import java.util.Date;
@Getter
@Setter
public class BookDTO {
    private String title;
    private Long pages;
    private String description;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String dateOfPublication;
    private String isbn;
    private Author author;
}
