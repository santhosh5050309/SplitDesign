package com.company;

import javax.jws.soap.SOAPBinding;
import java.util.HashMap;

public class User {
    public int user_id;
    public String name,mobile,email;
    public HashMap<com.company.User,Integer > balanceInfo;
    User(int user_id)
    {
        this.user_id = user_id;
        this.name = "User"+user_id;
        balanceInfo =  new HashMap<com.company.User, Integer>();
    }
    /*
    User(UserBuilder userBuilder)
    {
        this.user_id = userBuilder.user_id;
        this.name = userBuilder.name;
        this.mobile = userBuilder.mobile;
        this.balanceInfo = userBuilder.balanceInfo;
    }

    public static class UserBuilder
    {
        public int user_id;
        public String name,mobile,email;
        public HashMap<com.company.User,Integer > balanceInfo;
        UserBuilder(int user_id)
        {
            this.user_id  =user_id;
            this.name = "User"+user_id;
            balanceInfo =  new HashMap<com.company.User, Integer>();
        }
        UserBuilder setName(String name)
        {
            this.name = name;
            return this;
        }

        UserBuilder setMobile(String mobile)
        {
            this.mobile = mobile;
            return this;
        }

        UserBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        User build()
        {
            return new User(this);
        }
      }
        */

    String getName()
    {
        return this.name;
    }
}
