package com.bjpowernode.javase.homework;

public class Test {
    public static void main(String[] args) {
        //创建UserService对象
        UserService userService = new UserService();
        //用户名和密码不再从控制台中接收了
        try {
            userService.register("jack","123");
        } catch (IllegalArgsException e) {
            System.out.println(e.getMessage());
        }
    }
}
