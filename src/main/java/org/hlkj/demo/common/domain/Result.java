/*
 * *
 *  @author 倪总
 *  @description
 *  @createDate ${DATE} ${TIME}
 * /
 */

package org.hlkj.demo.common.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Result<T> {

    private int code;
    private String  message;
    private T data;

    public static <T> Result<T> success(T data) {
        return new Result<>(100001, "请求成功", data);
    }

    public static <T> Result<T> success(String message, T data) {
        return new Result<>(100001, message, data);
    }

    public static <T> Result<T> fail(int code, String message) {
        return new Result<>(code, message, null);
    }

}
