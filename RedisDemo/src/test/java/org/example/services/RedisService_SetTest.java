package org.example.services;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Order(2)
class RedisService_SetTest {
    static RedisService service = null;
    private String keyName = "Car#1";
    private String keyValue = "Renault";


    @org.junit.jupiter.api.BeforeAll
    static void setUp() {
        service = new RedisService("localhost", 6379);
    }

    @org.junit.jupiter.api.Test
    @Order(1)
    void addToSet() {
        boolean result = service.addToSet(keyName, keyValue);

        assert(result);
    }

    @org.junit.jupiter.api.Test
    @Order(2)
    void getValue() {
        String result = service.getValue(keyName);

        assert(result.equals(keyValue));
    }



}