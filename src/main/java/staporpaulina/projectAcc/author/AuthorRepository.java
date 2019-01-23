package staporpaulina.projectAcc.author;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT a FROM Author a ORDER BY a.dateOfBirth")
    List<Author> findAll();

    @Query("SELECT a FROM Author a WHERE a.firstName LIKE %?1% ORDER BY a.dateOfBirth")
    List<Author> findAuthorByFirstName(String query);
    @Query("SELECT a FROM Author a WHERE a.lastName LIKE %?1% ORDER BY a.dateOfBirth")
    Optional<Author> findAuthorByLastName(String query);
}
