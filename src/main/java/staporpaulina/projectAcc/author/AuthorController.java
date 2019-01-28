package staporpaulina.projectAcc.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

import java.util.List;
import java.util.Optional;

//localhost:9090/swagger-ui.html
@RestController
public class AuthorController {

    private AuthorService authorService;


    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    //WSZYSCY AUTORZY
    @RequestMapping(value = "/authors", method = RequestMethod.GET)
    public List<Author> authorsOnConsole() {
        return authorService.showAllAuthors();
    }

    //DODAWANIE AUTORA
    @RequestMapping(value = "/authors", method = RequestMethod.POST, produces = APPLICATION_JSON_VALUE)
    public void addAuthor(@RequestBody AuthorDTO authorDTO) {
        authorService.addNewAuthor(authorDTO);
    }

    //SZUKANIE PO IMIENIU
    @RequestMapping(value = "/authors/{firstName}", method = RequestMethod.GET)
    public List<Author> showAuthors(@PathVariable String firstName) {
        return authorService.findAuthorByName(firstName);
    }

    //SZUKANIE PO NAZWISKU
    @RequestMapping(value = "/authors/{lastName}", method = RequestMethod.GET)
    public Optional<Author> findAuthorsByAuthorsLastName(@PathVariable String lastName) {
        return authorService.findAuthorBySurname(lastName);
    }
//    SZUKANIE PO ID
    @RequestMapping(value = "/authors/{id}", method = RequestMethod.GET)
    public ResponseEntity<Author> showAuthorById(@PathVariable Long id){
        return authorService.showOneAuthorById(id);
    }

    //USUWANIE
    @RequestMapping(value = "/authors/{id}", method = RequestMethod.DELETE)
    public void byeAuthor(@PathVariable Long id) {

        authorService.deleteAuthor(id);
    }

}
