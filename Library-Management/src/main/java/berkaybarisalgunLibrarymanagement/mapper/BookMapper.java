package berkaybarisalgunLibrarymanagement.mapper;

import berkaybarisalgunLibrarymanagement.dto.BookDto;
import berkaybarisalgunLibrarymanagement.entity.Book;

public class BookMapper {
    public static BookDto mapToBookDto(Book book) {
        return BookDto.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .page_count(book.getPage_count())
                .language(book.getLanguage())
                .genre(book.getGenre())
                .location_on_shelf(book.getLocation_on_shelf())
                .stock(book.getStock())
                .build();
    }

    public static Book mapToBook(BookDto bookDto) {
        return Book.builder()
                .id(bookDto.getId())
                .title(bookDto.getTitle())
                .author(bookDto.getAuthor())
                .page_count(bookDto.getPage_count())
                .language(bookDto.getLanguage())
                .genre(bookDto.getGenre())
                .location_on_shelf(bookDto.getLocation_on_shelf())
                .stock(bookDto.getStock())
                .build();
    }

}
