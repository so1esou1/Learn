package com.csu.adapter.classadapter;
/*
    适配器类
 */
public class VoltageAdapter extends Voltage220V implements IVoltage5V {
    @Override
    public int output5V() {
        //获取到220V的电压
        int srcV = output220V();
        int dstV = srcV / 44;
        return dstV;
    }
}
