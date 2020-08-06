package com.lesliefang.mdk.pumpmonitor.netty.message.infusion;

import com.lesliefang.mdk.pumpmonitor.netty.message.ResponseMessage;
import io.netty.buffer.ByteBuf;

public class InfusionPumpWorkParamAskReply extends ResponseMessage {
    // 处方ID
    private int prescId;
    private String drugName;
    // 速度
    private int speed;
    // 时间
    private int time;
    // 总量
    private int volume;
    // 压力
    private byte occlu;
    // 耗材
    private byte brand;
    // 工作模式
    private byte mode;

    @Override
    public void parseResponseData(ByteBuf in) {
        prescId = in.readIntLE();
        speed = in.readIntLE();
        time = in.readIntLE();
        volume = in.readIntLE();
        occlu = in.readByte();
        brand = in.readByte();
        mode = in.readByte();
    }

    public int getPrescId() {
        return prescId;
    }

    public void setPrescId(int prescId) {
        this.prescId = prescId;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
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
