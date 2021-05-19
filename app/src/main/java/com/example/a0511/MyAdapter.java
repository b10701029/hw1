package com.example.a0511;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import static androidx.core.content.ContextCompat.startActivity;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private static String getData;
    private Button b1;
    private List<ScannedData> arrayList = new ArrayList<>();

    private  Activity activity;

    public MyAdapter(Activity activity){
        this.activity =activity;
    }

    public void clearDevice(){
        this.arrayList.clear();
        notifyDataSetChanged();
    }
    public void addDevice(List<ScannedData> arrayList){
        this.arrayList = arrayList;
        notifyDataSetChanged();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName,tvAddress,tvInfo,tvRssi,b2,b1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.textView_DeviceName);
            tvAddress = itemView.findViewById(R.id.textView_Address);
            tvInfo = itemView.findViewById(R.id.textView_ScanRecord);
            tvRssi = itemView.findViewById(R.id.textView_Rssi);
            b2 = itemView.findViewById(R.id.button2);
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.scanneditem,parent,false);
        return new ViewHolder(view);
    }
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvName.setText("名稱："+arrayList.get(position).getDeviceName());
        holder.tvAddress.setText("位址："+arrayList.get(position).getAddress());
        holder.tvInfo.setText("資訊：\n"+arrayList.get(position).getDeviceByteInfo());
        holder.tvRssi.setText("強度："+arrayList.get(position).getRssi());
        holder.b2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                AppCompatActivity activity=(AppCompatActivity)v.getContext();
                SecondFragment secondFragment =new SecondFragment();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.rec,secondFragment).addToBackStack(null).commit();
            }
        });
    }
    
    static String getData(){
        return MyAdapter.getData;
    }
    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
