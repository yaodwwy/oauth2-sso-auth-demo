package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
@SpringBootApplication
public class SSOClientB {

    public static void main(String[] args) {
        HostConfig.checkHostExists("127.0.0.1","sso-client-b");
        SpringApplication.run(SSOClientB.class, args);
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
