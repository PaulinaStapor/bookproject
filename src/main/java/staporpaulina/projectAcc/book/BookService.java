package staporpaulina.projectAcc.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import staporpaulina.projectAcc.author.Author;
import staporpaulina.projectAcc.author.AuthorRepository;


import java.util.*;

@Service
public class BookService {
    private BookMapper bookMapper;
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private final Map<Long, Book> bookMap =Collections.synchronizedMap(new TreeMap<>());

    @Autowired
    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
        this.bookMapper = BookMapper.INSTANCE;
        this.bookRepository = bookRepository;
    }

    public void addNewBook(BookDTO bookDTO, String query) {
        Book book = bookMapper.bookDTOToBook(bookDTO);
        Author author = authorRepository.findAuthorByLastName(query).get();
        if(author == null){
            author=new Author();
            authorRepository.save(author);

        }
        book.setAuthor(author);
        bookRepository.save(book);
    }

//    public void removeBook(Long id) {
////        Book book=bookRepository.findById(id).get();
//        bookRepository.delete(bookRepository.findById(id).get());
//    }
    public Book deleteBook(Long id){

        return bookMap.remove(id);
    }

    public List<Book> showAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> findBook(String query) {
        return bookRepository.findBookByTitle(query);
    }

    public  ResponseEntity<Book>showOneBookById(Long id){
        Optional<Book>bookById=bookRepository.findById(id);
        if(bookById.isPresent()){
            return ResponseEntity.ok(bookById.get());
        }else {
            return ResponseEntity.status(404).body(null);
        }
        }

}
