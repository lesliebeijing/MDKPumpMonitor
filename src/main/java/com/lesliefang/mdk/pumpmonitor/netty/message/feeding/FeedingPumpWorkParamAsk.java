package com.lesliefang.mdk.pumpmonitor.netty.message.feeding;

import com.lesliefang.mdk.pumpmonitor.netty.CMD;
import com.lesliefang.mdk.pumpmonitor.netty.message.RequestMessage;

/**
 * 营养泵工作参数查询
 */
public class FeedingPumpWorkParamAsk extends RequestMessage {
    public FeedingPumpWorkParamAsk() {
        super(CMD.FEEDING_PUMP_WORK_PARAM_ASK);
    }
}
