import redis.clients.jedis.Jedis;
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

}
