package com.csu.adapter.objectadapter;
/*
    适配器类
 */
public class VoltageAdapter extends Voltage220V implements IVoltage5V {

    private Voltage220V voltage220V;        //关联关系中的聚合关系
    //通过构造器传入Voltage220V的实例
    public VoltageAdapter(Voltage220V voltage220V) {
        this.voltage220V = voltage220V;
    }

    @Override
    public int output5V() {
        int dst = 0;
        if (null != voltage220V){
            int src = voltage220V.output220V();     //获取220v的电压
            System.out.println("使用对象适配器，进行适配");
            dst = src / 44;
            System.out.println("适配完成，输出电压为:" + dst);
        }
        return dst;
    }
}
