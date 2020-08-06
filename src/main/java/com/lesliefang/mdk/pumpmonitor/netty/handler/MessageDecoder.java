package com.lesliefang.mdk.pumpmonitor.netty.handler;

import com.lesliefang.mdk.pumpmonitor.netty.CMD;
import com.lesliefang.mdk.pumpmonitor.netty.message.Message;
import com.lesliefang.mdk.pumpmonitor.netty.message.Register;
import com.lesliefang.mdk.pumpmonitor.netty.message.ResponseMessage;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class MessageDecoder extends ByteToMessageDecoder {
    private Logger logger = LoggerFactory.getLogger(MessageDecoder.class);

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        if (in.readableBytes() < 1) {
            return;
        }
        /*
         * 异或 0x44 解码
         */
        for (int i = 1; i < in.readableBytes(); i++) {
            in.setByte(i, in.getByte(i) ^ Message.SALT);
        }

        logger.trace("{}", ByteBufUtil.prettyHexDump(in));

        in.readByte(); // prefix 0xFF

        byte[] destAddress = new byte[5];
        in.readBytes(destAddress);

        byte[] srcAddress = new byte[5];
        in.readBytes(srcAddress);

        int messageId = in.readIntLE();

        short length = in.readShortLE();
        short cmd = in.readShortLE();

        byte ack = in.readByte(); // 状态字

        byte[] data = new byte[length - 2 - 1 - 1];
        in.readBytes(data);

        byte checkSum = in.readByte();

        Class<? extends ResponseMessage> cls = Register.responseMessageMap.get(CMD.DEVICE_ADDRESS_ASK);
        if (cls != null) {
            ResponseMessage respMsg = cls.newInstance();
            respMsg.setDestAddress(destAddress);
            respMsg.setSrcAddress(srcAddress);
            respMsg.setMessageId(messageId);
            respMsg.setCmd(cmd);
            respMsg.setData(data);
            respMsg.setAck(ack);
            respMsg.setCheckSum(checkSum);
            if (data.length > 0) {
                // 解析返回值
                ByteBuf dataBuf = Unpooled.wrappedBuffer(data);
                respMsg.parseResponseData(dataBuf);
                dataBuf.release();
            }
            out.add(respMsg);
        } else {
            // 没有找到指令，丢弃这个包
            out.clear();
            logger.debug("can not handle this cmd {}", cmd);
        }
    }
}
