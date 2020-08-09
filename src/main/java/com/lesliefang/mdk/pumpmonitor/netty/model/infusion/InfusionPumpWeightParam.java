package com.lesliefang.mdk.pumpmonitor.netty.model.infusion;

/**
 * 输注泵体重参数
 */
public class InfusionPumpWeightParam {
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

    @Override
    public String toString() {
        return "InfusionPumpWeightParam{" +
                "dose=" + dose +
                ", amount=" + amount +
                ", volume=" + volume +
                ", weight=" + weight +
                ", doseUnit=" + doseUnit +
                '}';
    }
}
