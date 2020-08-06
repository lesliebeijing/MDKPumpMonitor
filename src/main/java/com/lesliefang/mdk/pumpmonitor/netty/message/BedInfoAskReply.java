package com.lesliefang.mdk.pumpmonitor.netty.message;

import io.netty.buffer.ByteBuf;

public class BedInfoAskReply extends ResponseMessage {
    private int patientId;
    private short bedNum;

    @Override
    public void parseResponseData(ByteBuf in) {
        patientId = in.readIntLE();
        bedNum = in.readShortLE();
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public short getBedNum() {
        return bedNum;
    }

    public void setBedNum(short bedNum) {
        this.bedNum = bedNum;
    }
}
