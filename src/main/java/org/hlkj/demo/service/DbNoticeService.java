/*
 * *
 *  @author 倪总
 *  @description
 *  @createDate ${DATE} ${TIME}
 * /
 */

package org.hlkj.demo.service;

import org.hlkj.demo.common.domain.PageQueryParam;
import org.hlkj.demo.common.domain.PageResult;
import org.hlkj.demo.domain.DbNotice;
import com.baomidou.mybatisplus.extension.service.IService;
import org.hlkj.demo.param.notice.CreatNoticeParam;
import org.hlkj.demo.param.notice.DeleteNoticeParam;
import org.hlkj.demo.param.notice.UpdataNoticeParam;
import org.hlkj.demo.vo.notice.NoticeVO;

/**
* @author 22818
* @description 针对表【db_notice】的数据库操作Service
* @createDate 2024-06-06 16:15:43
*/

public interface DbNoticeService extends IService<DbNotice> {

    void createNotice(CreatNoticeParam param);

    void deleteNotice(DeleteNoticeParam param);

    void updateNotice(UpdataNoticeParam param);

    PageResult<NoticeVO> pageQuery(PageQueryParam param);


}
