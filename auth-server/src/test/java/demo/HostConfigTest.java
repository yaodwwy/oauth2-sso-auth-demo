package demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HostConfigTest {

    @Test
    void checkHostExists() {
        HostConfig.checkHostExists("127.0.0.1","sso-client-a");
    }
}