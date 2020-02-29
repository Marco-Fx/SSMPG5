package modle.controller;

import com.github.pagehelper.PageInfo;
import comment.config.ShopBean;
import modle.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PageInfoClass {
    @Autowired
    PageService pageService;

    /**
     * @ param  当前页  pageNum;
     *
     * @ param 每页的数量 pageSize;
     *
     * @return*/
    @GetMapping("pageinfo")
    public PageInfo<ShopBean> pageinfo(@RequestParam int pagenum, int pagesize) {

        PageInfo<ShopBean> shopBeanPageInfo = pageService.shopInfo(pagenum, pagesize);

        return shopBeanPageInfo;
/**
         * "pageNum":2," 当前页号
         * "pageSize":2,"每页大小
         * "size":2,实际条数
         * "total":29,"总条数
         * "pages":15,总页数
         * list  :数据
         *  prePage  前一页
         *
         * */




    }
}
