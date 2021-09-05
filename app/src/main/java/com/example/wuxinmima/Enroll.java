package com.example.wuxinmima;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.litepal.LitePal;
import org.litepal.crud.LitePalSupport;

import java.util.List;

public class Enroll extends AppCompatActivity implements View.OnClickListener{
    private EditText 注册用户名;
    private EditText 注册邮箱 ;
    private EditText 注册密码;
    private EditText 注册手机号 ;
    private Button 注册登录 ;
    private EditText 注册验证码;
    private EditText 注册确认密码;
    private Button 获取验证码;
    private Button 取消注册;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enroll);
         注册用户名 = (EditText)findViewById(R.id.用户名);
         注册邮箱 = (EditText)findViewById(R.id.邮箱);
         注册密码 = (EditText)findViewById(R.id.注册密码);
         注册手机号 = (EditText)findViewById(R.id.注册手机号);
         注册验证码 = (EditText)findViewById(R.id.注册验证码);
        注册登录 = (Button)findViewById(R.id.注册登录);
        注册确认密码 = (EditText)findViewById(R.id.密码确认);
        获取验证码 = (Button)findViewById(R.id.注册获取验证码);
        取消注册 =(Button)findViewById(R.id.取消注册);
        取消注册.setOnClickListener(this);
        注册登录.setOnClickListener(this);
        获取验证码.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.注册登录:
                String 用户名 = 注册用户名.getText().toString();
                String 邮箱 = 注册邮箱.getText().toString();
                String 密码 = 注册密码.getText().toString();
                String 手机号 = 注册手机号.getText().toString();
                String 密码确认 = 注册确认密码.getText().toString();
                boolean 用户名检查 = false;
                boolean 邮箱检查 = false;
                boolean 手机号检查 = false;
                List<Users> UsersList = LitePal.findAll(Users.class);
                if(UsersList.size()==0){
                     用户名检查 = false;
                     邮箱检查 = false;
                }else{
                    for(Users users:UsersList){
                        if(用户名.equals(users.get用户名())){
                            用户名检查 = true;
                            break;
                        }
                        if(邮箱.equals(users.get邮箱())){
                            邮箱检查 = true;
                            break;
                        }
                        if (手机号.equals(users.get手机号())){
                            手机号检查 = true;
                        }
                    }
                }
                if(用户名.isEmpty()){
                    Toast.makeText(Enroll.this,"用户名为空",Toast.LENGTH_SHORT).show();
                }else if (邮箱.isEmpty()){
                    Toast.makeText(Enroll.this,"邮箱为空",Toast.LENGTH_SHORT).show();
                }else if (手机号.isEmpty()){
                    Toast.makeText(Enroll.this,"手机号为空",Toast.LENGTH_SHORT).show();
                }else if (false){
                    Toast.makeText(Enroll.this,"请输入验证码",Toast.LENGTH_SHORT).show();
                }else if (密码确认.isEmpty()){
                    Toast.makeText(Enroll.this,"请确认密码",Toast.LENGTH_SHORT).show();
                }else if (密码.isEmpty()){
                    Toast.makeText(Enroll.this,"请输入密码",Toast.LENGTH_SHORT).show();
                } else if(用户名检查){
                    Toast.makeText(Enroll.this,"用户名重复",Toast.LENGTH_SHORT).show();
                }else if(邮箱检查){
                    Toast.makeText(Enroll.this,"邮箱已注册",Toast.LENGTH_SHORT).show();
                }else if (手机号检查){
                    Toast.makeText(Enroll.this,"手机号已注册",Toast.LENGTH_SHORT).show();
                } else if(!密码.equals(密码确认)){
                    Toast.makeText(Enroll.this,"两次输入密码不同",Toast.LENGTH_SHORT).show();
                } else{
                    Users users = new Users();
                    users.set用户名(用户名);
                    users.set邮箱(邮箱);
                    users.set密码(密码);
                    users.set手机号(手机号);
                    users.save();
                    Intent intent = new Intent(Enroll.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                break;
            case R.id.注册获取验证码:
            case R.id.取消注册:
                finish();
            default:
                break;
        }
    }
}