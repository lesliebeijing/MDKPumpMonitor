package com.lesliefang.mdk.pumpmonitor.netty.message.infusion;

import com.lesliefang.mdk.pumpmonitor.netty.message.ResponseMessage;
import io.netty.buffer.ByteBuf;

public class InfusionPumpWorkInfoAskReply extends ResponseMessage {
    // 设备状态
    private short deviceState;
    // 实时流速
    private int realRate;
    // 剩余时间
    private int remainTime;
    // 剩余总量
    private int rv;
    // 本次输液量
    private int tv;
    // 本次输液时间
    private int tt;
    // 累计量
    private int vi;
    // 压力比
    private byte op;
    // 规格
    private byte spec;
    // 延时时间
    private short delay;

    @Override
    public void parseResponseData(ByteBuf in) {
        deviceState = in.readUnsignedByte();
        realRate = in.readIntLE();
        remainTime = in.readIntLE();
        rv = in.readIntLE();
        tv = in.readIntLE();
        tt = in.readIntLE();
        vi = in.readIntLE();
        op = in.readByte();
        spec = in.readByte();
        delay = in.readShortLE();
    }

    public short getDeviceState() {
        return deviceState;
    }

    public void setDeviceState(short deviceState) {
        this.deviceState = deviceState;
    }

    public int getRealRate() {
        return realRate;
    }

    public void setRealRate(int realRate) {
        this.realRate = realRate;
    }

    public int getRemainTime() {
        return remainTime;
    }

    public void setRemainTime(int remainTime) {
        this.remainTime = remainTime;
    }

    public int getRv() {
        return rv;
    }

    public void setRv(int rv) {
        this.rv = rv;
    }

    public int getTv() {
        return tv;
    }

    public void setTv(int tv) {
        this.tv = tv;
    }

    public int getTt() {
        return tt;
    }

    public void setTt(int tt) {
        this.tt = tt;
    }

    public int getVi() {
        return vi;
    }

    public void setVi(int vi) {
        this.vi = vi;
    }

    public byte getOp() {
        return op;
    }

    public void setOp(byte op) {
        this.op = op;
    }

    public byte getSpec() {
        return spec;
    }

    public void setSpec(byte spec) {
        this.spec = spec;
    }

    public short getDelay() {
        return delay;
    }

    public void setDelay(short delay) {
        this.delay = delay;
    }
}
