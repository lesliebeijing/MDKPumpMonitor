package com.lesliefang.mdk.pumpmonitor.netty.message;

import com.lesliefang.mdk.pumpmonitor.netty.CMD;

/**
 * 工作模式查询
 */
public class WorkModeAsk extends RequestMessage {
    public WorkModeAsk() {
        super(CMD.WORK_MODE_ASK);
    }
}
