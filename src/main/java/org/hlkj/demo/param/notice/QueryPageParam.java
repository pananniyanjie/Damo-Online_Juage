/*
 * *
 *  @author 倪总
 *  @description
 *  @createDate ${DATE} ${TIME}
 * /
 */

package org.hlkj.demo.param.notice;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hlkj.demo.common.domain.PageQueryParam;

@EqualsAndHashCode(callSuper = true)
@Data
public class QueryPageParam extends PageQueryParam {
    private Integer sum;
}
