package com.lesliefang.mdk.pumpmonitor.netty.message;

import io.netty.buffer.ByteBuf;

public class DeviceStateAskReply extends ResponseMessage {
    private short deviceState;

    @Override
    public void parseResponseData(ByteBuf in) {
        deviceState = in.readUnsignedByte();
    }

    public short getDeviceState() {
        return deviceState;
    }

    public void setDeviceState(short deviceState) {
        this.deviceState = deviceState;
    }
}
