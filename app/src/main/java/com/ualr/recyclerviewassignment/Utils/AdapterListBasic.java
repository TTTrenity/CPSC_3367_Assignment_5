package com.ualr.recyclerviewassignment.Utils;

import android.content.Context;
import android.provider.Contacts;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.recyclerview.widget.RecyclerView;

import com.ualr.recyclerviewassignment.R;
import com.ualr.recyclerviewassignment.model.Inbox;

import java.util.List;

public class AdapterListBasic extends RecyclerView.Adapter{
    private List<Inbox> mItems;

    public AdapterListBasic(List<Inbox> items){
        this.mItems = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        RecyclerView.ViewHolder vh;
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        vh = new PersonViewHolder(itemView);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position){
        PersonViewHolder viewHolder = (PersonViewHolder)holder;
        Inbox p = mItems.get(position);
        viewHolder.from.setText(p.getFrom());
        viewHolder.email.setText(p.getEmail());
        viewHolder.message.setText(p.getMessage());
        viewHolder.date.setText(p.getDate());
        viewHolder.icon.setText(p.getFrom().charAt(0));
    }

    @Override
    public int getItemCount(){
        return this.mItems.size();
    }

    private class PersonViewHolder extends RecyclerView.ViewHolder {
        public TextView from;
        public TextView email;
        public TextView message;
        public TextView date;
        public TextView icon;
        public View lyt_parent;

        public PersonViewHolder(@NonNull View itemView) {
            super(itemView);
            from = itemView.findViewById(R.id.from);
            email = itemView.findViewById(R.id.email);
            message = itemView.findViewById(R.id.message);
            date = itemView.findViewById(R.id.date);
            lyt_parent = itemView.findViewById(R.id.lyt_parent);
        }
    }

}
