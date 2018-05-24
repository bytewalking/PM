package com.suda.zph.passwordmanager.activity;
import android.content.Intent;
import android.widget.TextView;
import com.suda.zph.passwordmanager.R;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.suda.zph.passwordmanager.database.databaseImp.IPassWord;

public class ShowPasswordActivity extends AppCompatActivity {
    private TextView but_show_password;
    private int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_password);
        but_show_password = findViewById(R.id.but_show_password);
        Intent intent = getIntent();
        id = (int) intent.getSerializableExtra("chid");
        but_show_password.setText(new IPassWord().findPassWordById(ShowPasswordActivity.this,id).getUser_password());
    }
    @Override
    protected void onPause() {
        super.onPause();
        this.finish();

    }
}
