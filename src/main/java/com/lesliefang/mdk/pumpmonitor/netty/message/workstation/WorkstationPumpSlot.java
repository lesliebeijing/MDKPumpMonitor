package com.lesliefang.mdk.pumpmonitor.netty.message.workstation;

public class WorkstationPumpSlot {
    private byte[] deviceAddress = new byte[5];

    private byte deviceType;

    public byte[] getDeviceAddress() {
        return deviceAddress;
    }

    public void setDeviceAddress(byte[] deviceAddress) {
        this.deviceAddress = deviceAddress;
    }

    public byte getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(byte deviceType) {
        this.deviceType = deviceType;
    }
}
