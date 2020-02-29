package modle.service.impl;

import modle.dao.UserMapper;
import modle.service.UserService;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
/***
 * 实现类
 * **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public Map userLogion(Map map) {
        return userMapper.userLogion(map);
    }

    @Override
    public int userRegisr(Map map) {
        return userMapper.userRegisr(map);
    }
}
