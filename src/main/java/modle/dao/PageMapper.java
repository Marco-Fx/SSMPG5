package modle.dao;

import comment.config.ShopBean;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *@描述
 *@创建人 zlc
 *@修改人和其它信息 增删查改
 */
@Repository
public interface PageMapper {
     List<ShopBean>shopInfo();
}
