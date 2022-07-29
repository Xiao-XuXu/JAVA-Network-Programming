package com.NetworkStudy;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TTestServer {//服务器
    //这是一个main方法，是程序的入口：
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //1.创建套接字： 指定服务器的端口号
        ServerSocket ss = new ServerSocket(8888);
        //2.等着客户端发来的信息：
        Socket s = ss.accept();//阻塞方法:等待接收客户端的数据，什么时候接收到数据，什么时候程序继续向下执行。
        //accept()返回值为一个Socket，这个Socket其实就是客户端的Socket
        //接到这个Socket以后，客户端和服务器才真正产生了连接，才真正可以通信了
        //3.感受到的操作流：
        InputStream is = s.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(is);
        //4.读取客户端发来的数据：
        UserTTest user = (UserTTest) (ois.readObject());
        //对对象进行验证：
        boolean flag = false;
        if(user.getName().equals("娜娜")&&user.getPwd().equals("123123")){
            flag = true;
        }
        //向客户端输出结果：---》操作流---》输出流
        OutputStream os = s.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        dos.writeBoolean(flag);
        //5.关闭流+关闭网络资源：
        dos.close();
        os.close();
        ois.close();
        is.close();
        s.close();
        ss.close();
    }
}