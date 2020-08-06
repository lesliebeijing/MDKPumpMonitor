package com.lesliefang.mdk.pumpmonitor.netty.message;

import com.lesliefang.mdk.pumpmonitor.netty.CMD;

/**
 * 设备地址查询
 */
public class DeviceAddressAsk extends RequestMessage {

    public DeviceAddressAsk() {
        super(CMD.DEVICE_ADDRESS_ASK);
    }
}
