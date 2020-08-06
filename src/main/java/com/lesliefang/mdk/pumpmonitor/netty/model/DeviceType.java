package com.lesliefang.mdk.pumpmonitor.netty.model;

/**
 * 设备类型
 */
public interface DeviceType {
    // 输液泵
    short INFUSION_PUMP = 0x01;
    // 注射泵
    short INJECTION_PUMP = 0x02;
    // 营养泵
    short NUTRITION_PUMP = 0x03;
    // 输血泵
    short BLOOD_PUMP = 0x04;
    // 镇痛泵
    short ANALGESIC_PUMP = 0X05;
    // 胰岛素泵
    short INSULIN_PUMP = 0x06;
    // 多通道输液泵
    short MULTI_CHANNEL_INFUSION_PUMP = 0x11;
    // 多通道注射泵
    short MULTI_CHANNEL_INJECTION_PUMP = 0X12;
    // 重力输液器MC1
    short GRAVITY_DROP_MC1 = 0x21;
    // 重力输液器MC2
    short GRAVITY_DROP_MC2 = 0x22;
    // 输注工作站
    short INFUSION_WORKSTATION = 0x80;
    // 工作站输液泵
    short WORKSTATION_INFUSION_PUMP = 0x81;
    // 工作站注射泵
    short WORKSTATION_INJECTION_PUMP = 0x82;
}
