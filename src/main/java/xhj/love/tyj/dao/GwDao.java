package xhj.love.tyj.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import xhj.love.tyj.bean.Gw;

import java.util.List;

/**
 * @Package xhj.love.tyj.dao
 * @Author 徐浩军
 * @Date 2020/7/13 22:17
 * @Version V1.0
 */
@Repository
public interface GwDao extends JpaRepository<Gw, Integer> {
    /**
     * 根据关键字进行搜索
     * @param content
     * @return
     */
    List<Gw> findByContentLike(String content);

    /**
     * 修改认可度
     * @param id
     */
    @Transactional
    @Modifying
    @Query("update Gw t set t.likeNum = (t.likeNum + 1) where t.id = :id")
    void updateLikeNum(@Param(value = "id") Integer id);
}