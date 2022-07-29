package com.NetworkStudy;

import java.net.InetAddress;
import java.net.InetSocketAddress;

public class Test02 {
    //这是一个main方法，是程序的入口：
    public static void main(String[] args) {
        InetSocketAddress isa = new InetSocketAddress("192.168.8.100",8080);
        System.out.println(isa);
        System.out.println(isa.getHostName());
        System.out.println(isa.getPort());
        InetAddress ia = isa.getAddress();
        System.out.println(ia.getHostName());
        System.out.println(ia.getHostAddress());
    }
}
