package com.lesliefang.mdk.pumpmonitor.netty.message.infusion;

import com.lesliefang.mdk.pumpmonitor.netty.CMD;
import com.lesliefang.mdk.pumpmonitor.netty.message.RequestMessage;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 * 输注泵体重参数下载
 */
public class InfusionPumpWeightParamDownload extends RequestMessage {
    // 剂量
    private int dose;
    // 药量
    private int amount;
    // 溶液量
    private int volume;
    // 体重
    private short weight;
    // 剂量单位
    private byte doseUnit;
    // 压力
    private byte occlu;
    // 工作模式
    private byte mode;
    // 延时
    private short delay;

    public InfusionPumpWeightParamDownload() {
        super(CMD.INFUSION_PUMP_WEIGHT_PARAM_DL);
    }

    @Override
    public ByteBuf buildRequestData() {
        ByteBuf out = Unpooled.buffer();
        out.writeIntLE(dose);
        out.writeIntLE(amount);
        out.writeIntLE(volume);
        out.writeShortLE(weight);
        out.writeByte(doseUnit);
        out.writeByte(occlu);
        out.writeByte(mode);
        out.writeShortLE(delay);
        return out;
    }

    public int getDose() {
        return dose;
    }

    public void setDose(int dose) {
        this.dose = dose;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public short getWeight() {
        return weight;
    }

    public void setWeight(short weight) {
        this.weight = weight;
    }

    public byte getDoseUnit() {
        return doseUnit;
    }

    public void setDoseUnit(byte doseUnit) {
        this.doseUnit = doseUnit;
    }

    public byte getOcclu() {
        return occlu;
    }

    public void setOcclu(byte occlu) {
        this.occlu = occlu;
    }

    public byte getMode() {
        return mode;
    }

    public void setMode(byte mode) {
        this.mode = mode;
    }

    public short getDelay() {
        return delay;
    }

    public void setDelay(short delay) {
        this.delay = delay;
    }
}
