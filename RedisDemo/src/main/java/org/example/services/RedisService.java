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

    public boolean deleteByKeyname(String keyName) {
        long status = jedis.del(keyName);

        System.out.println("Deleted Key Status:" + status);

        return (status > 0);
    }

    public boolean deleteByHashSetKeyname(String keyName) {
        Long status = jedis.del(keyName);

        return (status > 0);
    }

    public Set<String> getValues(String keyName) {
        return jedis.smembers(keyName);
    }

    public Boolean addToHashSet(String keyName, String fieldName, String val) {
        long status = jedis.hset(keyName, fieldName, val);

        System.out.println("HashSet Add Status: " + status);

        return (status > 0);
    }

    public Map<String, String> getHashSet(String keyName) {
        return jedis.hgetAll(keyName);
    }

    public String flushDB() {
        return jedis.flushAll();
    }
}
