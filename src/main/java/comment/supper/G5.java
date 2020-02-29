package comment.supper;

import comment.config.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * 错5次不可进入
 */
@Component
public class G5 {
    @Autowired
    RedisUtil redisUtil;

    public void Gi5(String name) {
        Object getdata = redisUtil.getdata(name);

        if (getdata == null) {
            redisUtil.set(name, "1");


        } else if (Integer.parseInt(getdata.toString()) < 5) {
            Integer i = Integer.parseInt(getdata.toString()) + 1;
            redisUtil.set(name, i.toString());

        } else {
            redisUtil.set(name, "5", 300);

        }
    }

    public String Gi51(String name) {
        Object getdata = redisUtil.getdata(name);
        if (getdata == null) {
            return "11";
        } else {
            return getdata.toString();
        }

    }
}
