package berkaybarisalgunLibrarymanagement.controller;

import berkaybarisalgunLibrarymanagement.config.UserInfoUserDetails;
import berkaybarisalgunLibrarymanagement.dto.BookDto;
import berkaybarisalgunLibrarymanagement.entity.UserInfo;
import berkaybarisalgunLibrarymanagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;
import java.util.List;

@Controller
public class CommonController {
    @Autowired
    private BookService bookService;


    public CommonController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping("/search")
    public String searchBooks(@RequestParam(name = "query") String query, Model model, Authentication authentication) {
        List<BookDto> books = bookService.searchBooks(query);
        model.addAttribute("books", books);
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        if (authorities.contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
            return "/admin/books";
        } else if (authorities.contains(new SimpleGrantedAuthority("ROLE_USER"))) {
            return "/user/books";
        } else {
            throw new IllegalStateException("Unknown user role");
        }

    }


}
