package com.suda.zph.passwordmanager.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.suda.zph.passwordmanager.R;
import com.suda.zph.passwordmanager.database.databaseImp.IPassWord;
import com.suda.zph.passwordmanager.entity.PassWord;

public class AddPassWordActivity extends AppCompatActivity {
    private TextView add_source,add_user_name,add_user_password,add_remarks;
    private Button add_but_submit;
    private int id;
    private int doWhat = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pass_word);
        add_source = findViewById(R.id.tv_add_source);
        add_user_name = findViewById(R.id.tv_add_user_name);
        add_user_password = findViewById(R.id.tv_add_user_password);
        add_remarks = findViewById(R.id.tv_add_remarks);
        add_but_submit = findViewById(R.id.tv_add_but_submit);

        Intent intent = getIntent();
        if(intent.getSerializableExtra("chid")==null){
            doWhat = 0;
        }else {
            System.out.println("getid");
            doWhat = 1;
            id = (int) intent.getSerializableExtra("chid");
            PassWord passWord = new IPassWord().findPassWordById(AddPassWordActivity.this,id);
            add_but_submit.setText("修改信息");
            add_source.setText(passWord.getSource());
            add_user_name.setText(passWord.getUser_name());
            add_user_password.setText(passWord.getUser_password());
            add_remarks.setText(passWord.getRemarks());
        }

        add_but_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(doWhat == 0){
                    PassWord passWord = new PassWord(add_source.getText().toString(),add_user_name.getText().toString(),add_user_password.getText().toString(),add_remarks.getText().toString());
                    new IPassWord().addPassWord(AddPassWordActivity.this,passWord);
                    Intent intent = new Intent(AddPassWordActivity.this,HomeActivity.class);
                    //传值
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("msg","add success!");
                    intent.putExtras(bundle);
                    AddPassWordActivity.this.startActivity(intent);
                }else{
                    PassWord passWord = new PassWord(add_source.getText().toString(),add_user_name.getText().toString(),add_user_password.getText().toString(),add_remarks.getText().toString());
                    passWord.setId(id);
                    new IPassWord().modPassWord(AddPassWordActivity.this,passWord);
                    Intent intent = new Intent(AddPassWordActivity.this,HomeActivity.class);
                    //传值
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("msg","mod success!");
                    intent.putExtras(bundle);
                    AddPassWordActivity.this.startActivity(intent);
                }
            }
        });
    }
    @Override
    protected void onPause() {
        super.onPause();
        this.finish();

    }
}
