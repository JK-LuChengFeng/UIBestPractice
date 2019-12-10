package com.example.uibestpractice.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.uibestpractice.R;
import com.example.uibestpractice.bean.MsgBean;

import java.util.List;

/**
 * @author JK_Liu
 * @description:
 * @date :2019/12/4 15:34
 */
public class AutoTalkAdapter extends BaseAdapter {

    private Context context;
    private List<MsgBean> data;
    private LayoutInflater inflater;

    public AutoTalkAdapter(Context context, List<MsgBean> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return (data == null? 0 : data.size());
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if (convertView == null){
            convertView = inflater.inflate(R.layout.item_msg,parent,false);
            viewHolder = new ViewHolder();

            viewHolder.ll_left = convertView.findViewById(R.id.ll_left);
            viewHolder.tv_received = convertView.findViewById(R.id.item_tv_received);
            viewHolder.ll_right = convertView.findViewById(R.id.ll_right);
            viewHolder.tv_send = convertView.findViewById(R.id.item_tv_send);

            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        if (data.get(position).getType() == MsgBean.TYPE_RECEIVED){
            viewHolder.ll_left.setVisibility(View.VISIBLE);
            viewHolder.ll_right.setVisibility(View.GONE);
            viewHolder.tv_received.setText(data.get(position).getContent());
        }else if (data.get(position).getType() == MsgBean.TYPE_SENT){
            viewHolder.ll_left.setVisibility(View.GONE);
            viewHolder.ll_right.setVisibility(View.VISIBLE);
            viewHolder.tv_send.setText(data.get(position).getContent());
        }

        return convertView;
    }

    class ViewHolder{
        private LinearLayout ll_left;
        private TextView tv_received;
        private LinearLayout ll_right;
        private TextView tv_send;
    }


}
