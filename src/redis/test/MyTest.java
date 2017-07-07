package redis.test;

import redis.clients.jedis.Jedis;

public class MyTest {

    public static void main(String[] args){
        Jedis jedis = new Jedis("192.168.42.202", 6379);
        jedis.auth("password");
        jedis.set("name","xinxin");//向key-->name中放入了value-->xinxin  
        System.out.println(jedis.get("name"));//执行结果：xinxin  
        
    }
}
