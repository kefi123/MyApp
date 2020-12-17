package xhj.love.tyj.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xhj.love.tyj.entity.Think;
import xhj.love.tyj.mapper.ThinkMapper;
import xhj.love.tyj.service.ThinkService;
import xhj.love.tyj.util.Page;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Package xhj.love.tyj.service.impl
 * @Author 徐浩军
 * @Date 2020/7/31 22:05
 * @Version V1.0
 */
@Service
public class ThinkServiceImpl implements ThinkService {
    @Autowired
    ThinkMapper thinkMapper;

    private static final Logger LOGGER = LoggerFactory.getLogger(ThinkServiceImpl.class);

    /**
     * 获取所有的感悟
     *
     * @param keyword 关键字
     * @param page    分页信息
     * @return 感悟
     */
    @Override
    public Map<String, Object> getPage(String keyword, Page page) {
        List<Think> pages = thinkMapper.getPage(keyword, page.getStartIndex(), page.getPageSize());
        Integer count = thinkMapper.getCount(keyword);
        Map<String, Object> info = new HashMap<>();
        info.put("pages", pages);
        info.put("count", count);
        return info;
    }

    /**
     * 添加感悟信息
     *
     * @param think 感悟
     * @return 成功与否
     */
    @Override
    public boolean insert(Think think) {
        return thinkMapper.insert(think);
    }

    /**
     * 认可
     *
     * @param id 感悟id
     * @return 修改成功与否
     */
    @Override
    public boolean like(String id) {
        return thinkMapper.updateLikeNum(id);
    }
}
