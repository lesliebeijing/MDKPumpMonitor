package com.lesliefang.mdk.pumpmonitor.netty.message;

import io.netty.buffer.ByteBuf;

public class BatteryPowerAskReply extends ResponseMessage {
    private short power;

    @Override
    public void parseResponseData(ByteBuf in) {
        power = in.readShortLE();
    }

    public short getPower() {
        return power;
    }

    public void setPower(short power) {
        this.power = power;
    }
}
