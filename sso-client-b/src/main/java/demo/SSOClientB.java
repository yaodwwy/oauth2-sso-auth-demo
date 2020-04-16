package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
@SpringBootApplication
public class SSOClientB {

    public static void main(String[] args) {
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

}
