package com.lesliefang.mdk.pumpmonitor.netty.message;

import io.netty.buffer.ByteBuf;

public class WorkModeAskReply extends ResponseMessage {
    private short workMode;

    @Override
    public void parseResponseData(ByteBuf in) {
        workMode = in.readUnsignedByte();
    }

    public short getWorkMode() {
        return workMode;
    }

    public void setWorkMode(short workMode) {
        this.workMode = workMode;
    }
}
