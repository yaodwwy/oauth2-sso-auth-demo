package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
@SpringBootApplication
public class SSOClientA {

    public static void main(String[] args) {
        SpringApplication.run(SSOClientA.class, args);
    }

    @RequestMapping({"/"})
    public String main() {
        return "index";
    }

    @ResponseBody
    @RequestMapping("/user")
    public Principal root(Principal principal) {
        return principal;
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:http://auth-server/logout";
    }
}
