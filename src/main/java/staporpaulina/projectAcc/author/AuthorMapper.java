package staporpaulina.projectAcc.author;

import org.mapstruct.Mapper;

import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthorMapper {
AuthorMapper INSTANCE= Mappers.getMapper(AuthorMapper.class);


Author authorDTOToAuthor(AuthorDTO authorDTO);



}
