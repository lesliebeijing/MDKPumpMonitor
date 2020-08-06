package com.lesliefang.mdk.pumpmonitor.netty.message.gravity;

import com.lesliefang.mdk.pumpmonitor.netty.message.ResponseMessage;
import io.netty.buffer.ByteBuf;

public class GravityWorkInfoAskReply extends ResponseMessage {
    private byte deviceState;
    /**
     * MC2: 流速为0时表示止液夹关闭，停止输液。为1时表示止液夹打开，正在输液。
     * MC1: 就是实时流速
     */
    private int realRate;

    @Override
    public void parseResponseData(ByteBuf in) {
        deviceState = in.readByte();
        realRate = in.readIntLE();
    }

    public byte getDeviceState() {
        return deviceState;
    }

    public void setDeviceState(byte deviceState) {
        this.deviceState = deviceState;
    }

    public int getRealRate() {
        return realRate;
    }

    public void setRealRate(int realRate) {
        this.realRate = realRate;
    }
}
