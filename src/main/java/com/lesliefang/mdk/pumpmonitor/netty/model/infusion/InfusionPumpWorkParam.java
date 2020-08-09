package com.lesliefang.mdk.pumpmonitor.netty.model.infusion;

/**
 * 输注泵工作参数
 */
public class InfusionPumpWorkParam {
    // 处方ID
    private int prescId;
    // 药名
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

    @Override
    public String toString() {
        return "InfusionPumpWorkParam{" +
                "prescId=" + prescId +
                ", drugName='" + drugName + '\'' +
                ", speed=" + speed +
                ", time=" + time +
                ", volume=" + volume +
                ", occlu=" + occlu +
                ", brand=" + brand +
                ", mode=" + mode +
                '}';
    }
}
