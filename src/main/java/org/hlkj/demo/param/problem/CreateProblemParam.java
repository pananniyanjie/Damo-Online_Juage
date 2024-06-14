/*
 * *
 *  @author 倪总
 *  @description
 *  @createDate ${DATE} ${TIME}
 * /
 */

package org.hlkj.demo.param.problem;

import lombok.Data;

@Data
public class CreateProblemParam {

    private String title;
    private String display_id;
    private String description;
    private String inputDescription;
    private String outputDescription;
    private String sample;
    private Integer timeLimit;
    private Integer memoryLimit;

}
