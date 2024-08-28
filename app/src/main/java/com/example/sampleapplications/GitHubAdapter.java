package com.example.sampleapplications;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;


public class GitHubAdapter extends RecyclerView.Adapter<GitHubAdapter.GitHuBViewHolder> {
    private final Context context;
    private final VolleyDO[] data;

    public GitHubAdapter(Context context, VolleyDO[] data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public GitHuBViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_list_image, parent, false);
        return new GitHuBViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GitHuBViewHolder holder, int position) {
        VolleyDO user = data[position];
        holder.tv_JsonResult.setText(user.getLogin());

        Glide.with(holder.iv_JsonResult.getContext()).load(user.getAvatarUrl()).into(holder.iv_JsonResult);
        /*Glide.with(holder.iv_JsonResult.getContext())
                .load(user.getAvatarUrl())
                .into(holder.iv_JsonResult);*/
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class GitHuBViewHolder extends RecyclerView.ViewHolder {
        TextView tv_JsonResult;
        ImageView iv_JsonResult;


        public GitHuBViewHolder(View itemView) {
            super(itemView);
            tv_JsonResult = (TextView) itemView.findViewById(R.id.tv_JsonResult);
            iv_JsonResult = (ImageView) itemView.findViewById(R.id.iv_JsonResult);
        }
    }

}
