package com.example.wuxinmima;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.litepal.LitePal;

public class mimaxinxixiugai extends AppCompatActivity {
    private EditText 修改密码;
    private EditText 修改账号;
    private EditText 修改绑定手机号;
    private Button 修改;
    private Button 取消;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mimaxinxixiugai);
        修改密码 = (EditText)findViewById(R.id.修改密码);
        修改账号 = (EditText)findViewById(R.id.修改账号);
        修改绑定手机号 = (EditText)findViewById(R.id.修改绑定手机号);
        修改 = (Button)findViewById(R.id.修改);
        取消 = (Button)findViewById(R.id.取消);
        修改.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mima mima1 = new mima();
                Intent intent = getIntent();
                String 用户名 = intent.getStringExtra("用户名");
                String 名称 = intent.getStringExtra("名称");
                LitePal.deleteAll(mima.class,"名称=?",名称);
                String 新密码 = 修改密码.getText().toString();
                String 新账号 = 修改账号.getText().toString();
                String 新绑定手机号 = 修改绑定手机号.getText().toString();
                mima1.set用户名(用户名);
                mima1.set名称(名称);
                mima1.set账号(新账号);
                mima1.set密码(新密码);
                mima1.set绑定手机号(新绑定手机号);
                mima1.save();
                Intent intent1 = new Intent();
                intent1.putExtra("新密码",新密码);
                intent1.putExtra("新账号",新账号);
                intent1.putExtra("新绑定手机号",新绑定手机号);
                setResult(RESULT_OK,intent1);
                finish();
            }
        });
        取消.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}