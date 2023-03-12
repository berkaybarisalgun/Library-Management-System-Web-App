package berkaybarisalgunLibrarymanagement.controller;

import berkaybarisalgunLibrarymanagement.dto.BookDto;
import berkaybarisalgunLibrarymanagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private BookService bookService;

    public UserController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/user/books")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String books(Model model) {
        List<BookDto> books = bookService.findAllBooks();
        model.addAttribute("books", books);
        return "/user/books";
    }


}
