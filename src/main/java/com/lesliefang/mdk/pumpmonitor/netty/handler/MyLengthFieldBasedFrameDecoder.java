package com.lesliefang.mdk.pumpmonitor.netty.handler;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

import java.nio.ByteOrder;

public class MyLengthFieldBasedFrameDecoder extends LengthFieldBasedFrameDecoder {
    public MyLengthFieldBasedFrameDecoder() {
        super(65535, 15, 2);
    }

    @Override
    protected long getUnadjustedFrameLength(ByteBuf buf, int offset, int length, ByteOrder order) {
        /*
         * 由于每个字节都异或 0x44 了，所以要先解码才能计算出实际长度
         */
        long value = 0;
        for (int i = 0; i < length; i++) {
            value += ((buf.getByte(offset + i) ^ 0x44) & 0xff) << (8 * i);
        }
        return value;
    }
}
