package com.example.ducviet.demoretrofit.manager;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ducviet.demoretrofit.R;
import com.example.ducviet.demoretrofit.model.Post;


import java.util.ArrayList;

/**
 * Created by ducviet on 31/08/2017.
 */

public class RecyclerPostAdapter extends RecyclerView.Adapter<RecyclerPostAdapter.ViewHolderPost> {
    private ArrayList<Post> arrayList;
    private Context context;
    public  RecyclerPostAdapter(Context context ,ArrayList<Post> list){
        this.arrayList = list;
        this.context = context;
    }
    @Override
    public ViewHolderPost onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_post,null);
        ViewHolderPost holderPost = new ViewHolderPost(layout);
        return holderPost;
    }

    @Override
    public void onBindViewHolder(ViewHolderPost holder, int position) {
        holder.message.setText(arrayList.get(position).getId());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    class ViewHolderPost extends RecyclerView.ViewHolder{
        private TextView name,message;
        public ViewHolderPost(View itemView) {
            super(itemView);
            name = (TextView)itemView.findViewById(R.id.name_user);
            message = (TextView)itemView.findViewById(R.id.message);
        }
    }
}
