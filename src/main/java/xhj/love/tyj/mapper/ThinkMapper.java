package xhj.love.tyj.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import xhj.love.tyj.entity.Think;

import java.util.List;

/**
 * @Package xhj.love.tyj.mapper
 * @Author 徐浩军
 * @Date 2020/12/16 20:55
 * @Version V1.0
 */
@Mapper
public interface ThinkMapper {
    /**
     * 分页接口
     * @param keyword 关键字
     * @param offset 偏移量
     * @param rowCount 行数
     * @return 感悟
     */
    List<Think> getPage(
            @Param("keyword") String keyword,
            @Param("offset") Integer offset,
            @Param("rowCount") Integer rowCount
    );

    /**
     * 分页总数接口
     * @param keyword 关键字
     * @return 总数
     */
    Integer getCount(@Param("keyword") String keyword);

    /**
     * 插入感悟信息
     * @param think 感悟
     * @return 成功与否
     */
    boolean insert(Think think);

    /**
     * 根据id修改感悟的认可度
     * @param id 感悟id
     * @return 修改成功与否
     */
    boolean updateLikeNum(String id);
}
