package com.lesliefang.mdk.pumpmonitor.netty.message.infusion;

import com.lesliefang.mdk.pumpmonitor.netty.message.ResponseMessage;
import com.lesliefang.mdk.pumpmonitor.netty.model.infusion.InfusionPumpLog;
import io.netty.buffer.ByteBuf;
import io.netty.util.CharsetUtil;

public class InfusionPumpLogAskReply extends ResponseMessage {
    private InfusionPumpLog infusionPumpLog;

    @Override
    public void parseResponseData(ByteBuf in) {
        int logId = in.readIntLE();
        short year = in.readShortLE();
        byte month = in.readByte();
        byte day = in.readByte();
        byte hour = in.readByte();
        byte minute = in.readByte();
        byte second = in.readByte();
        short eventId = in.readShortLE();
        short bedNum = in.readShortLE();
        int patientId = in.readIntLE();
        byte[] drugBytes = new byte[40];
        in.readBytes(drugBytes);
        String drugName = new String(drugBytes, CharsetUtil.UTF_8);
        int rate = in.readIntLE();
        int time = in.readIntLE();
        int vtbi = in.readIntLE();
        int vi = in.readIntLE();
        int dose = in.readIntLE();
        int amount = in.readIntLE();
        int volume = in.readIntLE();
        short weight = in.readShortLE();
        byte doseUnit = in.readByte();
        byte occlu = in.readByte();
        byte brand = in.readByte();
        byte mode = in.readByte();
        int prescId = in.readIntLE();
        infusionPumpLog = new InfusionPumpLog();
        infusionPumpLog.setLogId(logId);
        infusionPumpLog.setYear(year);
        infusionPumpLog.setMonth(month);
        infusionPumpLog.setDay(day);
        infusionPumpLog.setHour(hour);
        infusionPumpLog.setMinute(minute);
        infusionPumpLog.setSecond(second);
        infusionPumpLog.setEventId(eventId);
        infusionPumpLog.setBedNum(bedNum);
        infusionPumpLog.setPatientId(patientId);
        infusionPumpLog.setDrugName(drugName);
        infusionPumpLog.setRate(rate);
        infusionPumpLog.setTime(time);
        infusionPumpLog.setVtbi(vtbi);
        infusionPumpLog.setVi(vi);
        infusionPumpLog.setDose(dose);
        infusionPumpLog.setAmount(amount);
        infusionPumpLog.setVolume(volume);
        infusionPumpLog.setWeight(weight);
        infusionPumpLog.setDoseUnit(doseUnit);
        infusionPumpLog.setOcclu(occlu);
        infusionPumpLog.setBrand(brand);
        infusionPumpLog.setMode(mode);
        infusionPumpLog.setPrescId(prescId);
    }

    public InfusionPumpLog getInfusionPumpLog() {
        return infusionPumpLog;
    }

    public void setInfusionPumpLog(InfusionPumpLog infusionPumpLog) {
        this.infusionPumpLog = infusionPumpLog;
    }
}
