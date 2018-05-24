package com.suda.zph.passwordmanager.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import com.suda.zph.passwordmanager.R;
import com.suda.zph.passwordmanager.adapter.PassWordListAdapter;
import com.suda.zph.passwordmanager.database.databaseImp.IPassWord;
import com.suda.zph.passwordmanager.entity.PassWord;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    private ArrayList<PassWord> lists;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ListView lv = findViewById(R.id.user_list);
        //菜单栏
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //菜单栏点击事件
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                String msg = "";
                switch (menuItem.getItemId()) {
                    case R.id.menu_search:
                        msg += "Click search";
                        break;
                    case R.id.menu_setting:
                        Intent intent = new Intent(HomeActivity.this,ModUserActivity.class);
                        startActivity(intent);
                        break;
                }
                if(!msg.equals("")) {
                    Toast.makeText(HomeActivity.this, msg, Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });

        //流动按钮
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,AddPassWordActivity.class);
                startActivity(intent);
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();

            }
        });

        lists = new IPassWord().findAll(HomeActivity.this);
        PassWordListAdapter passWordListAdapter = new PassWordListAdapter(lists,HomeActivity.this);
        lv.setAdapter(passWordListAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(HomeActivity.this,ChooseActivity.class);
                //传值
                Bundle bundle = new Bundle();
                bundle.putSerializable("id",lists.get(i).getId());
                intent.putExtras(bundle);
                HomeActivity.this.startActivity(intent);
            }
        });

        Intent intent = getIntent();
        String msg = (String)intent.getSerializableExtra("msg");
        if(intent.getSerializableExtra("msg")==null){

        }else {
            View view = getWindow().getDecorView();
            Snackbar.make(view, msg, Snackbar.LENGTH_LONG).setAction("Action", null).show();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        super.onCreateOptionsMenu(menu);
        return true;
    }
}
