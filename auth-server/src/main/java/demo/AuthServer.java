package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
@SpringBootApplication
public class AuthServer {

    public static void main(String[] args) {
        HostConfig.checkHostExists("127.0.0.1","auth-server");
        SpringApplication.run(AuthServer.class, args);
    }

    @RequestMapping("/")
    public String root() {
        return "redirect:/actuator/health";
    }

    @ResponseBody
    @RequestMapping("/me")
    public Principal root(Principal principal) {
        return principal;
    }
}
