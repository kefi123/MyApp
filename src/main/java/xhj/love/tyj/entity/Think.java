package xhj.love.tyj.entity;

import java.io.Serializable;

/**
 * @Package xhj.love.tyj.bean
 * @Author 徐浩军
 * @Date 2020/7/20 19:44
 * @Version V1.0
 */
public class Think implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    private String content;

    private String createTime;

    private String updateTime;

    private Integer likeNum;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }
}
