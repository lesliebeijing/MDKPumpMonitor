package com.lesliefang.mdk.pumpmonitor.netty.model;

/**
 * 工作模式
 */
public interface WorkMode {
    // R+V
    short RV = 0X01;
    // R+T
    short RT = 0x02;
    // V+T
    short VT = 0x03;
    // 单速模式
    short R = 0x04;
    // 药库模式
    short DRUG = 0x05;
    // 体重模式
    short WEIGHT = 0x06;
    // 连续喂养模式
    short CONTINUED = 0X07;
    // 间歇喂养模式
    short INTERMITTENT = 0x08;

    // 中继R+V
    short RELAY_RV = 0x81;
    // 中继R+T
    short RELAY_RT = 0x82;
    // 中继V+T
    short RELAY_VT = 0x83;
    // 中继单速模式
    short RELAY_R = 0x84;
    // 中继药库模式
    short RELAY_DRUG = 0x85;
    // 中继体重模式
    short RELAY_WEIGHT = 0x86;
}
