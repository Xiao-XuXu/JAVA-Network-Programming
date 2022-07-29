package com.NetworkStudy;

import java.io.*;
import java.net.Socket;

public class TestClient {//客户端
    //这是一个main方法，是程序的入口：
    public static void main(String[] args) throws IOException {
        //1.创建套接字：指定服务器的ip和端口号：
        Socket s = new Socket("192.168.8.100",8888);
        //2.对于程序员来说，向外发送数据 感受 --》利用输出流：
        OutputStream os = s.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        //利用这个OutputStream就可以向外发送数据了，但是没有直接发送String的方法
        //所以我们又在OutputStream外面套了一个处理流：DataOutputStream
        dos.writeUTF("你好");
        //接收服务器端的回话--》利用输入流：
        InputStream is = s.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        String str = dis.readUTF();
        System.out.println("服务器端对我说："+str);
        //3.关闭流  +  关闭网络资源：
        dis.close();
        is.close();
        dos.close();
        os.close();
        s.close();
    }
}
