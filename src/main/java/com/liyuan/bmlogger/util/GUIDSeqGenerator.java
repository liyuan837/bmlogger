package com.liyuan.bmlogger.util;

import java.text.DecimalFormat;
import java.util.UUID;

/**
 * @Author: LiYuan
 * @Description:生成系统唯一ID
 * @Date: 17:46 2018/5/8
 */
public class GUIDSeqGenerator {

    private static GUIDSeqGenerator instance;
    private static int seq;
    private static final int MAX_SEQ = 9999;
    private static String sequence;

    private GUIDSeqGenerator() {
        seq = 9999;
    }

    public static GUIDSeqGenerator getInstance() {
        if (instance == null)
            instance = new GUIDSeqGenerator();

        return instance;
    }

    public String newGUID(String seqGUID) {
        StringBuilder sb = new StringBuilder();
        synchronized (this) {
            if (seq == 9999) {
                sequence = UUID.randomUUID().toString().toUpperCase().substring(0,8);
                seqGUID += sequence;
                seq = 1;
            } else {
                seqGUID += sequence;
                seq += 1;
            }
            sb.append(String.format("%s-%s", new Object[]{seqGUID, fillString(seq)}));
        }
        return sb.toString();
    }

    private String fillString(int p_seq) {
        DecimalFormat df = new DecimalFormat("0000");
        return df.format(p_seq);
    }

    public static void main(String[] args){
        for (int i=0;i<100000;i++){
            System.out.println(GUIDSeqGenerator.getInstance().newGUID("RC"));
        }
    }
}
