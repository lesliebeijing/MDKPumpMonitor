package com.lesliefang.mdk.pumpmonitor.netty.message.infusion;

import com.lesliefang.mdk.pumpmonitor.netty.CMD;
import com.lesliefang.mdk.pumpmonitor.netty.message.RequestMessage;

/**
 * 工作信息查询
 */
public class InfusionPumpWorkInfoAsk extends RequestMessage {
    public InfusionPumpWorkInfoAsk() {
        super(CMD.INFUSION_PUMP_WORK_INFO_ASK);
    }
}
