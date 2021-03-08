package com.csu.flyweight;

import java.util.HashMap;

/*
    网站工厂类,根据需求返回一个网站.里面有一个集合，充当池的作用
 */
public class WebSiteFactory {
    //集合:
    private HashMap<String,ConctreteWebSite> pool = new HashMap<>();

    //根据网站的类型返回一个网站，如果没有就创建一个网站并放到池中并返回
    public WebSite getWebSiteCategory(String type){
        if (!pool.containsKey(type)){
            pool.put(type,new ConctreteWebSite(type));
        }
        return (WebSite) pool.get(type);        //转成WebSite类型
    }

    //获取网站分类的总数(图中有多少个网站的类型):
    public int getWebSiteCount(){
        return pool.size();
    }
}
