package com.lesliefang.mdk.pumpmonitor.netty.message.gravity;

import com.lesliefang.mdk.pumpmonitor.netty.CMD;
import com.lesliefang.mdk.pumpmonitor.netty.message.RequestMessage;

/**
 * 重力输液器工作信息查询
 */
public class GravityWorkInfoAsk extends RequestMessage {
    public GravityWorkInfoAsk() {
        super(CMD.GC_WORK_INFO_ASK);
    }
}
