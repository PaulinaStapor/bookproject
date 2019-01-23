package staporpaulina.projectAcc.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

//localhost:8080/swagger-ui
@RestController
public class AuthorController {

    private AuthorService authorService;
    private AuthorMapper authorMapper;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @RequestMapping(value = "/authors", method = RequestMethod.GET)
    public List<Author> authorsOnConsole() {
        return authorService.showAllAuthors();
    }

    @RequestMapping(value = "/authors/{firstName}/{lastName}/{dateOfBirth}", method = RequestMethod.POST)
    public void addAuthor(@PathVariable String firstName, @PathVariable String lastName, @PathVariable String dateOfBirth) {
        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setFirstName(firstName);
        authorDTO.setLastName(lastName);
        authorDTO.setDateOfBirth(dateOfBirth);
//        Author author=authorMapper.authorDTOToAuthor(authorDTO);
        authorService.addNewAuthor(authorDTO);
    }

    @RequestMapping(value = "/authors/{firstName}", method = RequestMethod.GET)
    public List<Author> showAuthors(@PathVariable String firstName) {
        return authorService.findAuthorByName(firstName);
    }

    @RequestMapping(value = "/authors/{id}", method = RequestMethod.DELETE)
    public void byeAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
    }

}
