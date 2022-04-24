package com.company;

import java.util.HashMap;
import java.util.Map;

public class User {
    private Integer user_id;
    private String name;
    private Map<User, Integer> balanceInfo;

    User(int user_id) {
        this.user_id = user_id;
        this.name = "User" + user_id;
        balanceInfo = new HashMap<>();
    }

    Integer getUser_id() {
        return user_id;
    }

    Map<User, Integer> getBalanceInfo() {
        return balanceInfo;
    }

    String getName() {
        return this.name;
    }
}
