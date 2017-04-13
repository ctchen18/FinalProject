package com.example.user.finalproject.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.user.finalproject.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by user on 2017/4/9.
 */

public class ListViewAdapter extends BaseAdapter {
    private final LayoutInflater mInflater;
    private final ArrayList<String> listResult;
    private Context mContext;

    public ListViewAdapter(Context context, ArrayList<String> listResult){
        mContext=context;
        this.listResult=listResult;
        mInflater=(LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return listResult.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            holder=new ViewHolder();
            convertView = mInflater.inflate(R.layout.list_view_item,parent,false);
            holder.textView1 = (TextView) convertView.findViewById(R.id.list_view_item1);
            holder=new ViewHolder();
            convertView.setTag(holder);
            float scale = mContext.getResources().getDisplayMetrics().density;
            int result = (int) ((int)50*scale+0.5f);
            holder.lp.setMargins(result,0,0,0);
            holder.lp.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        }
        else {
            holder=(ViewHolder) convertView.getTag();
            holder.textView1 = (TextView) convertView.findViewById(R.id.list_view_item1);
            float scale = mContext.getResources().getDisplayMetrics().density;
            int result = (int) ((int)50*scale+0.5f);
            holder.lp.setMargins(0,0,result,0);
            holder.lp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            holder.textView1.setTextColor(Color.GRAY);
        }
            holder.textView1 = (TextView) convertView.findViewById(R.id.list_view_item1);
                holder.textView1.setText(listResult.get(position));



        return convertView;
    }
}
class ViewHolder{
    TextView textView1;
    RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
}
