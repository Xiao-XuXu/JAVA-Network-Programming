package com.NetworkStudy;

import java.io.Serializable;

public class UserTTest implements Serializable {
    private static final long serialVersionUID = 9050691344308365540L;
    private String name;
    private String pwd;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPwd() {
        return pwd;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    public UserTTest(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }
}
