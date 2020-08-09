package com.lesliefang.mdk.pumpmonitor.netty.message.infusion;

import com.lesliefang.mdk.pumpmonitor.netty.message.ResponseMessage;
import com.lesliefang.mdk.pumpmonitor.netty.model.infusion.InfusionPumpWorkParam;
import io.netty.buffer.ByteBuf;

public class InfusionPumpWorkParamAskReply extends ResponseMessage {
    private InfusionPumpWorkParam infusionPumpWorkParam;

    @Override
    public void parseResponseData(ByteBuf in) {
        int prescId = in.readIntLE();
        byte[] drugData = new byte[40];
        in.readBytes(drugData);
        int speed = in.readIntLE();
        int time = in.readIntLE();
        int volume = in.readIntLE();
        byte occlu = in.readByte();
        byte brand = in.readByte();
        byte mode = in.readByte();
        infusionPumpWorkParam = new InfusionPumpWorkParam();
        infusionPumpWorkParam.setPrescId(prescId);
        infusionPumpWorkParam.setDrugName(new String(drugData));
        infusionPumpWorkParam.setSpeed(speed);
        infusionPumpWorkParam.setTime(time);
        infusionPumpWorkParam.setVolume(volume);
        infusionPumpWorkParam.setOcclu(occlu);
        infusionPumpWorkParam.setBrand(brand);
        infusionPumpWorkParam.setMode(mode);
    }

    public InfusionPumpWorkParam getInfusionPumpWorkParam() {
        return infusionPumpWorkParam;
    }

    public void setInfusionPumpWorkParam(InfusionPumpWorkParam infusionPumpWorkParam) {
        this.infusionPumpWorkParam = infusionPumpWorkParam;
    }
}
