package berkaybarisalgunLibrarymanagement.service.impl;

import berkaybarisalgunLibrarymanagement.dto.BookDto;
import berkaybarisalgunLibrarymanagement.entity.Book;
import berkaybarisalgunLibrarymanagement.mapper.BookMapper;
import berkaybarisalgunLibrarymanagement.repository.BookRepository;
import berkaybarisalgunLibrarymanagement.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;
    private BookMapper bookMapper;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public List<BookDto> findAllBooks() {
        List<Book> books=bookRepository.findAll();
        return books.stream().map(BookMapper::mapToBookDto).collect(Collectors.toList());

    }
}
