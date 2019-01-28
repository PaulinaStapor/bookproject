package staporpaulina.projectAcc.book;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import lombok.Getter;
import lombok.Setter;
import staporpaulina.projectAcc.author.Author;

import javax.persistence.*;

@Getter
@Setter
@Entity
@DatabaseTable(tableName = "BOOKS")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @DatabaseField(generatedId = true, columnName = "book_id", canBeNull = false, foreignAutoRefresh = true, foreignAutoCreate = true)
    private Long id;
    @DatabaseField(columnName = "book_title", canBeNull = false)
    private String title;
    @DatabaseField(columnName = "number_of_pages")
    private Long pages;
    @Column(length = 400)
    @DatabaseField(columnName = "description")
    private String description;
    @DatabaseField(columnName = "date_of_publication", canBeNull = false, dataType = DataType.STRING)
    private String dateOfPublication;
    @DatabaseField(columnName = "ISBN_number", canBeNull = false, unique = true)
    private String isbn;
    @ManyToOne
    private Author author;

}
