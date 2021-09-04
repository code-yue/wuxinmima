package com.example.wuxinmima;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.litepal.LitePal;

import java.util.List;

public class Login extends AppCompatActivity implements View.OnClickListener {
    private EditText 账号;
    private EditText 密码;
    private EditText 手机号;
    private EditText 验证码;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button 注册 = (Button) findViewById(R.id.注册);
        Button 登录 = (Button) findViewById(R.id.登录);
        登录.setOnClickListener(this);
        注册.setOnClickListener(this);
        账号 = (EditText) findViewById(R.id.账号);
        密码 = (EditText) findViewById(R.id.密码);
        手机号 = (EditText) findViewById(R.id.手机号);
        验证码 = (EditText) findViewById(R.id.验证码);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.注册:
                Intent intent = new Intent(Login.this,Enroll.class);
                startActivity(intent);
                break;
            case R.id.登录:
                String 账号信息 = 账号.getText().toString();
                String 密码信息 = 密码.getText().toString();
                String 手机号信息 = 手机号.getText().toString();
                String 验证码信息 = 验证码.getText().toString();
                boolean 正确登录 = false;
                List<Users> usersList = LitePal.findAll(Users.class);
                for(Users users : usersList){
                    if (手机号信息.equals(users.get手机号())){
                        if (密码信息.equals(users.get密码())){
                            if (账号信息.equals(users.get用户名())||账号信息.equals(users.get邮箱())){
                                正确登录 = true;
                            }
                        }
                    }
                }
                if (账号信息.isEmpty()){
                    Toast.makeText(Login.this,"请输入用户名或邮箱",Toast.LENGTH_SHORT).show();
                }else if (密码信息.isEmpty()){
                    Toast.makeText(Login.this,"请输入密码",Toast.LENGTH_SHORT).show();
                }else if (手机号信息.isEmpty()){
                    Toast.makeText(Login.this,"请输入手机号",Toast.LENGTH_SHORT).show();
                }else if (!正确登录){
                    Toast.makeText(Login.this,"输入有误，请检查重新输入",Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent1 = new Intent(Login.this,MainActivity.class);
                    intent1.putExtra("手机号",手机号信息);
                    startActivity(intent1);
                    finish();
                }
                break;
            default:
                break;
        }
    }

}