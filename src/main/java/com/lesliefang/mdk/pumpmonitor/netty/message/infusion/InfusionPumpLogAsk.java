package com.lesliefang.mdk.pumpmonitor.netty.message.infusion;

import com.lesliefang.mdk.pumpmonitor.netty.CMD;
import com.lesliefang.mdk.pumpmonitor.netty.message.RequestMessage;

/**
 * 输注泵工作日志查询
 */
public class InfusionPumpLogAsk extends RequestMessage {
    /**
     * 日志ID，传 0 会获取最新的一条日志
     */
    private int logId;

    public InfusionPumpLogAsk(int logId) {
        super(CMD.INFUSION_PUMP_LOG_ASK);
        this.logId = logId;
    }

    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }
}
