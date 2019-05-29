package com.prgm.applicationstate;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    Context context;
    List<RetrofitModel> arr_model = new ArrayList<>();

    public void setGitHubRepos(@Nullable List<RetrofitModel> repos) {
        if (repos == null) {
            return;
        }
        arr_model.clear();
        arr_model.addAll(repos);
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View itemView = layoutInflater.inflate(R.layout.item_recyclerview, parent, false);

        MyViewHolder holder = new MyViewHolder(itemView);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.textView.setText(arr_model.get(position).getNodeId());

    }



    @Override
    public int getItemCount() {
        return arr_model.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);

            this.textView = (TextView)itemView.findViewById(R.id.tv_item);

        }
    }
}
