package com.lesliefang.mdk.pumpmonitor.netty.message;

import com.lesliefang.mdk.pumpmonitor.netty.CMD;

/**
 * 床位信息查询
 */
public class BedInfoAsk extends RequestMessage {
    public BedInfoAsk() {
        super(CMD.BED_INFO_ASK);
    }
}
