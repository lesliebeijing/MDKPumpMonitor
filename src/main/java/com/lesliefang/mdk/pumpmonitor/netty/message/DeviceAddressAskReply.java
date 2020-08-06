package com.lesliefang.mdk.pumpmonitor.netty.message;

import io.netty.buffer.ByteBuf;

public class DeviceAddressAskReply extends ResponseMessage {
    private short deviceType;

    @Override
    public void parseResponseData(ByteBuf in) {
        deviceType = in.readUnsignedByte();
    }

    public short getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(short deviceType) {
        this.deviceType = deviceType;
    }
}
