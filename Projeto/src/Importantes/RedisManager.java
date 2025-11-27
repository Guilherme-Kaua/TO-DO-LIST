package Importantes;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisManager {
    private static JedisPool jedisPool = new JedisPool("localhost", 6379);

    public static Jedis getConnection() {
        return jedisPool.getResource();
    }

    public static void salvarUsuario(String email, String nome) {
        try (Jedis jedis = getConnection()) {
            jedis.hset("usuario:" + email, "nome", nome);
        }
    }

    public static boolean validarLogin(String email) {
        try (Jedis jedis = getConnection()) {
            return jedis.exists("usuario:" + email);
        }
    }

    public static String obterNome(String email) {
        try (Jedis jedis = getConnection()) {
            return jedis.hget("usuario:" + email, "nome");
        }
    }

    public static boolean emailJaExiste(String email) {
        try (Jedis jedis = getConnection()) {
            return jedis.exists("usuario:" + email);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
