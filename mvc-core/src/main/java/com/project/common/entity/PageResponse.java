package com.project.common.entity;

/**
 * Created by yinshaobo at 2018/6/10
 * 页面表格分页响应信息
 */
public class PageResponse {

    private int draw;//绘制计数器
    private long recordsTotal;//没有过滤的记录数（数据库里总共记录数）
    private long recordsFiltered;//过滤后的记录数（如果有接收到前台的过滤条件，则返回的是过滤后的记录数）
    private Object data;//表中中需要显示的数据
    private String error;//你可以定义一个错误来描述服务器出了问题后的友好提示

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public long getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(long recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public long getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(long recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
