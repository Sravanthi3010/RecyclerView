package com.example.sahithi.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private ArrayList<OSTypes> operating_system_type;
    private Context context;

    public DataAdapter(Context context,ArrayList<OSTypes> android_versions) {
        this.context = context;
        this.operating_system_type = android_versions;

    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_list, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        viewHolder.tv_android.setText(operating_system_type.get(i).getOperating_system_type());
        Picasso.with(context).load(operating_system_type.get(i).getOperating_system_logo()).resize(120, 60).into(viewHolder.img_android);
    }

    @Override
    public int getItemCount() {
        return operating_system_type.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_android;
        ImageView img_android;
        public ViewHolder(View view) {
            super(view);

            tv_android = (TextView)view.findViewById(R.id.txt_android);
            img_android = (ImageView)view.findViewById(R.id.img_android);
        }
    }
}