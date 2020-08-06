package com.lesliefang.mdk.pumpmonitor.netty.util;

public class Address {
    public static String parsePumpAddress(byte[] address) {
        if (address == null || address.length != 5) {
            return null;
        }
        int[] arr = new int[address.length];
        for (int i = 0; i < address.length; i++) {
            arr[i] = address[i] & 0xff;
        }
        return parsePumpAddress(arr);
    }

    public static String parsePumpAddress(int[] address) {
        if (address == null || address.length != 5) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int pt = address[4] >> 2;
        char cpt = (char) (pt + 'A' - 1);
        sb.append(cpt);

        int v1 = ((address[4] & 0x03) << 8 | address[3] & 0xe0) >> 5;
        char cv1;
        if (v1 < 10) {
            cv1 = (char) (v1 + '0');
        } else {
            cv1 = (char) (v1 + 'A' - 10);
        }
        sb.append(cv1);

        int v2 = address[3] & 0x1f;
        char cv2;
        if (v2 < 10) {
            cv2 = (char) (v2 + '0');
        } else {
            cv2 = (char) (v2 + 'A' - 10);
        }
        sb.append(cv2);

        int bn = address[2] & 0x7f;
        String sbn = bn + "";
        if (bn < 10) {
            sbn = "0" + bn;
        }
        sb.append(sbn);

        int pn = ((address[0] & 0xc0) | address[1] << 8) >> 6;
        String spn = pn + "";
        if (pn < 10) {
            spn = "00" + pn;
        } else if (pn < 100) {
            spn = "0" + pn;
        }
        sb.append(spn);

        int yn = address[0] & 0x3f;
        char cyn = (char) (yn + 'A' - 1);
        sb.append(cyn);

        return sb.toString();
    }
}
