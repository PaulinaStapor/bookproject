package staporpaulina.projectAcc.author;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@Entity
@DatabaseTable(tableName = "AUTHOR")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @DatabaseField(generatedId = true, columnName = "author_id", canBeNull = false, foreignAutoRefresh = true, foreignAutoCreate = true)
    private Long id;
    @DatabaseField(columnName = "author_name", canBeNull = false)
    private String firstName;
    @DatabaseField(columnName = "author_surname", canBeNull = false)
    private String lastName;
    @DatabaseField(columnName = "author_virth_date")
    private Date dateOfBirth;

}
