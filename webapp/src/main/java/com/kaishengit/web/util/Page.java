package com.kaishengit.web.util;

import com.kaishengit.web.entity.Movie;

import java.awt.*;
import java.util.List;

/**
 * Created by Administrator on 2016/6/18.
 */
public class Page<T> {
    private Integer totalNum;
    private Integer totalPages;
    private Integer pageNo;

    public List<T> getItems() {
        return items;
    }

    private Integer pagesize;
    private Integer start;

    public Page(Integer totalNum, Integer pageNo, Integer pagesize) {
        this.totalNum = totalNum;
        this.pageNo = pageNo;
        this.pagesize = pagesize;

        totalPages = totalNum / pagesize;
        if (totalNum % pagesize != 0) {
            totalPages++;
        }
        if (pageNo > totalPages) {
            this.pageNo = totalPages;
        }
        if (pageNo <= 0) {
            this.pageNo = 1;

        }
        start = (this.pageNo - 1) * pagesize;

    }

    private List<T> items;

    public Integer getTotalNum() {
        return totalNum;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public Integer getStart() {
        return start;
    }

    public Integer getPagesize() {
        return pagesize;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
