package com.lbb.clothes.business.vo;

import java.io.Serializable;

public class BaseGridInVo implements Serializable {

    private Integer pageSize = 9;
    private Integer pageNum = 1;

    public Integer getPageSize() {
        return pageSize;
    }

    public BaseGridInVo setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public BaseGridInVo setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
        return this;
    }
}
