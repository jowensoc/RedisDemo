package org.example.services;

import org.junit.jupiter.api.*;

import java.util.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Order(1)
class RedisService_HashTest {
    static RedisService service = null;
    private static List<String> listOfKeyNames = new ArrayList<String>();
    private static Hashtable<String, HashMap<String, String>> hashTable = null;

    @BeforeAll
    static void setUp() {
        service = new RedisService("localhost", 6379);

        String keyName = "";

        hashTable = new Hashtable<String, HashMap<String, String>>();

        HashMap<String, String> keyValues = new HashMap<>();

        // CONTRACTOR 1
        keyName = "Contractor#1";
        keyValues = new HashMap<String, String>();
        keyValues.put("FullName", "Gordon Freeman");
        keyValues.put("Role", "Programmer");
        keyValues.put("Salary", "£42,000");
        keyValues.put("Department", "I.T.");
        keyValues.put("Project", "Halflife");

        hashTable.put(keyName, keyValues);
        listOfKeyNames.add(keyName);

        // CONTRACTOR 2
        keyName = "Contractor#2";
        keyValues = new HashMap<String, String>();
        keyValues.put("FullName", "Jimminy Cricket");
        keyValues.put("Role", "Solution Architect");
        keyValues.put("Salary", "£65,000");
        keyValues.put("Department", "Product Delivery");
        keyValues.put("Project", "Oregon");

        hashTable.put(keyName, keyValues);
        listOfKeyNames.add(keyName);

        // CONTRACTOR 3
        keyName = "Contractor#3";
        keyValues = new HashMap<String, String>();
        keyValues.put("FullName", "Jacqueline Georges");
        keyValues.put("Role", "Senior Interaction Designer");
        keyValues.put("Salary", "£65,000");
        keyValues.put("Department", "UCD");
        keyValues.put("Project", "Georgina");

        hashTable.put(keyName, keyValues);
        listOfKeyNames.add(keyName);


    }

    @Test
    @Order(1)
    void addToHashSet() {
        List<Boolean> listOfResults = new ArrayList<Boolean>();

        for (Map.Entry<String, HashMap<String, String>> entry: hashTable.entrySet()) {
            for(Map.Entry<String, String> currentField : entry.getValue().entrySet()) {
                boolean result = service.addToHashSet(entry.getKey(), currentField.getKey(), currentField.getValue());

                listOfResults.add(result);

                System.out.println("Added ? " + result);

                if (result) {
                    System.out.println("Added Key: " + entry.getKey());
                    System.out.println("Value for key '" + entry.getValue() + "': ");
                }
            }
        }

        assert(!listOfResults.contains(false));
    }

    @Test
    @Order(2)
    void getValuesFromHashSet() {

        List<Boolean> listOfResults = new ArrayList<Boolean>();

        for(String keyName : listOfKeyNames) {
            Map<String, String> results = service.getHashSet(keyName);

            listOfResults.add(!results.isEmpty());

            for (Map.Entry<String, String> entry : results.entrySet()) {
                System.out.print("Key: " + entry.getKey() + ". ");
                System.out.print("Value: '" + entry.getValue() + "'");
                System.out.println(" ");
            }
        }

        assert(!listOfResults.contains(false));
    }


}