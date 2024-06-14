package org.hlkj.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.hlkj.demo.domain.DbProblems;
import org.hlkj.demo.service.DbProblemsService;
import org.hlkj.demo.mapper.DbProblemsMapper;
import org.springframework.stereotype.Service;

/**
* @author 22818
* @description 针对表【db_problems】的数据库操作Service实现
* @createDate 2024-06-14 14:20:49
*/
@Service
public class DbProblemsServiceImpl extends ServiceImpl<DbProblemsMapper, DbProblems>
    implements DbProblemsService{

}




