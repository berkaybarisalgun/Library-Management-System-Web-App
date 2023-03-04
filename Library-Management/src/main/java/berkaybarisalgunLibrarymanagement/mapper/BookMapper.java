package berkaybarisalgunLibrarymanagement.mapper;

import berkaybarisalgunLibrarymanagement.dto.BookDto;
import berkaybarisalgunLibrarymanagement.entity.Book;

public class BookMapper {
    public static BookDto mapToBookDto(Book book){
        return BookDto.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .pageCount(book.getPageCount())
                .language(book.getLanguage())
                .genre(book.getGenre())
                .locationOnShelf(book.getLocationOnShelf())
                .stock(book.getStock())
                .build();
    }

    public static Book mapToBook(BookDto bookDto){
        return Book.builder()
                .id(bookDto.getId())
                .title(bookDto.getTitle())
                .author(bookDto.getAuthor())
                .pageCount(bookDto.getPageCount())
                .language(bookDto.getLanguage())
                .genre(bookDto.getGenre())
                .locationOnShelf(bookDto.getLocationOnShelf())
                .stock(bookDto.getStock())
                .build();
    }

}
