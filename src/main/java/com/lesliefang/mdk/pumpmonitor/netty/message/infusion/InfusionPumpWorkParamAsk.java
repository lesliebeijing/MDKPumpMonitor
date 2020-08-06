package com.lesliefang.mdk.pumpmonitor.netty.message.infusion;

import com.lesliefang.mdk.pumpmonitor.netty.CMD;
import com.lesliefang.mdk.pumpmonitor.netty.message.RequestMessage;

/**
 * 输注泵工作参数查询
 */
public class InfusionPumpWorkParamAsk extends RequestMessage {
    public InfusionPumpWorkParamAsk() {
        super(CMD.INFUSION_PUMP_WORK_PARAM_ASK);
    }
}
