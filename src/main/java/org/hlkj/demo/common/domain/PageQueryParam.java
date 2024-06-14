/*
 * *
 *  @author 倪总
 *  @description
 *  @createDate ${DATE} ${TIME}
 * /
 */

package org.hlkj.demo.common.domain;

import lombok.Data;

@Data
public class PageQueryParam {

    private Integer page;
    private Integer pageSize;

}
