package com.csu.crm;
/*
动态代理模式
 */
import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TransactionHandler implements InvocationHandler {
    private Object target;
    public TransactionHandler(Object target){
        this.target = target;
    }

    /**
     * 获取代理对象实例(成员方法)
     * @return
     */
    public Object getProxy(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        SqlSession sqlSession = null;
        Object retValue = null;
        try {
            sqlSession = SqlSessionUtil.getCurrentSqlSession();
            //调用目标service当中的目标方法
            retValue = method.invoke(target,args);

            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            SqlSessionUtil.rollback(sqlSession);
        }finally {
            SqlSessionUtil.close(sqlSession);
        }
        return null;
    }
}
