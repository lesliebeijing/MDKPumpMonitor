package com.lesliefang.mdk.pumpmonitor.netty.message.feeding;

import com.lesliefang.mdk.pumpmonitor.netty.message.ResponseMessage;
import io.netty.buffer.ByteBuf;

public class FeedingPumpWorkLogAskReply extends ResponseMessage {
    private int logId;
    private short year;
    private byte month;
    private byte day;
    private byte hour;
    private byte minute;
    private byte second;
    private short eventId;
    private short bedNum;
    private int patientId;
    private short rate;
    private int time;
    private short vtbti; // 总量
    private short vi; // 累积量
    private byte count; // 次数
    private int waitTime; // 间隔时间
    private short waterRate; // 喂水速度
    private short waterVolume; // 数量
    private int waterWaitTime; // 水间隔
    private byte occlu;
    private byte brand;
    private byte mode;

    @Override
    public void parseResponseData(ByteBuf in) {
        logId = in.readIntLE();
        year = in.readShortLE();
        month = in.readByte();
        day = in.readByte();
        hour = in.readByte();
        minute = in.readByte();
        second = in.readByte();
        eventId = in.readShortLE();
        bedNum = in.readShortLE();
        patientId = in.readIntLE();
        rate = in.readShortLE();
        vtbti = in.readShortLE();
        vi = in.readShortLE();
        count = in.readByte();
        waitTime = in.readIntLE();
        waterRate = in.readShortLE();
        waterVolume = in.readShortLE();
        waterWaitTime = in.readIntLE();
        occlu = in.readByte();
        brand = in.readByte();
        month = in.readByte();
    }

    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }

    public short getYear() {
        return year;
    }

    public void setYear(short year) {
        this.year = year;
    }

    public byte getMonth() {
        return month;
    }

    public void setMonth(byte month) {
        this.month = month;
    }

    public byte getDay() {
        return day;
    }

    public void setDay(byte day) {
        this.day = day;
    }

    public byte getHour() {
        return hour;
    }

    public void setHour(byte hour) {
        this.hour = hour;
    }

    public byte getMinute() {
        return minute;
    }

    public void setMinute(byte minute) {
        this.minute = minute;
    }

    public byte getSecond() {
        return second;
    }

    public void setSecond(byte second) {
        this.second = second;
    }

    public short getEventId() {
        return eventId;
    }

    public void setEventId(short eventId) {
        this.eventId = eventId;
    }

    public short getBedNum() {
        return bedNum;
    }

    public void setBedNum(short bedNum) {
        this.bedNum = bedNum;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public short getRate() {
        return rate;
    }

    public void setRate(short rate) {
        this.rate = rate;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public short getVtbti() {
        return vtbti;
    }

    public void setVtbti(short vtbti) {
        this.vtbti = vtbti;
    }

    public short getVi() {
        return vi;
    }

    public void setVi(short vi) {
        this.vi = vi;
    }

    public short getWaterVolume() {
        return waterVolume;
    }

    public void setWaterVolume(short waterVolume) {
        this.waterVolume = waterVolume;
    }

    public byte getCount() {
        return count;
    }

    public void setCount(byte count) {
        this.count = count;
    }

    public int getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(int waitTime) {
        this.waitTime = waitTime;
    }

    public short getWaterRate() {
        return waterRate;
    }

    public void setWaterRate(short waterRate) {
        this.waterRate = waterRate;
    }

    public int getWaterWaitTime() {
        return waterWaitTime;
    }

    public void setWaterWaitTime(int waterWaitTime) {
        this.waterWaitTime = waterWaitTime;
    }

    public byte getOcclu() {
        return occlu;
    }

    public void setOcclu(byte occlu) {
        this.occlu = occlu;
    }

    public byte getBrand() {
        return brand;
    }

    public void setBrand(byte brand) {
        this.brand = brand;
    }

    public byte getMode() {
        return mode;
    }

    public void setMode(byte mode) {
        this.mode = mode;
    }
}
