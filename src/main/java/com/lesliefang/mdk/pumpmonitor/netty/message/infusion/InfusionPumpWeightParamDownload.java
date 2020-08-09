package com.lesliefang.mdk.pumpmonitor.netty.message.infusion;

import com.lesliefang.mdk.pumpmonitor.netty.CMD;
import com.lesliefang.mdk.pumpmonitor.netty.message.RequestMessage;
import com.lesliefang.mdk.pumpmonitor.netty.model.infusion.InfusionPumpWeightParamSet;
import com.sun.istack.internal.NotNull;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 * 输注泵体重参数下载
 */
public class InfusionPumpWeightParamDownload extends RequestMessage {
    private InfusionPumpWeightParamSet infusionPumpWeightParamSet;

    public InfusionPumpWeightParamDownload(@NotNull InfusionPumpWeightParamSet infusionPumpWeightParamSet) {
        super(CMD.INFUSION_PUMP_WEIGHT_PARAM_DL);
        this.infusionPumpWeightParamSet = infusionPumpWeightParamSet;
    }

    @Override
    public ByteBuf buildRequestData() {
        ByteBuf out = Unpooled.buffer();
        out.writeIntLE(infusionPumpWeightParamSet.getDose());
        out.writeIntLE(infusionPumpWeightParamSet.getAmount());
        out.writeIntLE(infusionPumpWeightParamSet.getVolume());
        out.writeShortLE(infusionPumpWeightParamSet.getWeight());
        out.writeByte(infusionPumpWeightParamSet.getDoseUnit());
        out.writeByte(infusionPumpWeightParamSet.getOcclu());
        out.writeByte(infusionPumpWeightParamSet.getMode());
        out.writeShortLE(infusionPumpWeightParamSet.getDelay());
        return out;
    }

    public InfusionPumpWeightParamSet getInfusionPumpWeightParamSet() {
        return infusionPumpWeightParamSet;
    }

    public void setInfusionPumpWeightParamSet(InfusionPumpWeightParamSet infusionPumpWeightParamSet) {
        this.infusionPumpWeightParamSet = infusionPumpWeightParamSet;
    }
}
