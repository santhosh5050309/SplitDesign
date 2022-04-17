package com.company;

import java.util.HashMap;

public class User {
    public int user_id;
    public String name,mobile,email;
    public HashMap<com.company.User,Integer > balanceInfo;
    User(int user_id)
    {
        this.user_id = user_id;
        balanceInfo =  new HashMap<com.company.User, Integer>();
    }

    void setName(String name)
    {
        this.name = name;
    }

    void setMobile(String mobile)
    {
        this.mobile = mobile;
    }

    void setEmail(String email) {
        this.email = email;
    }
}
