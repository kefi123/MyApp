package xhj.love.tyj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import xhj.love.tyj.bean.Gw;
import xhj.love.tyj.service.GwService;
import xhj.love.tyj.util.DateUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Package xhj.love.tyj
 * @Author 徐浩军
 * @Date 2020/7/13 21:56
 * @Version V1.0
 */
@RestController
@RequestMapping("gw")
public class GwController {
    @Autowired
    private GwService gwService;

    /**
     * 获取分页感悟
     * @param pageNo
     * @param pageSize
     * @return
     */
    @GetMapping("getGws")
    public Page<Gw> getGws(int pageNo, int pageSize){
        //pageable从第0也开始
        return gwService.getGws(pageNo-1, pageSize);
    }

    /**
     * 添加感悟
     * @param content
     * @return
     */
    @GetMapping("addGw")
    public String addGw(String content){
        Gw gw = new Gw();
        gw.setContent(content);
        gw.setCreateTime(DateUtil.getCurrentDate());
        gw.setLikeNum(0);
        gwService.addGw(gw);
        return "success!";
    }

    /**
     * 根据关键字模糊搜搜
     *
     * @param keyword
     * @return
     */
    @GetMapping("searchGws")
    public Map<String,Object> searchGws(String keyword){
        Map<String,Object> result = new HashMap<>(16);
        List<Gw> gws = gwService.searchGws("%"+keyword+"%");
        result.put("status", 0);
        result.put("data", gws);
        return result;
    }

    /**
     * 认可
     * @param id
     * @return
     */
    @GetMapping("like")
    public String like(int id){
        gwService.like(id);
        return "认可成功";
    }
}
