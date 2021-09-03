package com.example.wuxinmima;

import org.litepal.crud.LitePalSupport;

public class Users extends LitePalSupport {
    private int id;
    private String 邮箱;
    private String 用户名;
    private String 密码;
    private String 手机号;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void set用户名(String 用户名) {
        this.用户名 = 用户名;
    }

    public String get用户名() {
        return 用户名;
    }

    public void set邮箱(String 邮箱) {
        this.邮箱 = 邮箱;
    }

    public String get邮箱() {
        return 邮箱;
    }

    public void set密码(String 密码) {
        this.密码 = 密码;
    }

    public String get密码() {
        return 密码;
    }

    public void set手机号(String 手机号) {
        this.手机号 = 手机号;
    }

    public String get手机号() {
        return 手机号;
    }

}
