package org.example.services;

import redis.clients.jedis.Jedis;

import java.util.Map;
import java.util.Set;

public class RedisService {
    private Jedis jedis = null;

    public RedisService(String hostName, int portNumber) {
        jedis = new Jedis(hostName, portNumber);
    }

    public Boolean addToSet(String keyName, String val) {
        String status = jedis.set(keyName, val);

        return status.contains("OK");
    }

    public String getValue(String keyName) {
        return jedis.get(keyName);
    }

    public Set<String> getValues(String keyName) {
        return jedis.smembers(keyName);
    }

    public Boolean addToHashSet(String keyName, String fieldName, String val) {
        Long status = jedis.hset(keyName, fieldName, val);

        return (status == 0);
    }

    public Map<String, String> getHashSet(String keyName) {
        return jedis.hgetAll(keyName);
    }
}
