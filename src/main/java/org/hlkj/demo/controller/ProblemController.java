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
import org.hlkj.demo.param.problem.CreateProblemParam;
import org.hlkj.demo.param.problem.DeleteProblemParam;
import org.hlkj.demo.param.problem.QueryPageParam;
import org.hlkj.demo.param.problem.UpdataProblemParam;
import org.hlkj.demo.service.DbProblemsService;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/problemset")
@RestController
@RequiredArgsConstructor
public class ProblemController {
    private final DbProblemsService dbProblemsService;

    @GetMapping
    public Result<?> pageQuery(QueryPageParam param){
        if(param == null){
            param = new QueryPageParam();
            param.setPageSize(10);
            param.setPage(1);
        }
        if(param.getPageSize() == null || param.getPageSize() < 1){
            param.setPageSize(10);
        }
        if(param.getPage() == null || param.getPage() < 1){
            param.setPage(1);
        }
        return Result.success(dbProblemsService.pageQueryProblems(param));
    }
    @PostMapping("/create")
    public Result<?> createNoitce(@RequestBody CreateProblemParam param) {
        dbProblemsService.createProblems(param);
        return Result.success(null);
    }
    @PostMapping("/updata")
    public Result<?> updataNotice(@RequestBody UpdataProblemParam param) {
        dbProblemsService.updataProblems(param);
        return Result.success(null);
    }
    @PostMapping("/delete")
    public Result<?> deleteNotice(@RequestBody DeleteProblemParam param) {
        dbProblemsService.deleteProblems(param);
        return Result.success(null);
    }
}
