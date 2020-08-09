package com.lesliefang.mdk.pumpmonitor.netty.model;

public class DeviceContext {
    // sn 序列号
    protected String sn;
    // 设备类型
    protected Short deviceType;
    // 状态字
    protected short deviceState;
    // 床号
    protected String bedNum;
    // 泵号
    protected int slotNum;

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getBedNum() {
        return bedNum;
    }

    public void setBedNum(String bedNum) {
        this.bedNum = bedNum;
    }

    public int getSlotNum() {
        return slotNum;
    }

    public void setSlotNum(int slotNum) {
        this.slotNum = slotNum;
    }

    public Short getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Short deviceType) {
        this.deviceType = deviceType;
    }

    public short getDeviceState() {
        return deviceState;
    }

    public void setDeviceState(short deviceState) {
        this.deviceState = deviceState;
    }
}
