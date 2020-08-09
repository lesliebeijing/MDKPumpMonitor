package com.lesliefang.mdk.pumpmonitor.netty.message.infusion;

import com.lesliefang.mdk.pumpmonitor.netty.message.ResponseMessage;
import com.lesliefang.mdk.pumpmonitor.netty.model.infusion.InfusionPumpWeightParam;
import io.netty.buffer.ByteBuf;

public class InfusionPumpWeightParamAskReply extends ResponseMessage {
    private InfusionPumpWeightParam infusionPumpWeightParam;

    @Override
    public void parseResponseData(ByteBuf in) {
        int dose = in.readIntLE();
        int amount = in.readInt();
        int volume = in.readIntLE();
        short weight = in.readShortLE();
        byte doseUnit = in.readByte();
        infusionPumpWeightParam = new InfusionPumpWeightParam();
        infusionPumpWeightParam.setDose(dose);
        infusionPumpWeightParam.setAmount(amount);
        infusionPumpWeightParam.setVolume(volume);
        infusionPumpWeightParam.setWeight(weight);
        infusionPumpWeightParam.setDoseUnit(doseUnit);
    }

    public InfusionPumpWeightParam getInfusionPumpWeightParam() {
        return infusionPumpWeightParam;
    }

    public void setInfusionPumpWeightParam(InfusionPumpWeightParam infusionPumpWeightParam) {
        this.infusionPumpWeightParam = infusionPumpWeightParam;
    }
}
