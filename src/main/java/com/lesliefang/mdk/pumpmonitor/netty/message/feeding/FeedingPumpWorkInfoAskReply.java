package com.lesliefang.mdk.pumpmonitor.netty.message.feeding;

import com.lesliefang.mdk.pumpmonitor.netty.message.ResponseMessage;
import io.netty.buffer.ByteBuf;

public class FeedingPumpWorkInfoAskReply extends ResponseMessage {
    // 设备状态
    private short deviceState;
    // 实时流速
    private short realRate;
    // 剩余时间
    private int remainTime;
    // 剩余量
    private short rv;
    // 累积量
    private short vi;
    // 下次启动时间
    private int waitTime;
    // 喂水剩余时间
    private int waterRemainTime;
    // 剩余水量
    private short wrv;
    // 水量
    private short wvi;

    @Override
    public void parseResponseData(ByteBuf in) {
        deviceState = in.readUnsignedByte();
        realRate = in.readShortLE();
        remainTime = in.readIntLE();
        rv = in.readShortLE();
        vi = in.readShortLE();
        waitTime = in.readIntLE();
        waterRemainTime = in.readIntLE();
        wrv = in.readShortLE();
        wvi = in.readShortLE();
    }

    public short getDeviceState() {
        return deviceState;
    }

    public void setDeviceState(short deviceState) {
        this.deviceState = deviceState;
    }

    public short getRealRate() {
        return realRate;
    }

    public void setRealRate(short realRate) {
        this.realRate = realRate;
    }

    public int getRemainTime() {
        return remainTime;
    }

    public void setRemainTime(int remainTime) {
        this.remainTime = remainTime;
    }

    public short getRv() {
        return rv;
    }

    public void setRv(short rv) {
        this.rv = rv;
    }

    public short getVi() {
        return vi;
    }

    public void setVi(short vi) {
        this.vi = vi;
    }

    public int getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(int waitTime) {
        this.waitTime = waitTime;
    }

    public int getWaterRemainTime() {
        return waterRemainTime;
    }

    public void setWaterRemainTime(int waterRemainTime) {
        this.waterRemainTime = waterRemainTime;
    }

    public short getWrv() {
        return wrv;
    }

    public void setWrv(short wrv) {
        this.wrv = wrv;
    }

    public short getWvi() {
        return wvi;
    }

    public void setWvi(short wvi) {
        this.wvi = wvi;
    }
}
