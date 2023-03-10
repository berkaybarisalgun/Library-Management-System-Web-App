package berkaybarisalgunLibrarymanagement.LoginController;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
public class CommonLoginController {

    @GetMapping("/")
    public String welcome(Authentication authentication) {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        if (authorities.contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
            return "redirect:/admin/welcome";
        } else if (authorities.contains(new SimpleGrantedAuthority("ROLE_USER"))) {
            return "redirect:/user/welcome";
        } else {
            throw new IllegalStateException("Unknown user role");
        }
    }
    /*
    @GetMapping("/")
    public String gotoLoginPageCommon(){
        return "/common/welcome";
    }

     */

}
