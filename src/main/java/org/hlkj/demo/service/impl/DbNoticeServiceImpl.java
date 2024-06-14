/*
 * *
 *  @author 倪总
 *  @description
 *  @createDate ${DATE} ${TIME}
 * /
 */

package org.hlkj.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.hlkj.demo.common.domain.PageQueryParam;
import org.hlkj.demo.common.domain.PageResult;
import org.hlkj.demo.domain.DbNotice;
import org.hlkj.demo.mapper.DbNoticeMapper;
import org.hlkj.demo.param.notice.CreatNoticeParam;
import org.hlkj.demo.param.notice.DeleteNoticeParam;
import org.hlkj.demo.param.notice.UpdataNoticeParam;
import org.hlkj.demo.service.DbNoticeService;
import org.hlkj.demo.vo.notice.NoticeVO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
* @author 22818
* @description 针对表【db_notice】的数据库操作Service实现
* @createDate 2024-06-06 16:15:43
*/
@RequiredArgsConstructor
@Service
public class DbNoticeServiceImpl extends ServiceImpl<DbNoticeMapper, DbNotice>
    implements DbNoticeService{

    private final DbNoticeMapper dbNoticeMapper;

    @Override
    public void createNotice(CreatNoticeParam param){
        DbNotice dbNotice = new DbNotice();
        dbNotice.setTitle(param.getTitle());
        dbNotice.setContent(param.getContext());
        dbNotice.setGmtCreate(LocalDateTime.now());
        dbNotice.setGmtModified(LocalDateTime.now());
        save(dbNotice);
    }

    @Override
    public void deleteNotice(DeleteNoticeParam param){
        removeById(param.getId());
    }

    @Override
    public void updateNotice(UpdataNoticeParam param){
        DbNotice dbNotice = new DbNotice();
        dbNotice.setId(param.getId());
        dbNotice.setTitle(param.getTitle());
        dbNotice.setContent(param.getContext());
        updateById(dbNotice);
    }

    @Override
    public PageResult<NoticeVO> pageQuery(PageQueryParam param) {
        Page<DbNotice> page = page(new Page<>(param.getPage(),param.getPageSize()),new LambdaQueryWrapper<DbNotice>().orderByDesc(DbNotice::getGmtCreate));

        List<NoticeVO> collect = page.getRecords().stream().map(item -> {
            NoticeVO vo = new NoticeVO();
            vo.setId(item.getId());
            vo.setTitle(item.getTitle());
            vo.setContext(item.getContent());
            vo.setGmtCreate(item.getGmtCreate());
            return vo;
        }).collect(Collectors.toList());


        return new PageResult<>((int) page.getTotal(),collect);
    }
}




