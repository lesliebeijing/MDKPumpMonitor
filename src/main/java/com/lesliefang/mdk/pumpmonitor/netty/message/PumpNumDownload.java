package com.lesliefang.mdk.pumpmonitor.netty.message;

import com.lesliefang.mdk.pumpmonitor.netty.CMD;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 * 泵号信息下载
 */
public class PumpNumDownload extends RequestMessage {
    private byte pumpNum;

    public PumpNumDownload(byte pumpNum) {
        super(CMD.PUMP_NUM_DL);
        this.pumpNum = pumpNum;
    }

    @Override
    public ByteBuf buildRequestData() {
        ByteBuf out = Unpooled.buffer();
        out.writeByte(pumpNum);
        return out;
    }

    public byte getPumpNum() {
        return pumpNum;
    }

    public void setPumpNum(byte pumpNum) {
        this.pumpNum = pumpNum;
    }
}
