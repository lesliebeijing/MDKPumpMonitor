package com.lesliefang.mdk.pumpmonitor.netty.message.infusion;

import com.lesliefang.mdk.pumpmonitor.netty.CMD;
import com.lesliefang.mdk.pumpmonitor.netty.message.RequestMessage;

/**
 * 输注泵体重参数查询
 */
public class InfusionPumpWeightParamAsk extends RequestMessage {
    public InfusionPumpWeightParamAsk() {
        super(CMD.INFUSION_PUMP_WEIGHT_PARAM_ASK);
    }
}
