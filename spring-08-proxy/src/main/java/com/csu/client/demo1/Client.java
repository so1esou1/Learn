package com.csu.client.demo1;

public class Client {
    public static void main(String[] args) {
        //房东要租房子
        Host host = new Host();
        //代理，中介帮房东出租房子，但是代理角色一般会有一些附属操作(看房、签合同、收中介费)
        Proxy proxy = new Proxy(host);

        //你不用面对房东，直接找中介即可
        proxy.rent();
    }
}
