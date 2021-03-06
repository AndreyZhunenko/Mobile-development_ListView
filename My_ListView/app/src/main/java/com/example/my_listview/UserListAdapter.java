package com.example.my_listview;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

public class UserListAdapter extends BaseAdapter {
    Context ctx;
    ArrayList<User> users;
    public UserListAdapter(Context ctx, ArrayList<User> users) {
        this.ctx = ctx;
        this.users = users;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int position) {
        return users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Date begin = new Date();
        User u = users.get(position);
        convertView = LayoutInflater.from(ctx).
                inflate(R.layout.useritem, parent, false);
        ImageView ivUserpic = convertView.findViewById(R.id.userpic);
        ivUserpic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundColor(Color.RED);
            }
        });
        TextView tvName = convertView.findViewById(R.id.name);
        TextView tvPhone = convertView.findViewById(R.id.phone);
        tvName.setText(u.name);
        tvPhone.setText(u.phoneNumber);
        switch (u.gend) {
            case MAN: ivUserpic.setImageResource(R.drawable.user_man); break;
            case WOMAN: ivUserpic.setImageResource(R.drawable.user_woman); break;
            case UNKNOWN: ivUserpic.setImageResource(R.drawable.user_unknown); break;
        }
        Date finish = new Date();
        Log.d("mytag", "getView time: "+(finish.getTime()-begin.getTime()));
        return convertView;
    }
}

