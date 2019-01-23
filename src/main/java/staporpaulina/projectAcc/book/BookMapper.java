package staporpaulina.projectAcc.book;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    @Mappings({
            @Mapping(target = "title", source = "bookDTO.title"),
            @Mapping(target = "pages", source = "bookDTO.pages"),
            @Mapping(target = "description", source = "bookDTO.description"),
            @Mapping(target = "dateOfPublication", source = "bookDTO.dateOfPublication"),
            @Mapping(target = "author", source = "bookDTO.author")
    })
    Book bookDTOToBook(BookDTO bookDTO);

}
