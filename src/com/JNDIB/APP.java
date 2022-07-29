package com.JNDIB;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class APP {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try {
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
            HelloService helloService = (HelloService) registry.lookup("hello");
            System.out.println(helloService.sayHello());
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }
}
