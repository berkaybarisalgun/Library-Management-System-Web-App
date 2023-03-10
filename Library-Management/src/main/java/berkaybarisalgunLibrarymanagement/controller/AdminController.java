package berkaybarisalgunLibrarymanagement.controller;

import berkaybarisalgunLibrarymanagement.dto.BookDto;
import berkaybarisalgunLibrarymanagement.entity.Book;
import berkaybarisalgunLibrarymanagement.entity.UserInfo;
import berkaybarisalgunLibrarymanagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private BookService bookService;

    public AdminController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/admin/books")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String books(Model model){
        List<BookDto> books=bookService.findAllBooks();
        model.addAttribute("books",books);
        return "/admin/books";
    }

    @PostMapping("/new")
    public String addNewUser(@RequestBody UserInfo userInfo){
        return bookService.addUser(userInfo);
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
