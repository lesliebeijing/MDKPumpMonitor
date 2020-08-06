package com.lesliefang.mdk.pumpmonitor.netty.message.infusion;

import com.lesliefang.mdk.pumpmonitor.netty.CMD;
import com.lesliefang.mdk.pumpmonitor.netty.message.RequestMessage;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 * 输注泵工作参数下载
 */
public class InfusionWorkParamDownload extends RequestMessage {
    private int prescId;
    private String drugName;
    private int speed;
    private int time;
    private int volume;
    private byte occlu;
    private byte mode;
    private short delay;

    public InfusionWorkParamDownload() {
        super(CMD.INFUSION_PUMP_WORK_PARAM_DL);
    }

    @Override
    public ByteBuf buildRequestData() {
        ByteBuf out = Unpooled.buffer();
        out.writeIntLE(prescId);
        byte[] drugData = new byte[40];
        if (drugName != null) {
            byte[] drugBytes = drugName.getBytes();
            int len = drugBytes.length > 40 ? 40 : drugBytes.length;
            System.arraycopy(drugBytes, 0, drugData, 0, len);
        }
        out.writeBytes(drugData);
        out.writeIntLE(speed);
        out.writeIntLE(time);
        out.writeIntLE(volume);
        out.writeByte(occlu);
        out.writeByte(mode);
        out.writeShortLE(delay);
        return out;
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
