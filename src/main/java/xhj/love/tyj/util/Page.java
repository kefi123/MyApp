package xhj.love.tyj.util;

/**
 * @author 徐浩军 xhj X6241
 * @date 2020/2/18 20:45
 * @description
 */
public class Page {
    /**
     * 页码
     */
    int pageNo;

    /**
     * 尺寸
     */
    int pageSize = 10;

    /**
     * 偏移量
     */
    int startIndex;

    public Page(int pageNo, int pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public Page() {
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getStartIndex() {
        this.startIndex = (this.getPageNo() - 1) * this.getPageSize();
        if (this.startIndex <= 0) {
            this.startIndex = 0;
        }
        return this.startIndex;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        if (pageNo <= 0) {
            pageNo = 1;
        }
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                '}';
    }
}
