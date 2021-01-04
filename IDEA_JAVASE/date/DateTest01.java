package com.bjpowernode.javase.date;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
java中对日期的处理
    这个案例最主要掌握：
        知识点1：怎么获取系统当前时间
        知识点2：String --> Date
        知识点3：Date --> String
 */
public class DateTest01 {
    public static void main(String[] args) throws Exception{
        //获取系统当前的时间（精确到毫秒）
        //直接调用无参数构造方法就行
        Date nowTime = new Date();//因为Date方法是在java.util而不是java.lang包中，所以需要导入java.util
        System.out.println(nowTime);//Fri Dec 04 23:14:31 CST 2020     已经重写toString了   CST是国际标准时间

        //日期可以格式化吗？按日期类型按照指定格式转换（适合国人看）：Date --转换成具有一定格式的日期字符串->String
        //SimpleDateFormat是java.text包下的，专门负责日期格式化的。
        /*指定一个日期格式
        yyyy 年（年是4位）
        mm 月（月是2位）
        dd 日（……）
        HH 时
        mm 分
        ss 秒
        SSS 毫秒（1000毫秒代表一秒）
        注意：在日期格式中，除了y M d H m s S这些字符不能随便写之外，剩下的符号格式自己随意组织
         */
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        String nowTimeStr = sdf.format(nowTime);
        System.out.println(nowTimeStr);//2020-12-04 23:24:39 934一直在变

        //假设现在有一个日期字符串String，怎么转换成Date类型？
        String time = "2008-08-08 08:08:08 888";
        //下面的""中的格式不能随便写，要和下面日期格式相同
        //格式不同会出现异常：java.text.ParseException
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        Date dateTime = sdf2.parse(time);//前面用throws Exception处理parse异常
        System.out.println(dateTime);   //Fri Aug 08 08:08:08 CST 2008
    }
}
