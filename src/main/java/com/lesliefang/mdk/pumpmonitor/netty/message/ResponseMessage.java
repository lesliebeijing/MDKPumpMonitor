package com.lesliefang.mdk.pumpmonitor.netty.message;

import io.netty.buffer.ByteBuf;

public abstract class ResponseMessage extends Message {
    /**
     * 应答状态字
     */
    private byte ack;

    public byte getAck() {
        return ack;
    }

    public void setAck(byte ack) {
        this.ack = ack;
    }

    /**
     * 默认空实现，子类可复写
     */
    public void parseResponseData(ByteBuf in) {

    }
}
