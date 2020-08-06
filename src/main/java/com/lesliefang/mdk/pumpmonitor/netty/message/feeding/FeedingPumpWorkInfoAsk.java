package com.lesliefang.mdk.pumpmonitor.netty.message.feeding;

import com.lesliefang.mdk.pumpmonitor.netty.CMD;
import com.lesliefang.mdk.pumpmonitor.netty.message.RequestMessage;

/**
 * 营养泵工作参数查询
 */
public class FeedingPumpWorkInfoAsk extends RequestMessage {
    public FeedingPumpWorkInfoAsk() {
        super(CMD.FEEDING_PUMP_WORK_INFO_ASK);
    }
}
