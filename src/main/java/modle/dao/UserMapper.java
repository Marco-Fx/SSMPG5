package modle.dao;

import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 *@描述
 *@创建人 zlc
 *@修改人和其它信息  登录注册
 */
@Repository
public interface UserMapper {
 Map userLogion(Map map);
 int userRegisr(Map map);



}
