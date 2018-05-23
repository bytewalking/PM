package com.suda.zph.passwordmanager.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.suda.zph.passwordmanager.R;
import com.suda.zph.passwordmanager.entity.PassWord;
import java.util.ArrayList;

public class PassWordListAdapter extends BaseAdapter {
    ArrayList<PassWord> lists;
    Context context;

    public PassWordListAdapter(ArrayList<PassWord> lists, Context context) {
        this.lists = lists;
        this.context = context;
    }

    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int i) {
        return lists.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final PassWord passWord = lists.get(i);
        ViewHolder viewHolder;
        View v;
        if(view == null) {
            viewHolder = new ViewHolder();
            v = LayoutInflater.from(context).inflate(R.layout.iteam_layout, null);
            viewHolder.tvSource = v.findViewById(R.id.iteam_source);
            viewHolder.tvUserName = v.findViewById(R.id.iteam_user_name);
            viewHolder.tvPassword = v.findViewById(R.id.iteam_user_password);
            viewHolder.tvCreateTime = v.findViewById(R.id.iteam_create_time);
            viewHolder.tvModTime = v.findViewById(R.id.iteam_mod_time);
            viewHolder.tvRemarks = v.findViewById(R.id.iteam_remarks);
            v.setTag(viewHolder);
        }else {
            v = view;
            viewHolder = (ViewHolder) v.getTag();
        }
        viewHolder.tvSource.setText(passWord.getSource());
        viewHolder.tvUserName.setText(passWord.getUser_name());
        viewHolder.tvPassword.setText("*********");
        viewHolder.tvCreateTime.setText(passWord.getCreate_time());
        viewHolder.tvModTime.setText(passWord.getMod_time());
        viewHolder.tvRemarks.setText(passWord.getRemarks());
        return v;
    }
    class ViewHolder {
        TextView tvSource;
        TextView tvUserName;
        TextView tvPassword;
        TextView tvCreateTime;
        TextView tvModTime;
        TextView tvRemarks;
    }
}
