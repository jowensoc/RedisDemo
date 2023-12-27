package org.example.services;

import org.junit.jupiter.api.*;

import java.util.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Order(1)
class RedisService_HashTest {
    static RedisService service = null;
    private String keyName = "Contractor#1";
    private static HashMap<String, String> keyValues = null;

    @BeforeAll
    static void setUp() {
        service = new RedisService("localhost", 6379);

        keyValues = new HashMap<String, String>();
        keyValues.put("FullName", "Gordon Freeman");
        keyValues.put("Role", "Programmer");
        keyValues.put("Salary", "£42,000");
        keyValues.put("Department", "I.T.");
        keyValues.put("Project", "Halflife");

    }

    @Test
    @Order(1)
    void addToHashSet() {
        System.out.println("1");
        List<Boolean> listOfResults = new ArrayList<Boolean>();

        for (Map.Entry<String, String> entry : keyValues.entrySet()) {
            boolean result = service.addToHashSet(keyName, entry.getKey(), entry.getValue());

            listOfResults.add(result);

            System.out.println("Added ? " + result);

            if (result) {
                System.out.println("Added Key: " + entry.getKey());
                System.out.println("Value for key '" + entry.getValue() + "': ");
            }
        }

        assert(!listOfResults.contains(false));
    }


}