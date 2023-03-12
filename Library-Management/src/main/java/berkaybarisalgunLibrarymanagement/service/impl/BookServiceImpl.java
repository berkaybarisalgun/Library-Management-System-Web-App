package berkaybarisalgunLibrarymanagement.service.impl;

import berkaybarisalgunLibrarymanagement.dto.BookDto;
import berkaybarisalgunLibrarymanagement.entity.Book;
import berkaybarisalgunLibrarymanagement.entity.UserInfo;
import berkaybarisalgunLibrarymanagement.mapper.BookMapper;
import berkaybarisalgunLibrarymanagement.repository.BookRepository;
import berkaybarisalgunLibrarymanagement.repository.UserInfoRepository;
import berkaybarisalgunLibrarymanagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;
    private BookMapper bookMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserInfoRepository repository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public List<BookDto> findAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream().map(BookMapper::mapToBookDto).collect(Collectors.toList());

    }

    @Override
    public void deleteBookById(int id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Book getBookById(int id) {
        return bookRepository.findById(id).get();

    }

    public String addUser(UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        repository.save(userInfo);
        return "user added to system";
    }

    @Override
    public List<BookDto> searchBooks(String query) {
        List<Book> allBooks = bookRepository.findAll();
        List<Book> matchedBooks = new ArrayList<>();

        for (Book book : allBooks) {
            if (book.getTitle().toLowerCase().contains(query.toLowerCase())) {
                matchedBooks.add(book);
            }
        }
        return matchedBooks.stream().map(BookMapper::mapToBookDto).collect(Collectors.toList());

    }


}
