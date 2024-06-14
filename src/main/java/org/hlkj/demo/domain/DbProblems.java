package org.hlkj.demo.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 
 * @TableName db_problems
 */
@TableName(value ="db_problems")
@Data
public class DbProblems implements Serializable {
    /**
     * 题目id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 题目标题
     */
    @TableField(value = "title")
    private String title;

    /**
     * 显示编号
     */
    @TableField(value = "display_id")
    private String displayId;

    /**
     * 题目描述
     */
    @TableField(value = "description")
    private String description;

    /**
     * 输入描述
     */
    @TableField(value = "input_description")
    private String inputDescription;

    /**
     * 输出描述
     */
    @TableField(value = "output_description")
    private String outputDescription;

    /**
     * 测试数据
     */
    @TableField(value = "sample")
    private Object sample;

    /**
     * 时间限制
     */
    @TableField(value = "time_limit")
    private Integer timeLimit;

    /**
     * 内存限制
     */
    @TableField(value = "memory_limit")
    private Integer memoryLimit;

    /**
     * 备注
     */
    @TableField(value = "remarks")
    private String remarks;

    /**
     * 提交数量
     */
    @TableField(value = "submit_count")
    private Long submitCount;

    /**
     * 通过数量
     */
    @TableField(value = "accept_count")
    private Long acceptCount;

    /**
     * 创建时间
     */
    @TableField(value = "gmt_create")
    private LocalDateTime gmtCreate;

    /**
     * 修改时间
     */
    @TableField(value = "gmt_modified")
    private LocalDateTime gmtModified;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}