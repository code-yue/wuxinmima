package com.example.wuxinmima;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.litepal.LitePal;

import java.util.List;

public class mimaxianshi extends AppCompatActivity {
    private TextView 显示名称;
    private TextView 显示账号;
    private TextView 显示密码;
    private TextView 显示绑定手机号;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mimaxianshi);
        显示名称 = (TextView)findViewById(R.id.显示密码名称);
        显示账号 = (TextView)findViewById(R.id.显示账号);
        显示密码 = (TextView)findViewById(R.id.显示密码);
        显示绑定手机号 = (TextView)findViewById(R.id.显示绑定手机号);
        Intent intent = getIntent();
        String 名称 = intent.getStringExtra("密码名称");
        List<mima> mima = LitePal.select("账号","密码","绑定手机号").where("名称=?",名称).find(mima.class);
        for (mima mima1:mima){
            显示名称.setText(名称);
            显示账号.setText("账号: "+mima1.get账号());
            显示密码.setText("密码:"+mima1.get密码());
            显示绑定手机号.setText("绑定手机号: "+mima1.get绑定手机号());
            break;
        }
    }
}