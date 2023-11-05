//atitaya promlers 6410406924
package ku.cs.aom_product.controller;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AuthController {


    @GetMapping("/login")
    public String loginView() {
        return "login"; // return login.html
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request,
                         HttpServletResponse response,
                         Authentication auth) {


        if (auth != null){
            new SecurityContextLogoutHandler()
                    .logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }
}
