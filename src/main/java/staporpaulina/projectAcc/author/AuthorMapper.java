package staporpaulina.projectAcc.author;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthorMapper {
AuthorMapper INSTANCE= Mappers.getMapper(AuthorMapper.class);
@Mapping(source = "firstName", target = "firstName")
@Mapping(source = "lastName", target = "lastName")
@Mapping(source = "dateOfBirth", target = "dateOfBirth")
AuthorDTO authorToAuthorDTO(Author author);


}
