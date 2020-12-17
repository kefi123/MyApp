package xhj.love.tyj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xhj.love.tyj.entity.Think;
import xhj.love.tyj.service.ThinkService;
import xhj.love.tyj.util.DateUtil;
import xhj.love.tyj.util.NumberSender;
import xhj.love.tyj.util.Page;
import xhj.love.tyj.util.Response;

import java.util.Map;

/**
 * @Package xhj.love.tyj
 * @Author 徐浩军
 * @Date 2020/7/13 21:56
 * @Version V1.0
 */
@RestController
@RequestMapping("myApp/think")
public class ThinkController {
    @Autowired
    private ThinkService thinkService;

    /**
     * 分页获取感悟信息
     * @param keyword 关键字
     * @param page 分页信息
     * @return 感悟
     */
    @GetMapping("getPage")
    public Response getPage(String keyword, Page page){
        Map<String, Object> pages = thinkService.getPage(keyword, page);
        return new Response(0, "操作成功", pages);
    }

    /**
     * 添加感悟
     * @param content
     * @return
     */
    @PostMapping("insert")
    public Response insert(String content){
        Think think = new Think();
        think.setId(NumberSender.getCode("think"));
        think.setContent(content);
        think.setCreateTime(DateUtil.getCurrentDate());
        think.setUpdateTime(DateUtil.getCurrentDate());
        think.setLikeNum(0);
        return thinkService.insert(think) ? new Response(0, "插入成功", null) : new Response(-1, "插入失败", null);
    }

    /**
     * 认可
     * @param id
     * @return
     */
    @PostMapping("like")
    public Response like(String id){
        return thinkService.like(id) ? new Response(0, "修改成功", null) : new Response(-1, "修改失败", null);
    }
}
