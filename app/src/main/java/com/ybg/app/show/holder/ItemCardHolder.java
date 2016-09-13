package com.ybg.app.show.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ybg.app.show.R;

/**
 * Created by yangbagang on 16/9/13.
 */
public class ItemCardHolder extends RecyclerView.ViewHolder {

    private ImageView itemImage;

    private TextView itemTitle;

    public ItemCardHolder(View itemView) {
        super(itemView);
        itemImage = (ImageView) itemView.findViewById(R.id.item_img);
        itemTitle = (TextView) itemView.findViewById(R.id.item_title);
    }

    public ImageView getItemImage() {
        return itemImage;
    }

    public void setItemImage(ImageView itemImage) {
        this.itemImage = itemImage;
    }

    public TextView getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(TextView itemTitle) {
        this.itemTitle = itemTitle;
    }
}
