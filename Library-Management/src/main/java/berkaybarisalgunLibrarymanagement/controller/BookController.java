package berkaybarisalgunLibrarymanagement.controller;

import berkaybarisalgunLibrarymanagement.dto.BookDto;
import berkaybarisalgunLibrarymanagement.service.BookService;
import berkaybarisalgunLibrarymanagement.service.impl.BookServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/admin/books")
    public String books(Model model){
        List<BookDto> books=bookService.findAllBooks();
        model.addAttribute("books",books);
        return "/admin/books";
    }
}
