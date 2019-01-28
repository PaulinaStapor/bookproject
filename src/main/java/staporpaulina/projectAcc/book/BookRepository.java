package staporpaulina.projectAcc.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository <Book, Long> {

    @Query("SELECT b FROM Book b ORDER BY b.dateOfPublication")
    List<Book> findAll();

    @Query("SELECT b FROM Book b WHERE b.title LIKE %?1%")
    Optional<Book> findBookByTitle (String query);


}
