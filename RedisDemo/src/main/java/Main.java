import redis.clients.jedis.Jedis;

public class Main {
    private static RedisService service = new RedisService("localhost", 6379);

    public static void main(String[] args) {
        System.out.println("Hello, World!");

        testRedis();
    }

    public static void testRedis() {
        Boolean result = service.addToSet("Bike:1", "Rosebud");

        if (result) {
            System.out.println(service.getValue("Bike:1"));
        }
    }



}
