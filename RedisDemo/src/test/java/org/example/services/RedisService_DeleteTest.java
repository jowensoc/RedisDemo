package org.example.services;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Order(99)
public class RedisService_DeleteTest {

    static RedisService service = null;
    private static ArrayList<String> listofKeyNames = new ArrayList<String>();
    private static ArrayList<String> listofHashsetKeyNames = new ArrayList<String>();

    @org.junit.jupiter.api.BeforeAll
    static void setUp() {
        service = new RedisService("localhost", 6379);

        listofKeyNames.add("Car#1");
        listofKeyNames.add("Car#2");
        listofKeyNames.add("Car#3");
        listofKeyNames.add("Car#4");
        listofKeyNames.add("Car#5");

        listofHashsetKeyNames.add("Contractor#1");
        listofHashsetKeyNames.add("Contractor#2");
        listofHashsetKeyNames.add("Contractor#3");

    }

    @org.junit.jupiter.api.Test
    @Order(1)
    void deleteByKeynames() {
        List<Boolean> listOfResults = new ArrayList<Boolean>();

        for(String keyName : listofKeyNames) {
            boolean result = service.deleteByKeyname(keyName);

            listOfResults.add(result);
        }

        assert(!listOfResults.contains(false));
    }

    @org.junit.jupiter.api.Test
    @Order(2)
    void deleteByHashSetKeyname() {
        List<Boolean> listOfResults = new ArrayList<Boolean>();

        for(String keyName : listofHashsetKeyNames) {
            boolean result = service.deleteByKeyname(keyName);

            listOfResults.add(result);
        }

        assert(!listOfResults.contains(false));
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
