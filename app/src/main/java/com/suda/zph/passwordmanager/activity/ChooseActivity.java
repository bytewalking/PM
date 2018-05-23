package com.suda.zph.passwordmanager.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.suda.zph.passwordmanager.R;
import com.suda.zph.passwordmanager.database.databaseImp.IPassWord;

public class ChooseActivity extends AppCompatActivity {
    private Button upDateBut,deleteBut,selectBut;
    private int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        upDateBut = findViewById(R.id.cho_update);
        deleteBut = findViewById(R.id.ch_delete);
        selectBut = findViewById(R.id.cho_select);

        Intent intent = getIntent();
        id = (int) intent.getSerializableExtra("id");

        upDateBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChooseActivity.this,AddPassWordActivity.class);
                //传值
                Bundle bundle = new Bundle();
                bundle.putSerializable("chid",id);
                intent.putExtras(bundle);
                ChooseActivity.this.startActivity(intent);
            }
        });
        deleteBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new IPassWord().deletePassWord(ChooseActivity.this,id);
                Intent intent = new Intent(ChooseActivity.this,HomeActivity.class);
                //传值
                Bundle bundle = new Bundle();
                bundle.putSerializable("msg","delete success!");
                intent.putExtras(bundle);
                ChooseActivity.this.startActivity(intent);
            }
        });
        selectBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChooseActivity.this,ShowPasswordActivity.class);
                //传值
                Bundle bundle = new Bundle();
                bundle.putSerializable("chid",id);
                intent.putExtras(bundle);
                ChooseActivity.this.startActivity(intent);
            }
        });
    }
    @Override
    protected void onPause() {
        super.onPause();
        this.finish();

    }
}
