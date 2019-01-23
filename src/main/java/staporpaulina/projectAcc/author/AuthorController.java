package staporpaulina.projectAcc.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

//localhost:8080/swagger-ui
@RestController
public class AuthorController {

    private AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @RequestMapping(value = "/authors", method = RequestMethod.GET)
    public List<Author> authorsOnConsole() {
        return authorService.showAllAuthors();
    }

    @RequestMapping(value = "/authors/{firstName}/{lastName}/{dateOfBirth}", method = RequestMethod.POST)
    public void addAuthor(@PathVariable String firstName, @PathVariable String lastName, @PathVariable Date dateOfBirth) {
        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setFirstName(firstName);
        authorDTO.setLastName(lastName);
        authorDTO.setDateOfBirth(dateOfBirth);
        authorService.addNewAuthor(authorDTO);
    }

    @RequestMapping(value = "/authors/{id}", method = RequestMethod.DELETE)
    public void byeAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
    }
}
