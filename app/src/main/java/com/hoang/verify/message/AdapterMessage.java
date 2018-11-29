package com.hoang.verify.message;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class AdapterMessage extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ArrayList<Chat> arrayMessage;
    Context context;
    int check;


    @Override
    public int getItemViewType(int position) {
        //=1 là gửi
        if (arrayMessage.get(position).check == 1) {
            return 1;
        } else {
            return 0;
        }

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == 1){
            View view=LayoutInflater.from(context).inflate(R.layout.rv_message_layout, viewGroup, false);
            return new RecylerViewMessage(view);
        }

        else{
            View view=LayoutInflater.from(context).inflate(R.layout.rv_message_layout_reves, viewGroup, false);
            return new RecylerViewMessageReves(view);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (arrayMessage.get(i).check == 1) {
            ((RecylerViewMessage)viewHolder).tvMessage.setText(arrayMessage.get(i).getContent());
        } else {
            ((RecylerViewMessageReves)viewHolder).tvMessageReves.setText(arrayMessage.get(i).content);
        }

    }

    @Override
    public int getItemCount() {
        return arrayMessage.size();
    }


    class RecylerViewMessage extends RecyclerView.ViewHolder {
        TextView tvMessage;

        RecylerViewMessage(@NonNull View itemView) {
            super(itemView);
            tvMessage = itemView.findViewById(R.id.tv_message);
        }
    }

    class RecylerViewMessageReves extends RecyclerView.ViewHolder {
        TextView tvMessageReves;

        public RecylerViewMessageReves(@NonNull View itemView) {
            super(itemView);
            tvMessageReves = itemView.findViewById(R.id.tv_message_reves);
        }
    }
}