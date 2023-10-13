package com.lcw.exerciseback.api;

import lombok.Data;

/**
 * @Author Licanwei
 * @Description:为了更好的分页
 * @Date 2022/2/22 16:18
 */
public class PageVo {
    /**
     * 页码
     */
    private Integer pageNum;

    /**
     * 每页条数
     */
    private Integer pageSize;

    /**
     * 排序字段
     */
    private String fieldName;

    /**
     * 排序方式
     */
    private String direction;
    public Integer getPageNum() {
        if (pageNum != null && pageNum > 0) {
            return pageNum;
        } else {
            return 1;
        }
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        if (pageSize != null && pageSize > 0) {
            return pageSize;
        } else {
            return 100;//正常是7
        }
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

}
