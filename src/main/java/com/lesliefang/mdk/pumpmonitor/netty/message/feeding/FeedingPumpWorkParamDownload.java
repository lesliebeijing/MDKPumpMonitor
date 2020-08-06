package com.lesliefang.mdk.pumpmonitor.netty.message.feeding;

import com.lesliefang.mdk.pumpmonitor.netty.CMD;
import com.lesliefang.mdk.pumpmonitor.netty.message.RequestMessage;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 * 营养泵工作参数下载
 */
public class FeedingPumpWorkParamDownload extends RequestMessage {
    // 速度
    private short rate;
    // 时间
    private int time;
    // 总量
    private short volume;
    // 次数
    private byte count;
    // 间隔时间
    private int waitTime;
    // 喂水速度
    private short waterRate;
    // 水量
    private short waterVolume;
    // 水间隔
    private int waterWaitTime;
    // 压力
    private byte occlu;
    // 耗材
    private byte brand;
    // 工作模式
    private byte mode;

    public FeedingPumpWorkParamDownload() {
        super(CMD.FEEDING_PUMP_WORK_PARAM_DL);
    }

    @Override
    public ByteBuf buildRequestData() {
        ByteBuf out = Unpooled.buffer();
        out.writeShortLE(rate);
        out.writeIntLE(time);
        out.writeShortLE(volume);
        out.writeByte(count);
        out.writeIntLE(waitTime);
        out.writeShortLE(waterRate);
        out.writeShortLE(waterVolume);
        out.writeIntLE(waterWaitTime);
        out.writeByte(occlu);
        out.writeByte(brand);
        out.writeByte(mode);
        return out;
    }

    public short getRate() {
        return rate;
    }

    public void setRate(short rate) {
        this.rate = rate;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public short getVolume() {
        return volume;
    }

    public void setVolume(short volume) {
        this.volume = volume;
    }

    public byte getCount() {
        return count;
    }

    public void setCount(byte count) {
        this.count = count;
    }

    public int getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(int waitTime) {
        this.waitTime = waitTime;
    }

    public short getWaterRate() {
        return waterRate;
    }

    public void setWaterRate(short waterRate) {
        this.waterRate = waterRate;
    }

    public short getWaterVolume() {
        return waterVolume;
    }

    public void setWaterVolume(short waterVolume) {
        this.waterVolume = waterVolume;
    }

    public int getWaterWaitTime() {
        return waterWaitTime;
    }

    public void setWaterWaitTime(int waterWaitTime) {
        this.waterWaitTime = waterWaitTime;
    }

    public byte getOcclu() {
        return occlu;
    }

    public void setOcclu(byte occlu) {
        this.occlu = occlu;
    }

    public byte getBrand() {
        return brand;
    }

    public void setBrand(byte brand) {
        this.brand = brand;
    }

    public byte getMode() {
        return mode;
    }

    public void setMode(byte mode) {
        this.mode = mode;
    }
}
