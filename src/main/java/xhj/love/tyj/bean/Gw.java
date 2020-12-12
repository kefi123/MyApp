package xhj.love.tyj.bean;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Package xhj.love.tyj.bean
 * @Author 徐浩军
 * @Date 2020/7/20 19:44
 * @Version V1.0
 */
@Entity
@Table(name="think")
public class Gw implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="content")
    private String content;

    @Column(name="create_time")
    private String createTime;

    @Column(name="update_time")
    private String updateTime;

    @Column(name="like_num")
    private Integer likeNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
