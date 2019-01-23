package staporpaulina.projectAcc.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    private AuthorMapper authorMapper;
    private AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorMapper = AuthorMapper.INSTANCE;
        this.authorRepository = authorRepository;
    }

    public void addNewAuthor(AuthorDTO authorDTO) {
        Author author = authorMapper.authorDTOToAuthor(authorDTO);
        authorRepository.save(author);
    }


    public void deleteAuthor(Long query) {
        Author author = authorRepository.findById(query).get();
        authorRepository.delete(author);
    }

    public List<Author> findAuthorByName(String query) {
        return authorRepository.findAuthorByFirstName(query);
    }

    public Optional<Author> findAuthorBySurname(String query) {
        return authorRepository.findAuthorByLastName(query);
    }

    public List<Author> showAllAuthors() {
        return authorRepository.findAll();
    }

}
