package com.lesliefang.mdk.pumpmonitor.netty.message.feeding;

import com.lesliefang.mdk.pumpmonitor.netty.CMD;
import com.lesliefang.mdk.pumpmonitor.netty.message.RequestMessage;

/**
 * 营养泵工作日志查询
 */
public class FeedingPumpWorkLogAsk extends RequestMessage {
    public FeedingPumpWorkLogAsk() {
        super(CMD.FEEDING_PUMP_WORK_LOG_ASK);
    }
}
