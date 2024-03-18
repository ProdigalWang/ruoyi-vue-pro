package cn.iocoder.yudao.module.bpm.enums.task;

import cn.iocoder.yudao.framework.common.util.object.ObjectUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 流程任务 Task 的状态枚举
 *
 * @author jason
 */
@Getter
@AllArgsConstructor
public enum BpmTaskStatustEnum {

    RUNNING(1, "审批中"),
    APPROVE(2, "审批通过"),
    REJECT(3, "审批不通过"),
    CANCEL(4, "已取消"),

    RETURN(5, "已退回"),
    DELEGATE(6, "委派中"),

    /**
     * 【加签】源任务已经审批完成，但是它使用了后加签，后加签的任务未完成，源任务就会是这个状态
     * 相当于是 通过 APPROVE 的特殊状态
     * 例如：A 审批，A 后加签了 B，并且审批通过了任务，但是 B 还未审批，则当前任务状态为“待后加签任务完成”
     */
    APPROVING(7, "审批通过中"),
    /**
     * 【加签】源任务未审批，但是向前加签了，所以源任务状态变为“待前加签任务完成”
     * 相当于是 处理中 PROCESS 的特殊状态
     * 例如：A 审批，A 前加签了 B，B 还未审核
     */
    WAIT(0, "待审批");
//    /**
//     * 【加签】后加签任务被创建时的初始状态
//     * 相当于是 处理中 PROCESS 的特殊状态
//     * 因为需要源任务先完成，才能到后加签的人来审批，所以加了一个状态区分
//     */
//    WAIT_BEFORE_TASK(9, "处理中【待前置任务完成】");

    /**
     * 状态
     * <p>
     * 如果新增时，注意 {@link #isEndStatus(Integer)} 是否需要变更
     */
    private final Integer status;
    /**
     * 名字
     */
    private final String name;

    /**
     * 判断该状态是否已经处于 End 最终状态
     * <p>
     * 主要用于一些状态更新的逻辑，如果已经是最终状态，就不再进行更新
     *
     * @param status 状态
     * @return 是否
     */
    public static boolean isEndStatus(Integer status) {
        return ObjectUtils.equalsAny(status,
                APPROVE.getStatus(), REJECT.getStatus(), CANCEL.getStatus(),
                RETURN.getStatus(), APPROVING.getStatus());
    }

}