package org.sodex.web.common.bean;

/**
 * 只能用作spring mvc参数绑定的分页vo
 */
public class PageVo {

    private Integer number;
    private Integer size;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        // 前端iview-admin页码下标从1开始，后端spring下标从0开始，这里做转换
        this.number = number - 1;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

}
