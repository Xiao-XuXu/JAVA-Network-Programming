package com.JNDIA;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloServiceImpl extends UnicastRemoteObject implements HelloService {
    protected HelloServiceImpl() throws RemoteException {
    }

    @Override
    public String sayHello() throws RemoteException {
        System.out.println("hello!");
        return "hello!";
    }
}