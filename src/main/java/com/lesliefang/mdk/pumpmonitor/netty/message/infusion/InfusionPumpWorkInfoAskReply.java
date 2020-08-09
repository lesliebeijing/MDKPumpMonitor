package com.lesliefang.mdk.pumpmonitor.netty.message.infusion;

import com.lesliefang.mdk.pumpmonitor.netty.message.ResponseMessage;
import com.lesliefang.mdk.pumpmonitor.netty.model.infusion.InfusionPumpWorkInfo;
import io.netty.buffer.ByteBuf;

public class InfusionPumpWorkInfoAskReply extends ResponseMessage {
    private InfusionPumpWorkInfo infusionPumpWorkInfo;

    @Override
    public void parseResponseData(ByteBuf in) {
        short deviceState = in.readUnsignedByte();
        int realRate = in.readIntLE();
        int remainTime = in.readIntLE();
        int rv = in.readIntLE();
        int tv = in.readIntLE();
        int tt = in.readIntLE();
        int vi = in.readIntLE();
        byte op = in.readByte();
        byte spec = in.readByte();
        short delay = in.readShortLE();
        infusionPumpWorkInfo = new InfusionPumpWorkInfo();
        infusionPumpWorkInfo.setDeviceState(deviceState);
        infusionPumpWorkInfo.setRealRate(realRate);
        infusionPumpWorkInfo.setRemainTime(remainTime);
        infusionPumpWorkInfo.setRv(rv);
        infusionPumpWorkInfo.setTv(tv);
        infusionPumpWorkInfo.setTt(tt);
        infusionPumpWorkInfo.setVi(vi);
        infusionPumpWorkInfo.setOp(op);
        infusionPumpWorkInfo.setSpec(spec);
        infusionPumpWorkInfo.setDelay(delay);
    }

    public InfusionPumpWorkInfo getInfusionPumpWorkInfo() {
        return infusionPumpWorkInfo;
    }

    public void setInfusionPumpWorkInfo(InfusionPumpWorkInfo infusionPumpWorkInfo) {
        this.infusionPumpWorkInfo = infusionPumpWorkInfo;
    }
}
