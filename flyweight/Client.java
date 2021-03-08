package com.csu.flyweight;
/*
    客户端从工厂中取
 */
public class Client {
    public static void main(String[] args) {
        //进行测试:

        //1、创建一个工厂:
        WebSiteFactory factory = new WebSiteFactory();

        //2、客户要一个以新闻形式发布的网站:
        WebSite webSite = factory.getWebSiteCategory("新闻");
        webSite.use(new User("tom"));          //网站的发布形式为:新闻

        //要以博客形式的网站:
        WebSite webSite2 = factory.getWebSiteCategory("博客");
        webSite2.use(new User("jack"));         //网站的发布形式为:博客在使用中...
        WebSite webSite3 = factory.getWebSiteCategory("博客");
        webSite3.use(new User("lily"));

        System.out.println("网站的分类共=" + factory.getWebSiteCount());  //网站的分类共=2
        //证明如果形式是相同的，并没有额外创建新的对象
    }
}
