package com.csu.facade;
//客户端直接调用所有类的方法很麻烦,而且扩展很不方便
public class Client {
    public static void main(String[] args) {
        //使用外观模式调用方法:
        HomeThreaterFacade facade = new HomeThreaterFacade();
        facade.ready();
        facade.play();
        facade.pause();
        facade.end();
    }

}
