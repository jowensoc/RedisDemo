package org.example.services;

import java.util.Set;

class RedisService_SetTest {
    static RedisService service = null;
    private String keyName = "Car#1";
    private String keyValue = "Renault";


    @org.junit.jupiter.api.BeforeAll
    static void setUp() {
        service = new RedisService("localhost", 6379);
    }

    @org.junit.jupiter.api.Test
    void addToSet() {
        Boolean result = service.addToSet(keyName, keyValue);

        assert(result);
    }

    @org.junit.jupiter.api.Test
    void getValue() {
        String result = service.getValue(keyName);

        assert(result.equals(keyValue));
    }


}