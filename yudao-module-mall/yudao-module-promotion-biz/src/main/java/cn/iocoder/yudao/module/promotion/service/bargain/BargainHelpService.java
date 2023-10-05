package cn.iocoder.yudao.module.promotion.service.bargain;

import cn.iocoder.yudao.module.promotion.controller.app.bargain.vo.help.AppBargainHelpCreateReqVO;
import cn.iocoder.yudao.module.promotion.dal.dataobject.bargain.BargainHelpDO;

import java.util.Collection;
import java.util.Map;

/**
 * 砍价助力 Service 接口
 *
 * @author 芋道源码
 */
public interface BargainHelpService {

    /**
     * 创建砍价助力（帮人砍价）
     *
     * @param userId 用户编号
     * @param reqVO 请求信息
     * @return 砍价助力记录
     */
    BargainHelpDO createBargainHelp(Long userId, AppBargainHelpCreateReqVO reqVO);

    /**
     * 【砍价活动】获得助力人数 Map
     *
     * @param activityIds 活动编号
     * @return 助力人数 Map
     */
    Map<Long, Integer> getBargainHelpUserCountMapByActivity(Collection<Long> activityIds);

    /**
     * 【砍价记录】获得助力人数 Map
     *
     * @param recordIds 记录编号
     * @return 助力人数 Map
     */
    Map<Long, Integer> getBargainHelpUserCountMapByRecord(Collection<Long> recordIds);

}