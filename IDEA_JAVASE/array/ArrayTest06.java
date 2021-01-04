package com.bjpowernode.javase.array;
/*
模拟一个系统，假设这个系统要使用，必须输入用户名和密码
 */
public class ArrayTest06 {
    //用户名和密码输入到String[] args数组当中
    public static void main(String[] args) {
        if (args.length != 2){
            System.out.println("使用该系统时，请输入系统参数，参数包括用户名和密码信息");
            return;
        }
        //程序执行到此处，说明用户确实提供了用户名和密码
        //接下来应该判断用户名和密码是否正确
        //取出用户名
        String username = args[0];
        //取出密码
        String password = args[1];

        //假设用户名是admin，密码是123的时候表示登录成功，其他一律失败
        //判断两个字符串相等，需要使用equals方法
        //if (username.equals("admin") && password.equals("123")){   这样写容易出现空指针异常
        //这样写可以避免空指针异常
        //采用以下编码风格，即使username和password都是null，也不会出现空指针异常（老程序员的编程经验）
        if ("admin".equals(username) && "123".equals(password)){
            System.out.println("登录成功，欢迎[" + username + "]回来");
            System.out.println("您可以继续使用该系统……");
        }else{
            System.out.println("验证失败，用户名不存在或密码错误！");
        }

    }
}
