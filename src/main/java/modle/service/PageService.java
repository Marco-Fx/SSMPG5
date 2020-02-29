package modle.service;

import com.github.pagehelper.PageInfo;
import comment.config.ShopBean;

import java.util.List;
/**
 *@描述
 *@创建人 zlc
 *@修改人和其它信息   page接口
 */
public interface PageService {
    /**
     * @ param  当前页  pageNum;
     *
     * @ param 每页的数量 pageSize;
     * */
    public PageInfo<ShopBean> shopInfo(Integer pageNum, Integer pageSize);
}
