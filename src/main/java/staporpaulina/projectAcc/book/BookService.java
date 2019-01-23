package staporpaulina.projectAcc.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import staporpaulina.projectAcc.author.Author;
import staporpaulina.projectAcc.author.AuthorRepository;

import javax.validation.constraints.Size;
import java.util.List;

@Service
public class BookService {
    private BookMapper bookMapper;
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    @Autowired
    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
        this.bookMapper = BookMapper.INSTANCE;
        this.bookRepository = bookRepository;
    }

    public void addNewBook(BookDTO bookDTO, String query) {
        Book book = bookMapper.bookDTOToBook(bookDTO);
//        Author author = authorRepository.findAuthorByLastName(query).get();
//        book.setAuthor(author);

        bookRepository.save(book);
    }

    public void removeBook(BookDTO bookDTO) {
        Book book = bookMapper.bookDTOToBook(bookDTO);
        bookRepository.delete(book);
    }

    public List<Book> showAllBooks() {
        return bookRepository.findAll();
    }

    public List<Book> findBook(String query) {
        return bookRepository.findBookByTitle(query);

    }


}
