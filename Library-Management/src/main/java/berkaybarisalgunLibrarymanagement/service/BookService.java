package berkaybarisalgunLibrarymanagement.service;

import berkaybarisalgunLibrarymanagement.dto.BookDto;
import berkaybarisalgunLibrarymanagement.entity.Book;

import java.util.List;

public interface BookService {
    List<BookDto> findAllBooks();
    void deleteBookById(int id);

    void updateBook(Book book);

    Book getBookById(int id);
}
