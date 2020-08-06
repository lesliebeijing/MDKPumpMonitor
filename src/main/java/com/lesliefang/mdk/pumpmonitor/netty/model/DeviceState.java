package com.lesliefang.mdk.pumpmonitor.netty.model;

/**
 * 设备状态字
 */
public interface DeviceState {
    // 未知状态
    short DEVICE_STAT_NM_UNKNOWN = 0x00;
    // 待机状态
    short DEVICE_STAT_NM_STANDBY = 0x01;
    // 输液状态
    short DEVICE_STAT_NM_INFUSION = 0x02;
    // 注射状态
    short DEVICE_STAT_NM_INJECTING = 0x03;
    // 标定状态
    short DEVICE_STAT_NM_CALIBRATION = 0x04;
    // 自动快进状态
    short DEVICE_STAT_NM_PURGE_AUTO = 0x05;
    // 手动快进状态
    short DEVICE_STAT_NM_PURGE_MANUAL = 0x06;
    // 自动丸剂状态
    short DEVICE_STAT_NM_BOLUS_AUTO = 0x07;
    // 手动丸剂状态
    short DEVICE_STAT_NM_BOLUS_MANUAL = 0x08;
    // 营养液喂养状态
    short DEVICE_STAT_NM_NUTRIENT_FEEDING = 0x09;
    // 水喂养状态
    short DEVICE_STAT_NM_WATER_FEEDING = 0x0A;
    // 中继等待指令
    short DEVICE_STAT_NM_RELAY_WAIT_PRS_START = 0x0B;
    // 中继等待开始命令
    short DEVICE_STAT_NM_RELAY_WAIT_BEGIN_CMD = 0x0C;
    // 中继输液开始
    short DEVICE_STAT_NM_RELAY_BEGIN_INFUSION = 0x0D;
    // 延时输液开始
    short DEVICE_STAT_NM_DELAY_BEGIN_INFUSION = 0x0F;

    // 暂停超时
    short DEVICE_STAT_EC_OVERTIME = 0x40;
    // 接近完成
    short DEVICE_STAT_EC_NEAR_COMPLETE = 0x41;
    // 电量低
    short DEVICE_STAT_EC_BAT_LOW = 0x43;
    // 阻塞报警
    short DEVICE_STAT_EC_PIPE_BLOCK = 0x50;
    // 电池耗尽
    short DEVICE_STAT_EC_BAT_EMPTY = 0x51;
    // 气泡报警
    short DEVICE_STAT_EC_BUBBLE = 0x54;
    // 开门报警
    short DEVICE_STAT_EC_DOOR_OPEN = 0x55;
    // 规格错误
    short DEVICE_STAT_EC_SPECIFICATION = 0x56;
    // 注射器推柄错误
    short DEVICE_STAT_EC_INJECTOR_HANDLE = 0x58;
    // 输注完成
    short DEVICE_STAT_EC_COMPLETION = 0x5B;
    // 上阻塞报警
    short DEVICE_STAT_EC_UPPER_BLOCK = 0x5D;
    // 输液管安装错误
    short DEVICE_STAT_TUBE_ERROR = 0x5E;
    // 止液夹错误
    short DEVICE_STAT_CLAMP_ERROR = 0x5F;

    // 电机故障
    short DEVICE_STAT_BD_MOTOR = 0x80;
    // 通讯故障
    short DEVICE_STAT_BD_MAIN_CPU = 0x83;
    // 内电通讯故障
    short DEVICE_STAT_BAT_MOTOR = 0x85;
}
