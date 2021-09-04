package com.example.wuxinmima;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.litepal.LitePal;
import org.litepal.crud.LitePalSupport;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<mima> mimas = new ArrayList<>();
    private String 用户名;
    private TextView 用户名名称;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化用户数据
        用户名名称 = (TextView)findViewById(R.id.用户名名称);
        initmima();
        mimaAdapter adapter = new mimaAdapter(MainActivity.this,R.layout.mima,mimas);
        ListView listView = (ListView)findViewById(R.id.滚动菜单);
        listView.setAdapter(adapter);
        FloatingActionButton add_mima = (FloatingActionButton)findViewById(R.id.add_mima);
        add_mima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
    }
    private void initmima(){
        Intent intent = getIntent();
        String 手机号 = intent.getStringExtra("手机号");
        List<Users> users = LitePal.select("用户名").where("手机号=?",手机号).find(Users.class);
        for (Users users1 :users){
            用户名 = users1.get用户名();
            break;
        }
        用户名名称.setText(用户名);
        mimas = LitePal.select("名称").where("用户名=?",用户名).find(mima.class);
    }
}