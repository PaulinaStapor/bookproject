package staporpaulina.projectAcc.book;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import staporpaulina.projectAcc.author.AuthorRepository;

import java.util.List;

@RestController
public class BookController {

    private BookService bookService;
    private BookMapper bookMapper;
    private AuthorRepository authorRepository;

    public BookController(BookService bookService, AuthorRepository authorRepository) {
        this.bookService = bookService;
        this.authorRepository = authorRepository;
        this.bookMapper = BookMapper.INSTANCE;
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public List<Book> booksOnConsole() {
        return bookService.showAllBooks();
    }

    @RequestMapping(value = "/books/{title}/{pages}/{description}/{dateOfPublication}/{isbn}/{authorLastName}", method = RequestMethod.POST)
    public void addBook(@PathVariable String title,
                        @PathVariable Long pages,
                        @PathVariable String description,
                        @PathVariable String dateOfPublication,
                        @PathVariable String isbn,
                        @PathVariable String authorLastName) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setTitle(title);
        bookDTO.setPages(pages);
        bookDTO.setDescription(description);
        bookDTO.setDateOfPublication(dateOfPublication);
        bookDTO.setIsbn(isbn);


        bookService.addNewBook(bookDTO, authorLastName);
    }

    @RequestMapping(value = "/books/{title}", method = RequestMethod.GET)
    public List<Book> showBooks(@PathVariable String title) {
        return bookService.findBook(title);
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
    public void byeByeBook(@PathVariable Long id) {
        bookService.removeBook(id);
    }
}
