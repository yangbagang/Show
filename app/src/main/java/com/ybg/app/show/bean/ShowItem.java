package com.ybg.app.show.bean;

import java.io.Serializable;

/**
 * Created by yangbagang on 16/9/13.
 */
public class ShowItem implements Serializable {

    private String pic;

    private String title;

    public ShowItem(String pic, String title) {
        this.pic = pic;
        this.title = title;
    }

    public String getPic() {

        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
