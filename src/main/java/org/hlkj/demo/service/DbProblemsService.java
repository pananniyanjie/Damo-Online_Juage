package org.hlkj.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.hlkj.demo.common.domain.PageResult;
import org.hlkj.demo.domain.DbProblems;
import org.hlkj.demo.param.problem.CreateProblemParam;
import org.hlkj.demo.param.problem.DeleteProblemParam;
import org.hlkj.demo.param.problem.QueryPageParam;
import org.hlkj.demo.param.problem.UpdataProblemParam;
import org.hlkj.demo.vo.problem.ProblemVO;

/**
* @author 22818
* @description 针对表【db_problems】的数据库操作Service
* @createDate 2024-06-14 14:20:49
*/
public interface DbProblemsService extends IService<DbProblems> {
    void createProblems(CreateProblemParam param);
    void deleteProblems(DeleteProblemParam param);
    void updataProblems(UpdataProblemParam param);

    PageResult<ProblemVO> pageQueryProblems(QueryPageParam param);
}
