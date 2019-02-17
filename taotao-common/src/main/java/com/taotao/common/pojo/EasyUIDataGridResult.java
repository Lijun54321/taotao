package com.taotao.common.pojo;

import java.util.List;

/**
 * Class EasyUIDataGridResult ...
 * 用于分页后的数据显示
 * @author LiJun
 * Created on 2019/2/16
 */
public class EasyUIDataGridResult {
    // 记录数
    private long total;
    // rows
    private List<?> rows;

    public EasyUIDataGridResult() {
    }

    public EasyUIDataGridResult(long total, List<?> rows) {
        this.total = total;
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
