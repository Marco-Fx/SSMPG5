package comment.config;


import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.CollectionUtils;

import java.util.concurrent.TimeUnit;

public class RedisUtil {
    static RedisTemplate<String, Object> redis;

    //加载spring参数
    public RedisUtil(RedisTemplate<String, Object> redisTemplate) {
        this.redis = redisTemplate;
    }

    //向redis中传值
    public static void put(String key, Object value) {
        redis.opsForValue().set(key, value);
    }

    //通过key获取value
    public static <T> T getdata(String key) {
        return (T) redis.opsForValue().get(key);
    }

    //通过key删除信息
    public static void delete(String key) {
        redis.opsForValue().getOperations().delete(key);
    }

    /**
     * 删除缓存
     *
     * @param key 可以传一个值 或多个
     */

    public void del(String... key) {
        if (key != null && key.length > 0) {
            if (key.length == 1) {
                redis.delete(key[0]);
            } else {
                redis.delete(CollectionUtils.arrayToList(key));
            }
        }
    }

    /**
     * 普通缓存放入并设置时间
     *
     * @param key   键
     * @param value 值
     * @param time  时间(秒) time要大于0 如果time小于等于0 将设置无限期
     * @return true成功 false 失败
     */
    public boolean set(String key, Object value, long time) {
        try {
            if (time > 0) {
                redis.opsForValue().set(key, value, time, TimeUnit.SECONDS);
            } else {
                set(key, value);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 普通缓存放入
     *
     * @param key   键
     * @param value 值
     * @return true成功 false失败
     */
    public boolean set(String key, Object value) {
        try {
            redis.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}