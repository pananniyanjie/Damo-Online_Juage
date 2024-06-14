/*
 * *
 *  @author 倪总
 *  @description
 *  @createDate ${DATE} ${TIME}
 * /
 */

package org.hlkj.demo.vo.problem;

import lombok.Data;

@Data
public class ProblemVO {
    private Long id;
    private String displayId;
    private String title;
    private String description;
    private String inputDescription;
    private String outputDescription;
    private String remarks;
    private Long submitCount;
    private Long acceptCount;
}
