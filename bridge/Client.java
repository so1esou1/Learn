package com.csu.bridge;

public class Client {
    public static void main(String[] args) {
        //获取折叠式手机:样式+品牌
        FoldedPhone phone1 = new FoldedPhone(new XiaoMi());
        phone1.open();
        phone1.close();
        phone1.call();


        System.out.println("===============================================");
        FoldedPhone phone2 = new FoldedPhone(new Vivo());
        phone2.open();
        phone2.close();
        phone2.call();

        //想要增加一个样式，只需要多写一个类就行了
        UpRightPhone phone3 = new UpRightPhone(new XiaoMi());
        UpRightPhone phone4 = new UpRightPhone(new Vivo());
    }
}
