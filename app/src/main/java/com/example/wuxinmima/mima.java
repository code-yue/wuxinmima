package com.example.wuxinmima;

import org.litepal.LitePal;
import org.litepal.crud.LitePalSupport;

public class mima extends LitePalSupport {
    private int id;
    private String 用户名;
    private String 名称;
    private String 账号;
    private String 密码;
    private String 绑定手机号;


    public void setId(int id) {
        this.id = id;
    }

    public void set用户名(String 用户名) {
        this.用户名 = 用户名;
    }

    public void set名称(String 名称) {
        this.名称 = 名称;
    }

    public void set账号(String 账号) {
        this.账号 = 账号;
    }

    public void set密码(String 密码) {
        this.密码 = 密码;
    }

    public void set绑定手机号(String 绑定手机号) {
        this.绑定手机号 = 绑定手机号;
    }

    public int getId() {
        return id;
    }

    public String get用户名() {
        return 用户名;
    }

    public String get名称() {
        return 名称;
    }

    public String get账号() {
        return 账号;
    }

    public String get密码() {
        return 密码;
    }

    public String get绑定手机号() {
        return 绑定手机号;
    }
}
