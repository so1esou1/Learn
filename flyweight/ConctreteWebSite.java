package com.csu.flyweight;
/*
    具体的实现的子类
 */
public class ConctreteWebSite extends WebSite{
    private String type = "";       //网站发布的类型，共享的部分，内部状态

    //构造器，需要传入具体的网站类型
    public ConctreteWebSite(String type) {
        this.type = type;
    }

    @Override
    public void use(User user) {
        System.out.println("网站的发布形式为:" + type + "在使用中...使用者为 " + user.getName());
    }
}
