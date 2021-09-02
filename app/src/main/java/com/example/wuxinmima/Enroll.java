package com.example.wuxinmima;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Enroll extends AppCompatActivity implements View.OnClickListener{
    private EditText 注册用户名;
    private EditText 注册邮箱 ;
    private EditText 注册密码;
    private EditText 注册手机号 ;
    private Button 注册登录 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enroll);
         注册用户名 = (EditText)findViewById(R.id.用户名);
         注册邮箱 = (EditText)findViewById(R.id.邮箱);
         注册密码 = (EditText)findViewById(R.id.注册密码);
         注册手机号 = (EditText)findViewById(R.id.注册手机号);
         注册登录 = (Button)findViewById(R.id.注册登录);
        注册登录.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.注册登录:
                String 用户名 = 注册用户名.getText().toString();
                String 邮箱 = 注册邮箱.getText().toString();
                String 密码 = 注册密码.getText().toString();
                String 手机号 = 注册手机号.getText().toString();
                Users users = new Users();
                users.set用户名(用户名);
                users.set邮箱(邮箱);
                users.set密码(密码);
                users.set手机号(手机号);
                users.save();
                Intent intent = new Intent(Enroll.this,MainActivity.class);
                startActivity(intent);
        }
    }
}