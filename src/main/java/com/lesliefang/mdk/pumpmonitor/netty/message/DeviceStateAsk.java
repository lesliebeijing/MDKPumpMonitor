package com.lesliefang.mdk.pumpmonitor.netty.message;

import com.lesliefang.mdk.pumpmonitor.netty.CMD;

/**
 * 设备状态查询
 */
public class DeviceStateAsk extends RequestMessage {
    public DeviceStateAsk() {
        super(CMD.DEVICE_STATE_ASK);
    }
}
