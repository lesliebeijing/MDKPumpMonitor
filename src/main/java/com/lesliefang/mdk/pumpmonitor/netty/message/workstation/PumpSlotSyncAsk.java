package com.lesliefang.mdk.pumpmonitor.netty.message.workstation;

import com.lesliefang.mdk.pumpmonitor.netty.CMD;
import com.lesliefang.mdk.pumpmonitor.netty.message.RequestMessage;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.util.List;

/**
 * 同步泵号
 * N组取值6、9、12等，工作站在应答《设备地址查询（DEVICE_ADDR_ASK）》命令后，
 * 或者在修改完泵号后需要主动调用该命令向服务端同步泵号。
 */
public class PumpSlotSyncAsk extends RequestMessage {

    private List<WorkstationPumpSlot> pumpSlotList;

    public PumpSlotSyncAsk() {
        super(CMD.MS_PUMP_SLOT_SYN);
    }

    @Override
    public ByteBuf buildRequestData() {
        if (pumpSlotList == null) {
            return null;
        }
        ByteBuf out = Unpooled.buffer();
        for (WorkstationPumpSlot slot : pumpSlotList) {
            out.writeBytes(slot.getDeviceAddress());
            out.writeByte(slot.getDeviceType());
        }
        return out;
    }

    public List<WorkstationPumpSlot> getPumpSlotList() {
        return pumpSlotList;
    }

    public void setPumpSlotList(List<WorkstationPumpSlot> pumpSlotList) {
        this.pumpSlotList = pumpSlotList;
    }
}
