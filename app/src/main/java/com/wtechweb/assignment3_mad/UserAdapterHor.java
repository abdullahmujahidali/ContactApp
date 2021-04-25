package com.wtechweb.assignment3_mad;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserAdapterHor extends RecyclerView.Adapter<UserAdapterHor.ViewHolder> {

    public interface ItemClicked{
        void onItemClick(int index);
    }

    ArrayList<User> newUser = new ArrayList<>();
    ItemClicked myActivity;
    private ViewHolder holder;
    private int position;

    public UserAdapterHor(Context context,ArrayList<User> list2){
        myActivity=(ItemClicked) context;
        newUser=list2;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView ivPref;
        TextView tvName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPref=itemView.findViewById(R.id.ivpref);
            tvName=itemView.findViewById(R.id.tvName);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_hor,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemView.setTag(newUser.get(position));
        holder.tvName.setText(newUser.get(position).getName());

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
        else{
            holder.ivPref.setImageResource(R.drawable.dwayne);
        }
    }

    @Override
    public int getItemCount() {
        return newUser.size();
    }
}
