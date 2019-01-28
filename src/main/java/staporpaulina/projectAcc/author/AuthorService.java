package staporpaulina.projectAcc.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    //DODAWANIE AUTORA
    public void addNewAuthor(AuthorDTO authorDTO) {
        Author author = authorMapper.authorDTOToAuthor(authorDTO);
        authorRepository.save(author);
    }

    //USUWANIE AUTORA
    public void deleteAuthor(Long query) {
        Author author = authorRepository.findById(query).get();
        authorRepository.delete(author);
    }

    //SZUKANIE PO IMIENIU
    public List<Author> findAuthorByName(String query) {

        return authorRepository.findAuthorByFirstName(query);
    }

    //SZUKANIE PO NAZWISKU
    public Optional<Author> findAuthorBySurname(String query) {

        return authorRepository.findAuthorByLastName(query);
    }

    //WSZYSTCY AUTORZY
    public List<Author> showAllAuthors() {
        return authorRepository.findAll();
    }

    //SZUKANIE PO ID
    public ResponseEntity<Author> showOneAuthorById(Long id) {
        Optional<Author> authorById = authorRepository.findById(id);
        if (authorById.isPresent()) {
            return ResponseEntity.ok(authorById.get());
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }

}
