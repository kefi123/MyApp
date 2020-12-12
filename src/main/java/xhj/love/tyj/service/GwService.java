package xhj.love.tyj.service;

import org.springframework.data.domain.Page;
import xhj.love.tyj.bean.Gw;

import java.util.List;

/**
 * @Package xhj.love.tyj.service.impl
 * @Author 徐浩军
 * @Date 2020/7/31 22:05
 * @Version V1.0
 */
public interface GwService {
    /**
     * 获取所有的感悟
     * @return
     */
    Page<Gw> getGws(int pageNo, int pageSize);

    /**
     * 添加感悟
     */
    void addGw(Gw gw);

    /**
     * 根据关键字模糊搜搜
     * @param keyword
     * @return
     */
    List<Gw> searchGws(String keyword);

    /**
     * 认可
     * @param id
     */
    void like(int id);
}
