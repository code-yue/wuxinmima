package com.example.wuxinmima;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
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
    private ListView listView;
    private mimaAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化用户数据
        用户名名称 = (TextView)findViewById(R.id.用户名名称);
        initmima();
        adapter = new mimaAdapter(MainActivity.this,R.layout.mima,mimas);
        listView = (ListView)findViewById(R.id.滚动菜单);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mima mima4 = mimas.get(position);
                Intent intent4 = new Intent(MainActivity.this,mimaxianshi.class);
                intent4.putExtra("密码名称",mima4.get名称());
                startActivity(intent4);
            }
        });
        FloatingActionButton add_mima键 = (FloatingActionButton)findViewById(R.id.add_mima);
        add_mima键.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent 进入添加活动 = new Intent(MainActivity.this,add_mima.class);
                进入添加活动.putExtra("用户名",用户名);
                startActivityForResult(进入添加活动,1);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode){
            case 1:
                if (resultCode ==RESULT_OK){
                    String 密码名称 = data.getStringExtra("密码名称");
                    List<mima> mimas2 = LitePal.select("名称").where("名称=?",密码名称).find(mima.class);
                    for(mima mima3:mimas2){
                        mimas.add(mima3);
                    }
                    adapter.notifyDataSetChanged();
                    break;
                }
        }
    }

}