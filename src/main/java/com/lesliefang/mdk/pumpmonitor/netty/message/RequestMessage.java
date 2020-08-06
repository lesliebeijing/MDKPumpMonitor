package com.lesliefang.mdk.pumpmonitor.netty.message;

import io.netty.buffer.ByteBuf;

public abstract class RequestMessage extends Message {
    public RequestMessage(short cmd) {
        setCmd(cmd);
    }

    /**
     * 子类可复写，默认返回 null
     */
    public ByteBuf buildRequestData() {
        return null;
    }
}
