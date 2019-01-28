package staporpaulina.projectAcc.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import staporpaulina.projectAcc.author.AuthorRepository;

import javax.validation.constraints.Min;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@Controller
public class BookController {

    private BookService bookService;
    private BookMapper bookMapper;
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;


    @Autowired
    public BookController(BookService bookService, AuthorRepository authorRepository, BookRepository bookRepository) {
        this.bookService = bookService;
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.bookMapper = BookMapper.INSTANCE;
    }

    //WSZYSTKIE KSIAZKI
    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public List<Book> booksOnConsole() {

        return bookService.showAllBooks();
    }


    //DODAWANIE KSIAZKI
    @RequestMapping(value = "/books", method = RequestMethod.POST, produces = APPLICATION_JSON_VALUE)
    public void addBook(@RequestBody BookDTO bookDTO, String authorLastName) {

        bookService.addNewBook(bookDTO, authorLastName);
    }


    //SZUKANIE PO TYULE
    @RequestMapping(value = "/books/{title}", method = RequestMethod.GET)
    public Optional<Book> showBooks(@PathVariable String title) {
        return bookService.findBook(title);
    }

    //SZUKANIE PO ID
    @RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
    public ResponseEntity<Book> showOneBook(@PathVariable Long id) {
        return bookService.showOneBookById(id);
    }


    //USUWANIE
    @RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteBook(@PathParam("id") @Min(0) Long id) {
        Book book = bookService.deleteBook(id);
        if (book != null) {
            return ResponseEntity.ok(book);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
//    @RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
//    public void byeByeBook(@PathVariable @Min(0) Long id) {
//        bookService.removeBook(id);
//    }
//    @RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
//    public ResponseEntity deleteBook(@PathParam("id")@Min(0) Long id){
//        Book book=bookRepository.findById(id).get();
//        if(book!=null){
//            bookService.deleteBook(id);
//            return ResponseEntity.ok(book);
//        }
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//    }


}
