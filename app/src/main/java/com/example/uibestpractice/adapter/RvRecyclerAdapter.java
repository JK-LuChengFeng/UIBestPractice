package com.example.uibestpractice.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uibestpractice.R;
import com.example.uibestpractice.bean.SiZhiBean;

import java.util.List;

/**
 * @author JK_Liu
 * @description:
 * @date :2019/12/5 15:26
 */
public class RvRecyclerAdapter extends RecyclerView.Adapter<RvRecyclerAdapter.ViewHolder> {

    private List<SiZhiBean> data;

    public RvRecyclerAdapter(List<SiZhiBean> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        ViewHolder viewHolder = null;
        if (viewType == 0){
            //接收
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_msg_left,parent,false);
            viewHolder = new ViewHolder(view);
        }else if (viewType == 1){
            //发送
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_msg_right,parent,false);
            viewHolder = new ViewHolder(view);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (data.get(position).getType() == 0){
            holder.tv_talkleft.setText(data.get(position).getContent());
        }else {
            holder.tv_talkright.setText(data.get(position).getContent());
        }
    }

    @Override
    public int getItemViewType(int position) {
        SiZhiBean siZhiBean = data.get(position);
        if (siZhiBean.getType() == SiZhiBean.TYPE_RECEIVED){
            return 0;
        }
        return 1;
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_talkleft;
        private TextView tv_talkright;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_talkleft = itemView.findViewById(R.id.item_tv_talkleft);
            tv_talkright = itemView.findViewById(R.id.item_tv_talkright);

        }
    }

}
