package com.ybg.app.show.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ybg.app.show.R;
import com.ybg.app.show.bean.ShowItem;
import com.ybg.app.show.holder.ItemCardHolder;

import java.util.List;

/**
 * Created by yangbagang on 16/9/13.
 */
public class ItemRecyclerAdapter extends RecyclerView.Adapter<ItemCardHolder> {

    private Context context;

    private List<ShowItem> list;

    private OnItemClickListener mListener;

    public ItemRecyclerAdapter(Context context, List<ShowItem> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ItemCardHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.main_item, parent, false);
        ItemCardHolder viewHolder = new ItemCardHolder(view);
        viewHolder.setIsRecyclable(true);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ItemCardHolder holder, int position) {
        holder.getItemTitle().setText(list.get(position).getTitle());

        if (mListener != null) {//如果设置了监听那么它就不为空，然后回调相应的方法
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();//得到当前点击item的位置pos
                    mListener.ItemClickListener(holder.itemView, pos);//把事件交给我们实现的接口那里处理
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int pos = holder.getLayoutPosition();//得到当前点击item的位置pos
                    mListener.ItemLongClickListener(holder.itemView, pos);//把事件交给我们实现的接口那里处理
                    return true;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if (list == null) return 0;
        return list.size();
    }

    public interface OnItemClickListener {
        void ItemClickListener(View view, int postion);

        void ItemLongClickListener(View view, int postion);
    }

    public void setOnClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }
}
