package berkaybarisalgunLibrarymanagement.controller;

import berkaybarisalgunLibrarymanagement.dto.BookDto;
import berkaybarisalgunLibrarymanagement.entity.Book;
import berkaybarisalgunLibrarymanagement.service.BookService;
import berkaybarisalgunLibrarymanagement.service.impl.BookServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("admin/delete")
    public String deleteBook(@RequestParam("bookId") int bookId){
        bookService.deleteBookById(bookId);
        return "redirect:/admin/books";
    }

    @GetMapping("admin/edit/{id}")
    public String editBookForm(@PathVariable("id") int id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "admin/edit";
    }

    @PostMapping("admin/edit")
    public String editBook(@ModelAttribute("book") Book book) {
        bookService.updateBook(book);
        return "redirect:/admin/books";
    }

}
