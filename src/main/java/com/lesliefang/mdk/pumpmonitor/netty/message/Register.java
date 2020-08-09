package com.lesliefang.mdk.pumpmonitor.netty.message;

import com.lesliefang.mdk.pumpmonitor.netty.CMD;
import com.lesliefang.mdk.pumpmonitor.netty.message.feeding.FeedingPumpWorkInfoAskReply;
import com.lesliefang.mdk.pumpmonitor.netty.message.feeding.FeedingPumpWorkLogAskReply;
import com.lesliefang.mdk.pumpmonitor.netty.message.feeding.FeedingPumpWorkParamAskReply;
import com.lesliefang.mdk.pumpmonitor.netty.message.feeding.FeedingPumpWorkParamDownloadReply;
import com.lesliefang.mdk.pumpmonitor.netty.message.gravity.GravityWorkInfoAskReply;
import com.lesliefang.mdk.pumpmonitor.netty.message.infusion.*;
import com.lesliefang.mdk.pumpmonitor.netty.message.workstation.PumpSlotSyncAskReply;

import java.util.HashMap;
import java.util.Map;

public class Register {
    public static Map<Short, Class<? extends ResponseMessage>> responseMessageMap = new HashMap<>();

    static {
        responseMessageMap.put(CMD.DEVICE_ADDRESS_ASK, DeviceAddressAskReply.class);
        responseMessageMap.put(CMD.DEVICE_STATE_ASK, DeviceStateAskReply.class);
        responseMessageMap.put(CMD.WORK_MODE_ASK, WorkModeAskReply.class);
        responseMessageMap.put(CMD.BED_INFO_ASK, BedInfoAskReply.class);
        responseMessageMap.put(CMD.BED_INFO_DL, BedInfoDownloadReply.class);
        responseMessageMap.put(CMD.BATTERY_POWER_ASK, BatteryPowerAskReply.class);
        responseMessageMap.put(CMD.PUMP_NUM_DL, PumpNumDownloadReply.class);
        responseMessageMap.put(CMD.INFUSION_PUMP_LOG_ASK, InfusionPumpLogAskReply.class);
        responseMessageMap.put(CMD.INFUSION_PUMP_WORK_INFO_ASK, InfusionPumpWorkInfoAskReply.class);
        responseMessageMap.put(CMD.INFUSION_PUMP_WORK_PARAM_ASK, InfusionPumpWorkParamAskReply.class);
        responseMessageMap.put(CMD.INFUSION_PUMP_WORK_PARAM_DL, InfusionWorkParamDownloadReply.class);
        responseMessageMap.put(CMD.INFUSION_PUMP_WEIGHT_PARAM_ASK, InfusionPumpWeightParamAskReply.class);
        responseMessageMap.put(CMD.INFUSION_PUMP_WEIGHT_PARAM_DL, InfusionPumpWeightParamDownloadReply.class);

        responseMessageMap.put(CMD.FEEDING_PUMP_WORK_LOG_ASK, FeedingPumpWorkLogAskReply.class);
        responseMessageMap.put(CMD.FEEDING_PUMP_WORK_INFO_ASK, FeedingPumpWorkInfoAskReply.class);
        responseMessageMap.put(CMD.FEEDING_PUMP_WORK_PARAM_ASK, FeedingPumpWorkParamAskReply.class);
        responseMessageMap.put(CMD.FEEDING_PUMP_WORK_PARAM_DL, FeedingPumpWorkParamDownloadReply.class);

        responseMessageMap.put(CMD.GC_WORK_INFO_ASK, GravityWorkInfoAskReply.class);

        responseMessageMap.put(CMD.MS_PUMP_SLOT_SYN, PumpSlotSyncAskReply.class);

    }
}
