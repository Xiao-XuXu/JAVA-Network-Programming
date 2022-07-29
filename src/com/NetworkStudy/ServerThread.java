package com.NetworkStudy;

import java.io.*;
import java.net.Socket;

public class ServerThread extends Thread {//线程：专门处理客户端的请求
    InputStream is = null;
    ObjectInputStream ois = null;
    OutputStream os = null;
    DataOutputStream dos = null;
    Socket s = null;
    public ServerThread(Socket s){
        this.s = s;
    }
    @Override
    public void run() {
        try{
            //2.等着客户端发来的信息：
            is = s.getInputStream();
            ois = new ObjectInputStream(is);
            //4.读取客户端发来的数据：
            User user = (User)(ois.readObject());
            //对对象进行验证：
            boolean flag = false;
            if(user.getName().equals("娜娜")&&user.getPwd().equals("123123")){
                flag = true;
            }
            //向客户端输出结果：---》操作流---》输出流
            os = s.getOutputStream();
            dos = new DataOutputStream(os);
            dos.writeBoolean(flag);
        }catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(dos!=null){
                    dos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(os!=null){
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(ois!=null){
                    ois.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(is!=null){
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
