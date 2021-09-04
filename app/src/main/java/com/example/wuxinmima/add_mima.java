package com.example.wuxinmima;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class add_mima extends AppCompatActivity {
    private EditText 添加用户名;
    private EditText 添加账号;
    private EditText 密码名称;
    private EditText 添加密码;
    private EditText 绑定手机号;
    private Button 添加;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_mima);
        添加 = (Button)findViewById(R.id.添加);
        添加用户名 = (EditText)findViewById(R.id.添加用户名);
        添加账号 = (EditText)findViewById(R.id.添加账号);
        添加密码 = (EditText)findViewById(R.id.添加密码);
        密码名称 = (EditText)findViewById(R.id.密码名称);
        绑定手机号 = (EditText)findViewById(R.id.绑定手机号);
        添加.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //判断是否是该用户
                String 用户名 = 添加用户名.getText().toString();
                String 名称 = 密码名称.getText().toString();
                String 账号 = 添加账号.getText().toString();
                String 密码 = 添加密码.getText().toString();
                String 手机号 = 绑定手机号.getText().toString();
                mima Mima = new mima();
                Mima.set用户名(用户名);
                Mima.set名称(名称);
                Mima.set账号(账号);
                Mima.set密码(密码);
                Mima.set绑定手机号(手机号);
                Mima.save();
            }
        });
    }
}