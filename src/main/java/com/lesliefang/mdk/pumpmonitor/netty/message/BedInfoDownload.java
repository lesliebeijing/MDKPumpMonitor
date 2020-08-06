package com.lesliefang.mdk.pumpmonitor.netty.message;

import com.lesliefang.mdk.pumpmonitor.netty.CMD;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 * 床位信息下载，只能由上位机设置
 */
public class BedInfoDownload extends RequestMessage {
    private int patientId;
    private short bedNum;

    public BedInfoDownload(int patientId, short bedNum) {
        super(CMD.BED_INFO_DL);
        this.patientId = patientId;
        this.bedNum = bedNum;
    }

    @Override
    public ByteBuf buildRequestData() {
        ByteBuf out = Unpooled.buffer();
        out.writeIntLE(patientId);
        out.writeShortLE(bedNum);
        return out;
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
