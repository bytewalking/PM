package com.suda.zph.passwordmanager.activity;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.suda.zph.passwordmanager.R;
import com.suda.zph.passwordmanager.database.databaseImp.IUser;

public class ModUserActivity extends AppCompatActivity {
    private TextView user_new_password1;
    private TextView user_new_password2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mod_user);
        user_new_password1 = findViewById(R.id.user_new_password1);
        user_new_password2 = findViewById(R.id.user_new_password2);

        Button user_sub = findViewById(R.id.user_sub);

        user_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pas1 = user_new_password1.getText().toString();
                String pas2 = user_new_password2.getText().toString();
                if(pas1.equals(pas2)){
                    new IUser().modUser(ModUserActivity.this,pas1);
                    Intent intent = new Intent(ModUserActivity.this,HomeActivity.class);
                    //传值
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("msg","修改成功!");
                    intent.putExtras(bundle);
                    ModUserActivity.this.startActivity(intent);
                }else {
                    Snackbar.make(view, "密码不一致!", Snackbar.LENGTH_LONG).setAction("Action", null).show();
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
