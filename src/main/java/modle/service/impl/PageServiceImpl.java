package modle.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import comment.config.ShopBean;
import modle.dao.PageMapper;
import modle.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PageServiceImpl implements PageService {
    @Autowired
    PageMapper pagerMapper;

    /**
     * 多条件分页查询用户
     * @ param userParam
     * @ param pageNum
     * @ param pageSize
     * @ return
     */
    @Override
    public PageInfo<ShopBean> shopInfo(Integer pageNum,Integer pageSize) {
        //利用PageHelper分页查询 注意：这个一定要放查询语句的前一行,否则无法进行分页,因为它对紧随其后第一个sql语句有效
        PageHelper.startPage(pageNum, pageSize);
        List<ShopBean> userList = pagerMapper.shopInfo();
        JSONArray objects = JSONArray.parseArray(JSON.toJSONString(userList));

        PageInfo<ShopBean> pageInfo = new PageInfo<ShopBean>(userList);

        return  pageInfo;
    }
}
