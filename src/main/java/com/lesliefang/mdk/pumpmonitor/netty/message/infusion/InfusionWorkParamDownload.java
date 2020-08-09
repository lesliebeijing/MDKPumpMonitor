package com.lesliefang.mdk.pumpmonitor.netty.message.infusion;

import com.lesliefang.mdk.pumpmonitor.netty.CMD;
import com.lesliefang.mdk.pumpmonitor.netty.message.RequestMessage;
import com.lesliefang.mdk.pumpmonitor.netty.model.infusion.InfusionPumpWorkParamSet;
import com.sun.istack.internal.NotNull;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 * 输注泵工作参数下载
 */
public class InfusionWorkParamDownload extends RequestMessage {
    private InfusionPumpWorkParamSet infusionPumpWorkParamSet;

    public InfusionWorkParamDownload(@NotNull InfusionPumpWorkParamSet infusionPumpWorkParamSet) {
        super(CMD.INFUSION_PUMP_WORK_PARAM_DL);
        this.infusionPumpWorkParamSet = infusionPumpWorkParamSet;
    }

    @Override
    public ByteBuf buildRequestData() {
        ByteBuf out = Unpooled.buffer();
        out.writeIntLE(infusionPumpWorkParamSet.getPrescId());
        byte[] drugData = new byte[40];
        String drugName = infusionPumpWorkParamSet.getDrugName();
        if (drugName != null) {
            byte[] drugBytes = drugName.getBytes();
            int len = drugBytes.length > 40 ? 40 : drugBytes.length;
            System.arraycopy(drugBytes, 0, drugData, 0, len);
        }
        out.writeBytes(drugData);
        out.writeIntLE(infusionPumpWorkParamSet.getSpeed());
        out.writeIntLE(infusionPumpWorkParamSet.getTime());
        out.writeIntLE(infusionPumpWorkParamSet.getVolume());
        out.writeByte(infusionPumpWorkParamSet.getOcclu());
        out.writeByte(infusionPumpWorkParamSet.getMode());
        out.writeShortLE(infusionPumpWorkParamSet.getDelay());
        return out;
    }

    public InfusionPumpWorkParamSet getInfusionPumpWorkParamSet() {
        return infusionPumpWorkParamSet;
    }

    public void setInfusionPumpWorkParamSet(InfusionPumpWorkParamSet infusionPumpWorkParamSet) {
        this.infusionPumpWorkParamSet = infusionPumpWorkParamSet;
    }
}
