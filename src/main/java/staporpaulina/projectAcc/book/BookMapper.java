package staporpaulina.projectAcc.book;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {
BookMapper INSTANCE= Mappers.getMapper(BookMapper.class);
@Mapping(source = "title", target = "title")
@Mapping(source = "pages", target = "pages")
@Mapping(source = "description", target = "description")
@Mapping(source = "dateOfPublication", target = "dateOfPublication")
@Mapping(source = "author", target = "author")
Book bookDTOToBook (BookDTO bookDTO);

}
