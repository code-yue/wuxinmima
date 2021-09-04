package com.example.wuxinmima;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import org.litepal.LitePal;

import java.util.List;

public class mimaxianshi extends AppCompatActivity {
    private TextView 显示名称;
    private TextView 显示账号;
    private TextView 显示密码;
    private TextView 显示绑定手机号;
    private FloatingActionButton 删除密码;
    private Button 修改信息;
    private String 用户名;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mimaxianshi);
        显示名称 = (TextView)findViewById(R.id.显示密码名称);
        显示账号 = (TextView)findViewById(R.id.显示账号);
        显示密码 = (TextView)findViewById(R.id.显示密码);
        显示绑定手机号 = (TextView)findViewById(R.id.显示绑定手机号);
        删除密码 = (FloatingActionButton)findViewById(R.id.删除密码);
        修改信息 = (Button)findViewById(R.id.修改信息);
        Intent intent = getIntent();
        String 名称 = intent.getStringExtra("密码名称");
        int position = intent.getIntExtra("position",1);
        List<mima> mima3 = LitePal.select("用户名","账号","密码","绑定手机号").where("名称=?",名称).find(mima.class);
        for (mima mima1:mima3){
            用户名 = mima1.get用户名();
            显示名称.setText(名称);
            显示账号.setText("账号: "+mima1.get账号());
            显示密码.setText("密码:"+mima1.get密码());
            显示绑定手机号.setText("绑定手机号: "+mima1.get绑定手机号());
            break;
        }
        删除密码.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"是否要删除此密码",Snackbar.LENGTH_SHORT).setAction("确定", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent1 = new Intent();
                        intent1.putExtra("名称",名称);
                        intent1.putExtra("position",position);
                        setResult(RESULT_OK,intent1);
                        finish();
                    }
                }).show();
            }
        });
        修改信息.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5 = new Intent(mimaxianshi.this,mimaxinxixiugai.class);
                intent5.putExtra("用户名",用户名);
                intent5.putExtra("名称",名称);
                startActivityForResult(intent5,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode)
        {
            case 1:
                if(resultCode==RESULT_OK){
                    显示账号.setText(data.getStringExtra("新账号"));
                    显示密码.setText(data.getStringExtra("新密码"));
                    显示绑定手机号.setText(data.getStringExtra("新绑定手机号"));
                }
        }
    }
}