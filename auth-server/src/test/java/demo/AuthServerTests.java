package demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Slf4j
class AuthServerTests {

    @Test
    void contextLoads() {
        log.debug(new BCryptPasswordEncoder().encode("test"));
    }

}
