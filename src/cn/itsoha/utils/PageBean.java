package cn.itsoha.utils;

import java.util.ArrayList;
import java.util.List;

public class PageBean {
    /**
     * 当前页面
     */
    private Integer currentPage;
    /**
     * 总数
     */
    private Integer totalCount;
    /**
     * 每一页显示的条数
     */
    private Integer pageSize;
    /**
     * 一共有多少页
     */
    private Integer totalPage;

    /**
     * 要显示的数据
     */
    private List list = new ArrayList();

    public PageBean(Integer currentPage, Integer totalCount, Integer pageSize) {
        this.currentPage = currentPage;
        this.totalCount = totalCount;
        this.pageSize = pageSize;

        if (this.currentPage == null) {
            this.currentPage = 1;
        }
        if (this.pageSize == null) {
            this.pageSize = 3;
        }

        //计算总页数
        this.totalPage = (this.totalCount+this.pageSize-1) / this.pageSize;

        if (this.currentPage < 1) {
            this.currentPage = 1;
        }
        if (this.currentPage > this.totalPage) {
            this.currentPage = this.totalPage;
        }
    }

    /**
     * 获取起始索引
     */
    public Integer getStart() {
        return (this.currentPage - 1) * this.pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "currentPage=" + currentPage +
                ", totalCount=" + totalCount +
                ", pageSize=" + pageSize +
                ", totalPage=" + totalPage +
                ", list=" + list +
                '}';
    }
}
