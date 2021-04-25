package com.wtechweb.assignment3_mad;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    public interface ItemClicked{
        void onItemClick(int index);
    }

    ArrayList<User> newUser = new ArrayList<>();
    ItemClicked myActivity;
    private ViewHolder holder;
    private int position;

    public UserAdapter(Context context,ArrayList<User> list){
        myActivity=(ItemClicked) context;
        newUser=list;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView ivPref;
        TextView tvName;
        TextView tvAddress;
        Button button5;
        Button button6;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPref=itemView.findViewById(R.id.ivpref);
            tvName=itemView.findViewById(R.id.tvName);
            tvAddress=itemView.findViewById(R.id.tvAddress);
            button5=itemView.findViewById(R.id.button5);
            button6=itemView.findViewById(R.id.adduserbtn);
            button5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    myActivity.onItemClick(newUser.indexOf((User) itemView.getTag()));
                }

            });
//            button6.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    myActivity.onItemClick(newUser.indexOf((User) itemView.getTag()));
//                }
//            });



        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemView.setTag(newUser.get(position));
        holder.tvName.setText(newUser.get(position).getName());
        holder.tvAddress.setText(newUser.get(position).getAddress());

        if(newUser.get(position).getName().equals("abdullahm")){
            holder.ivPref.setImageResource(R.drawable.abdullahm);
        }
        else if(newUser.get(position).getName().equals("anna")){
            holder.ivPref.setImageResource(R.drawable.marry);
        }
        else if(newUser.get(position).getName().equals("ammy")){
            holder.ivPref.setImageResource(R.drawable.ammy);
        }
        else if(newUser.get(position).getName().equals("linda")){
            holder.ivPref.setImageResource(R.drawable.linda);
        }
        else if(newUser.get(position).getName().equals("pep")){
            holder.ivPref.setImageResource(R.drawable.pep);
        }
        else{
            holder.ivPref.setImageResource(R.drawable.dwayne);
        }
    }

    @Override
    public int getItemCount() {
        return newUser.size();
    }
}
