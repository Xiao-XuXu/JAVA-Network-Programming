package com.NetworkStudy;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TTestClient {//客户端
    //这是一个main方法，是程序的入口：
    public static void main(String[] args) throws IOException {
        //1.创建套接字：指定服务器的ip和端口号：
        Socket s = new Socket("192.168.8.100",8888);
        //录入用户的账号和密码：
        Scanner sc = new Scanner(System.in);
        System.out.println("请录入您的账号：");
        String name = sc.next();
        System.out.println("请录入您的密码：");
        String pwd = sc.next();
        //将账号和密码封装为一个User的对象：
        UserTTest user = new UserTTest(name,pwd);
        //2.对于程序员来说，向外发送数据 感受 --》利用输出流：
        OutputStream os = s.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(user);
        //接收服务器端的回话--》利用输入流：
        InputStream is = s.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        boolean b = dis.readBoolean();
        if(b){
            System.out.println("恭喜，登录成功");
        }else{
            System.out.println("对不起，登录失败");
        }
        //3.关闭流  +  关闭网络资源：
        dis.close();
        is.close();
        oos.close();
        os.close();
        s.close();
    }
}
