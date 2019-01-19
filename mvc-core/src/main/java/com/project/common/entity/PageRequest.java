package com.project.common.entity;

/**
 * Created by yinshaobo at 2018/6/10
 * 页面表格分页请求信息
 */
public class PageRequest {

    private int draw;//绘制计数器
    private int start;//第一条数据的起始位置，比如0代表第一条数据 注意：该值并不是页码的值！！！页码值为：start / length = 1
    private int length;//告诉服务器每页显示的条数，这个数字会等于返回的 data集合的记录数，可能会大于因为服务器可能没有那么多数据。这个也可能是-1，代表需要返回全部数据

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
