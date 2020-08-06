package com.lesliefang.mdk.pumpmonitor.netty.handler;

import com.lesliefang.mdk.pumpmonitor.netty.message.Message;
import com.lesliefang.mdk.pumpmonitor.netty.message.RequestMessage;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class MessageEncoder extends MessageToByteEncoder<RequestMessage> {
    @Override
    protected void encode(ChannelHandlerContext ctx, RequestMessage msg, ByteBuf out) throws Exception {
        out.writeByte(Message.PREFIX);
        out.writeBytes(msg.getDestAddress());
        out.writeBytes(msg.getSrcAddress());
        out.writeIntLE(msg.getMessageId());

        short len = 2 + 1; // cmd:2字节  + checkSum:1字节

        ByteBuf dataBuf = msg.buildRequestData();
        byte[] data = null;
        if (dataBuf != null) {
            data = new byte[dataBuf.readableBytes()];
            dataBuf.readBytes(data);
            dataBuf.release();
        }

        if (data != null) {
            len += data.length;
        }
        out.writeShortLE(len); // Length

        out.writeShortLE(msg.getCmd()); // CMD

        if (data != null) {
            out.writeBytes(data); // Data
        }

        /*
         * 除0xFF 前缀外其它所有字节计算出一个校验和
         */
        byte checkSum = msg.calcCheckSum(out);
        out.writeByte(checkSum);

        /*
         * 除前缀外每个字节都异或 0x44
         */
        for (int i = 1; i < out.readableBytes(); i++) {
            out.setByte(i, out.getByte(i) ^ Message.SALT);
        }
    }
}
