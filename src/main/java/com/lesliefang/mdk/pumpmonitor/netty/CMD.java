package com.lesliefang.mdk.pumpmonitor.netty;

public interface CMD {
    // 设备地址查询
    short DEVICE_ADDRESS_ASK = 0x0001;
    // 设备状态查询
    short DEVICE_STATE_ASK = 0x0003;
    // 工作模式查询
    short WORK_MODE_ASK = 0x0004;
    // 中继启动命令
    short WORK_DELAY_START = 0x0005;
    // 中继停止命令
    short WORK_DELAY_STOP = 0x0006;
    // 床位信息查询
    short BED_INFO_ASK = 0x000A;
    // 床位信息下载
    short BED_INFO_DL = 0x000B;
    // 电池电量查询
    short BATTERY_POWER_ASK = 0x000E;
    // 泵号信息下载
    short PUMP_NUM_DL = 0x000F;
    // 输注泵工作日志查询
    short INFUSION_PUMP_LOG_ASK = 0x0011;
    // 输注泵工作信息查询
    short INFUSION_PUMP_WORK_INFO_ASK = 0x0012;
    // 输注泵工作参数查询
    short INFUSION_PUMP_WORK_PARAM_ASK = 0x0013;
    // 输注泵工作参数下载
    short INFUSION_PUMP_WORK_PARAM_DL = 0x0014;
    // 输注泵体重参数查询
    short INFUSION_PUMP_WEIGHT_PARAM_ASK = 0x0015;
    // 输注泵体重参数下载
    short INFUSION_PUMP_WEIGHT_PARAM_DL = 0x0016;

    // 营养泵工作日志查询
    short FEEDING_PUMP_WORK_LOG_ASK = 0x0031;
    // 营养泵工作信息查询
    short FEEDING_PUMP_WORK_INFO_ASK = 0x0032;
    // 营养泵工作参数查询
    short FEEDING_PUMP_WORK_PARAM_ASK = 0x0033;
    // 营养泵工作参数下载
    short FEEDING_PUMP_WORK_PARAM_DL = 0x0034;

    // 重力输液器工作信息查询
    short GC_WORK_INFO_ASK = 0x0040;

    // 同步泵号
    short MS_PUMP_SLOT_SYN = 0x0080;
}
