package org.example.services;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Order(2)
class RedisService_SetTest {
    static RedisService service = null;

    private static HashMap<String, String> hashMap = new HashMap<>();

    @org.junit.jupiter.api.BeforeAll
    static void setUp() {
        service = new RedisService("localhost", 6379);

        hashMap.put("Car#1", "Renault");
        hashMap.put("Car#2", "Ford");
        hashMap.put("Car#3", "Skoda");
        hashMap.put("Car#4", "Volkswagon");
        hashMap.put("Car#5", "Audi");
    }

    @org.junit.jupiter.api.Test
    @Order(1)
    void addToSet() {
        List<Boolean> listOfResults = new ArrayList<Boolean>();

        for(Map.Entry<String, String> entry : hashMap.entrySet()) {
            boolean result = service.addToSet(entry.getKey(), entry.getValue());

            listOfResults.add(result);
        }

        assert(!listOfResults.contains(false));
    }

    @org.junit.jupiter.api.Test
    @Order(2)
    void getValue() {
        List<Boolean> listOfResults = new ArrayList<Boolean>();

        for(Map.Entry<String, String> entry : hashMap.entrySet()) {

            String result = service.getValue(entry.getKey());

            listOfResults.add(result.equals(entry.getValue()));
        }

        assert(!listOfResults.contains(false));
    }



}