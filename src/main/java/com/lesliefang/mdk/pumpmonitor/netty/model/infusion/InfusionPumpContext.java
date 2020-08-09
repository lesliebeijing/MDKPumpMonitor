package com.lesliefang.mdk.pumpmonitor.netty.model.infusion;

import com.lesliefang.mdk.pumpmonitor.netty.model.DeviceContext;

public class InfusionPumpContext extends DeviceContext {
    private InfusionPumpWorkParam workParam;

    private InfusionPumpWorkInfo workInfo;

    private InfusionPumpWeightParam weightParam;

    public InfusionPumpWorkParam getWorkParam() {
        return workParam;
    }

    public void setWorkParam(InfusionPumpWorkParam workParam) {
        this.workParam = workParam;
    }

    public InfusionPumpWorkInfo getWorkInfo() {
        return workInfo;
    }

    public void setWorkInfo(InfusionPumpWorkInfo workInfo) {
        this.workInfo = workInfo;
    }

    public InfusionPumpWeightParam getWeightParam() {
        return weightParam;
    }

    public void setWeightParam(InfusionPumpWeightParam weightParam) {
        this.weightParam = weightParam;
    }

    @Override
    public String toString() {
        return "InfusionPumpContext{" +
                "sn='" + sn + '\'' +
                ", deviceType=" + deviceType +
                ", deviceState=" + deviceState +
                ", bedNum='" + bedNum + '\'' +
                ", slotNum=" + slotNum +
                ", workParam=" + workParam +
                ", workInfo=" + workInfo +
                ", weightParam=" + weightParam +
                '}';
    }
}
