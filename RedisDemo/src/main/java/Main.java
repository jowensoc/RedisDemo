import redis.clients.jedis.Jedis;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello, World!");

        testRedis();
    }

    public static void testRedis() {
        Jedis jedis = new Jedis("localhost", 6379);

        String status = jedis.set("Bike:1", "Rosebud");

        if (status.contains("OK")) {
            System.out.println("Save data");
        } else {
            System.out.println("Didn't save data");
        }
    }

}
