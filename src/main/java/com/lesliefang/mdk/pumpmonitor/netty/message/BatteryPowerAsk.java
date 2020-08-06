package com.lesliefang.mdk.pumpmonitor.netty.message;

import com.lesliefang.mdk.pumpmonitor.netty.CMD;

/**
 * 电池电量查询
 */
public class BatteryPowerAsk extends RequestMessage {
    public BatteryPowerAsk() {
        super(CMD.BATTERY_POWER_ASK);
    }
}
