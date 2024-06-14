/*
 * *
 *  @author 倪总
 *  @description
 *  @createDate ${DATE} ${TIME}
 * /
 */

package org.hlkj.demo.controller;

import lombok.RequiredArgsConstructor;
import org.hlkj.demo.common.domain.Result;
import org.hlkj.demo.param.notice.CreatNoticeParam;
import org.hlkj.demo.param.notice.DeleteNoticeParam;
import org.hlkj.demo.param.notice.QueryPageParam;
import org.hlkj.demo.param.notice.UpdataNoticeParam;
import org.hlkj.demo.service.DbNoticeService;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/notice")
@RestController
@RequiredArgsConstructor
public class NoticeController {

    private final DbNoticeService dbNoticeService;

    @GetMapping
    public Result<?> pageQuery(QueryPageParam param){
        return Result.success(dbNoticeService.pageQuery(param));
    }
    @PostMapping("/create")
    public Result<?> createNoitce(@RequestBody CreatNoticeParam param) {
        dbNoticeService.createNotice(param);
        return Result.success(null);
    }
    @PostMapping("/updata")
    public Result<?> updataNotice(@RequestBody UpdataNoticeParam param) {
        dbNoticeService.updateNotice(param);
        return Result.success(null);
    }
    @PostMapping("/delete")
    public Result<?> deleteNotice(@RequestBody DeleteNoticeParam param) {
        dbNoticeService.deleteNotice(param);
        return Result.success(null);
    }

}
