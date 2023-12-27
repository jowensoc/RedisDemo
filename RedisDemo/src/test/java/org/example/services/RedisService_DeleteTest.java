package org.example.services;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Order(99)
public class RedisService_DeleteTest {

    static RedisService service = null;
    private String keyName = "Car#1";
    private String hashSetKeyName = "Contractor#1";

    @org.junit.jupiter.api.BeforeAll
    static void setUp() {
        service = new RedisService("localhost", 6379);
    }

    @org.junit.jupiter.api.Test
    @Order(1)
    void deleteByKeyname() {
        boolean result = service.deleteByKeyname(keyName);

        assert(result);
    }

    @org.junit.jupiter.api.Test
    @Order(2)
    void deleteByHashSetKeyname() {
        boolean result = service.deleteByKeyname(hashSetKeyName);

        assert(result);
    }

    @org.junit.jupiter.api.Test
    @Order(3)
    void attemptToDeleteNonExistentKey() {
        boolean result = service.deleteByKeyname("FakeKeyName");

        assert(!result);
    }
    @org.junit.jupiter.api.Test
    @Order(99)
    void flushDB() {
        String result = service.flushDB();

        assertNotNull(result);
    }

}
