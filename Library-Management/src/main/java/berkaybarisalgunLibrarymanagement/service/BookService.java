package berkaybarisalgunLibrarymanagement.service;

import berkaybarisalgunLibrarymanagement.dto.BookDto;

import java.util.List;

public interface BookService {
    List<BookDto> findAllBooks();
}
