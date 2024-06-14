/*
 * *
 *  @author 倪总
 *  @description
 *  @createDate ${DATE} ${TIME}
 * /
 */

package org.hlkj.demo.common.domain;

import lombok.Data;

import java.util.List;

@Data
public class PageResult<T> {
    private int total;
    private List<T> rows;

    public PageResult(Integer total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }
}
