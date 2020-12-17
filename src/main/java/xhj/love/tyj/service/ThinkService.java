package xhj.love.tyj.service;

import xhj.love.tyj.entity.Think;
import xhj.love.tyj.util.Page;

import java.util.List;
import java.util.Map;

/**
 * @Package xhj.love.tyj.service.impl
 * @Author 徐浩军
 * @Date 2020/7/31 22:05
 * @Version V1.0
 */
public interface ThinkService {
    /**
     * 获取所有的感悟
     * @param keyword 关键字
     * @param page 分页信息
     * @return 感悟
     */
    Map<String, Object> getPage(String keyword, Page page);

    /**
     * 添加感悟信息
     * @param think 感悟
     * @return 成功与否
     */
    boolean insert(Think think);


    /**
     * 认可
     * @param id 感悟id
     * @return 修改成功与否
     */
    boolean like(String id);
}
