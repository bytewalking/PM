package com.suda.zph.passwordmanager.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.suda.zph.passwordmanager.R;
import com.suda.zph.passwordmanager.database.databaseImp.IUser;

public class MainActivity extends Activity {
    private EditText passWordEdit;
    private Button inButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        passWordEdit = findViewById(R.id.main_password);
        inButton = findViewById(R.id.main_inbut);

        inButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pass = passWordEdit.getText().toString();
                if(login(pass)){
                    Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this,"登陆失败，请检查信息",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    //登陆检查
    public boolean login(String passWord){
        IUser iUser = new IUser();
        return iUser.findUser(MainActivity.this, passWord);
    }
    @Override
    protected void onPause() {
        super.onPause();
        this.finish();

    }
}

