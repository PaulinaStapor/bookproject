package staporpaulina.projectAcc.author;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthorMapper {
AuthorMapper INSTANCE= Mappers.getMapper(AuthorMapper.class);

//@Mapping(target = "firstName", source = "firstName")
//@Mapping(target = "lastName", source= "lastName")
//@Mapping(target = "dateOfBirth", source = "dateOfBirth")
Author authorDTOToAuthor(AuthorDTO authorDTO);
//void authorDTOToAuthor(AuthorDTO source, @MappingTarget Author target);


}
