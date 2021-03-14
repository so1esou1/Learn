package com.csu.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/*
    监听器:统计在线人数
    统计人数使用session，有多少个用户就有多少个session
    可以根据实际继承许多不同种类的Listener
 */
public class OnlineCountListener implements HttpSessionListener {   //监听session

    //创建session的监听
    //一旦创建一个session，就会触发一个监听
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        //获得一个监听的对象
        ServletContext ctx = se.getSession().getServletContext();
        Integer onlineCount = (Integer) ctx.getAttribute("OnlineCount");
        if (onlineCount == null){
            onlineCount = new Integer(1);   //+1
        }else {
            int count = onlineCount.intValue();
            onlineCount = new Integer(count + 1);
        }

        ctx.setAttribute("OnlineCount",onlineCount);
    }

    //销毁session的监听
    //session销毁就会触发这个
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        //销毁的话就是用户数-1
        ServletContext ctx = se.getSession().getServletContext();
        Integer onlineCount = (Integer) ctx.getAttribute("OnlineCount");
        if (onlineCount == null){
            onlineCount = new Integer(0);   //+1
        }else {
            int count = onlineCount.intValue();
            onlineCount = new Integer(count - 1);
        }

        ctx.setAttribute("OnlineCount",onlineCount);
    }
}
