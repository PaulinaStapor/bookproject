package staporpaulina.projectAcc.book;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
public class BookDTO {
    private String title;
    private Long pages;
    private String description;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String dateOfPublication;
    private String isbn;
//    private Author author;
}
