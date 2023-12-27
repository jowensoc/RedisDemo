package org.example.app;

import redis.clients.jedis.Jedis;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import org.example.services.*;

public class Main {
    private static RedisService service = new RedisService("localhost", 6379);

    public static void main(String[] args) {
        System.out.println("Hello, World!");

        addDataToRedis();
        addHashSetToRedis();
    }

    public static void addDataToRedis() {
        HashMap<String, String> dictEntries = new HashMap<String, String>();

        dictEntries.put("Vehicle:1", "Rosebud");
        dictEntries.put("Vehicle:2", "Batmobile");
        dictEntries.put("Vehicle:3", "Delorean");
        dictEntries.put("Vehicle:4", "KITT");
        dictEntries.put("Vehicle:5", "Gray Rider");
        dictEntries.put("Vehicle:6", "Bumblebee");

        for (Map.Entry<String, String> entry : dictEntries.entrySet()) {
            Boolean result = service.addToSet(entry.getKey(), entry.getValue());

            if (result) {
                System.out.println("Added Key: " + entry.getKey());
                System.out.print("Value for key '" + entry.getValue() + "': ");
                System.out.println(service.getValue(entry.getKey()));
            }
        }

    }

    public static void addHashSetToRedis() {
        String keyName = "Employee#1";
        String fieldName = "FullName";
        String fieldValue = "Fred Bloggs";

        service.addToHashSet(keyName, fieldName, fieldValue);
        service.addToHashSet(keyName, "Role", "Software Engineer");
        service.addToHashSet(keyName, "Department", "Tech Support");

        Map<String,String> data = service.getHashSet(keyName);

        for (Map.Entry<String, String> entry : data.entrySet()) {
            System.out.print("FieldName: " + entry.getKey() + ". ");
            System.out.println("Value: '" + entry.getValue() + "'");
        }
    }

}
