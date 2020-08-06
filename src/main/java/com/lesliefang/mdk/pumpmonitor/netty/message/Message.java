package com.lesliefang.mdk.pumpmonitor.netty.message;

import io.netty.buffer.ByteBuf;

public abstract class Message {
    public static final byte PREFIX = (byte) 0xff;
    public static final byte SALT = 0x44;

    private byte[] destAddress = new byte[5];

    private byte[] srcAddress = new byte[5];

    private int messageId;

    private short cmd;

    private byte[] data;

    private byte checkSum;

    public byte[] getDestAddress() {
        return destAddress;
    }

    public void setDestAddress(byte[] destAddress) {
        this.destAddress = destAddress;
    }

    public byte[] getSrcAddress() {
        return srcAddress;
    }

    public void setSrcAddress(byte[] srcAddress) {
        this.srcAddress = srcAddress;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public short getCmd() {
        return cmd;
    }

    public void setCmd(short cmd) {
        this.cmd = cmd;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public byte getCheckSum() {
        return checkSum;
    }

    public void setCheckSum(byte checkSum) {
        this.checkSum = checkSum;
    }

    public byte calcCheckSum(ByteBuf buf) {
        int sum = 0;
        for (int i = 1; i < buf.readableBytes(); i++) {
            int v = buf.getByte(i) & 0xff;
            sum += v;
            sum += (sum >> 8) & 0xff; // 加进位
            sum = sum & 0xff; // 进位清零
        }
        sum = sum ^ 0xff; // 异或取反
        sum = sum & 0xff;
        return (byte) sum;
    }
}
