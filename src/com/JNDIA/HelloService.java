package com.JNDIA;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public interface HelloService extends Remote {
    String sayHello() throws RemoteException;
}


