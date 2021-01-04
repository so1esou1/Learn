package com.bjpowernode.javase.homework;
/*
用户的业务类，处理用户相关的业务：例如登录、注册等功能
 */
public class UserService {
    /**
     *  用户注册
     * @param username 用户名
     * @param password 密码
     * @throws IllegalArgsException 当用户名为null、或长度小于6或大于14会出现该异常
     */
    public void register(String username,String password) throws IllegalArgsException {
        /*
        经验：1、引用等于null的判断最好放在所以条件最前面
        2、username == null不如写成null == username
         */
        if (null == username || username.length() < 6 || username.length() > 14){
            //username == null放在前面可以避免空指针异常
            /*System.out.println("用户名不合法，长度必须在[6-14]之间");
            return;      以前会是这样写*/
            throw new IllegalArgsException("用户名不合法，长度必须在[6-14]之间");
        }
        //程序执行到此处说明用户名合法
        System.out.println("注册成功，欢迎[" + username +"]");
    }
}
