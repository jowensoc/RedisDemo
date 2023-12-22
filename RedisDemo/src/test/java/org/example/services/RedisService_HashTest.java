package org.example.services;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.*;

class RedisService_HashTest {
    static RedisService service = null;
    private String keyName = "Contractor#1";
    private static HashMap<String, String> keyValues = null;

    @BeforeAll
    static void setUp() {
        service = new RedisService("localhost", 6379);

        keyValues = new HashMap<String, String>();
        keyValues.put("FullName", "Emily Freeman");
        keyValues.put("Role", "Programmer");
        keyValues.put("Salary", "£42,000");
        keyValues.put("Department", "I.T.");

    }

    @Test
    void addToHashSet() {

        List<Boolean> listOfResults = new ArrayList<Boolean>();

        for (Map.Entry<String, String> entry : keyValues.entrySet()) {
            Boolean result = service.addToHashSet(keyName, entry.getKey(), entry.getValue());

            listOfResults.add(result);

            if (result) {
                System.out.println("Added Key: " + entry.getKey());
                System.out.print("Value for key '" + entry.getValue() + "': ");
                System.out.println(service.getValue(entry.getKey()));
            }
        }

        assert(!listOfResults.contains(false));
    }

    @Test
    void getHashSet() {
        System.out.println(keyName);
        Map<String, String> currentList = service.getHashSet(keyName);

        //assert(!currentList.isEmpty());

        for (Map.Entry<String, String> entry : currentList.entrySet()) {
            System.out.print("Field: " + entry.getKey() + ". ");
            System.out.print("Value: " + entry.getValue());
            System.out.println(" ");
        }

        //assert(currentList.size() == keyValues.size());

    }
}