package com.lesliefang.mdk.pumpmonitor.netty.model.infusion;

/**
 * 输注泵工作日志
 */
public class InfusionPumpLog {
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
    private String drugName;
    private int rate;
    private int time;
    private int vtbi; // 总量
    private int vi; // 累积量
    private int dose; // 剂量
    private int amount; // 药量
    private int volume; // 溶液量
    private short weight; // 体重
    private byte doseUnit; // 剂量单位
    private byte occlu; // 压力
    private byte brand; // 耗材
    private byte mode; // 工作模式
    private int prescId; // 处方ID

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

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getVtbi() {
        return vtbi;
    }

    public void setVtbi(int vtbi) {
        this.vtbi = vtbi;
    }

    public int getVi() {
        return vi;
    }

    public void setVi(int vi) {
        this.vi = vi;
    }

    public int getDose() {
        return dose;
    }

    public void setDose(int dose) {
        this.dose = dose;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public short getWeight() {
        return weight;
    }

    public void setWeight(short weight) {
        this.weight = weight;
    }

    public byte getDoseUnit() {
        return doseUnit;
    }

    public void setDoseUnit(byte doseUnit) {
        this.doseUnit = doseUnit;
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

    public int getPrescId() {
        return prescId;
    }

    public void setPrescId(int prescId) {
        this.prescId = prescId;
    }
}
