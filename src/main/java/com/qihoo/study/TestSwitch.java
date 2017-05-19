package com.qihoo.study;

import javax.sound.midi.Soundbank;
import java.text.DecimalFormat;

/**
 * Created by luoyong on 17-2-23.
 */
public class TestSwitch {
    private static final DecimalFormat TOW_POINTS_DECIMAL = new DecimalFormat("##################0.00");
    public static void main(String[] args) {
        System.out.println(TOW_POINTS_DECIMAL.format(new Double(775.988)));

//        for(int i=0 ; i< 10 ; i++) {
//            for(int j =0 ; j < 10 ;j++) {
//                if (j == 5) {
//                    break;
//                }
//                System.out.println("j=" + j);
//            }
//            System.out.println("i=" + i);
//        }
//        DemoEnum demoEnum = null;
//        switch (demoEnum) {
//            case ONE:
//                System.out.println("test");
//                break;
//            case SECOND:
//                System.out.println("second");
//                break;
//            default:
//                System.out.println("default");
//
//        }
    }

    public static enum DemoEnum {
        ONE, SECOND, THRID;

    }
}
