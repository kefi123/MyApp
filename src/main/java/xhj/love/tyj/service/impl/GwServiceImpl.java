package xhj.love.tyj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import xhj.love.tyj.bean.Gw;
import xhj.love.tyj.dao.GwDao;
import xhj.love.tyj.service.GwService;

import java.util.List;

/**
 * @Package xhj.love.tyj.service.impl
 * @Author 徐浩军
 * @Date 2020/7/31 22:05
 * @Version V1.0
 */
@Service
public class GwServiceImpl implements GwService {
    @Autowired
    private GwDao gwDao;

    /**
     * 获取所有的感悟
     *
     * @return
     */
    @Override
    public Page<Gw> getGws(int pageNo, int pageSize) {
        //按照认可度降序排序
        Sort sort = new Sort(Sort.Direction.DESC, "likeNum");
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        return gwDao.findAll(pageable);
    }

    /**
     * 添加感悟
     */
    @Override
    public void addGw(Gw gw) {
        gwDao.save(gw);
    }

    /**
     * 根据关键字模糊搜搜
     *
     * @param keyword
     * @return
     */
    @Override
    public List<Gw> searchGws(String keyword) {
        return gwDao.findByContentLike(keyword);
    }

    /**
     * 认可
     *
     * @param id
     */
    @Override
    public void like(int id) {
        gwDao.updateLikeNum(new Integer(id));
    }
}
