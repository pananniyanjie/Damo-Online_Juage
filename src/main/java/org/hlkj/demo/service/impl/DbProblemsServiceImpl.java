package org.hlkj.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.hlkj.demo.common.domain.PageResult;
import org.hlkj.demo.domain.DbProblems;
import org.hlkj.demo.mapper.DbProblemsMapper;
import org.hlkj.demo.param.problem.CreateProblemParam;
import org.hlkj.demo.param.problem.DeleteProblemParam;
import org.hlkj.demo.param.problem.QueryPageParam;
import org.hlkj.demo.param.problem.UpdataProblemParam;
import org.hlkj.demo.service.DbProblemsService;
import org.hlkj.demo.vo.problem.ProblemVO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
* @author 22818
* @description 针对表【db_problems】的数据库操作Service实现
* @createDate 2024-06-14 14:20:49
*/
@Service
public class DbProblemsServiceImpl extends ServiceImpl<DbProblemsMapper, DbProblems>
    implements DbProblemsService{
    @Override
    public void createProblems(CreateProblemParam param) {
        DbProblems problems = new DbProblems();
        problems.setTitle(param.getTitle());
        problems.setDescription(param.getDescription());
        problems.setDisplayId(param.getDisplayId());
        problems.setInputDescription(param.getInputDescription());
        problems.setOutputDescription(param.getOutputDescription());
        problems.setTimeLimit(param.getTimeLimit());
        problems.setMemoryLimit(param.getMemoryLimit());
        problems.setSubmitCount(Long.valueOf(0));
        problems.setAcceptCount(Long.valueOf(0));
        problems.setRemarks(param.getRemarks());
        problems.setGmtCreate(LocalDateTime.now());
        problems.setGmtModified(LocalDateTime.now());
        save(problems);
    }

    @Override
    public void deleteProblems(DeleteProblemParam param) {
        removeById(param.getId());
    }

    @Override
    public void updataProblems(UpdataProblemParam param) {
        DbProblems problems = new DbProblems();
        problems.setTitle(param.getTitle());
        problems.setDescription(param.getDescription());
        problems.setDisplayId(param.getDisplayId());
        problems.setInputDescription(param.getInputDescription());
        problems.setOutputDescription(param.getOutputDescription());
        problems.setTimeLimit(param.getTimeLimit());
        problems.setMemoryLimit(param.getMemoryLimit());
        problems.setRemarks(param.getRemarks());
        problems.setGmtModified(LocalDateTime.now());
        updateById(problems);
    }

    @Override
    public PageResult<ProblemVO> pageQueryProblems(QueryPageParam param) {

        Page<DbProblems> page = page(
                new Page<>(param.getPage(),param.getPageSize()),
                new LambdaQueryWrapper<DbProblems>()
                        .and(param.getSearchStr() != null,item -> item.like(DbProblems::getDisplayId,param.getSearchStr())
                                .or()
                                .like(DbProblems::getTitle,param.getSearchStr()))
                        .orderByAsc(DbProblems::getDisplayId)
        );

        List<ProblemVO> collect = page.getRecords().stream().map(item -> {
            ProblemVO vo = new ProblemVO();
            vo.setId(Long.valueOf(item.getId()));
            vo.setDisplayId(item.getDisplayId());
            vo.setTitle(item.getTitle());
            vo.setDescription(item.getDescription());
            vo.setInputDescription(item.getInputDescription());
            vo.setOutputDescription(item.getOutputDescription());
            vo.setRemarks(item.getRemarks());
            vo.setSubmitCount(item.getSubmitCount());
            vo.setAcceptCount(item.getAcceptCount());
            return vo;
        }).collect(Collectors.toList());


        return new PageResult<>((int) page.getTotal(),collect);
    }
}




