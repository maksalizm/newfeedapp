package com.example.maksalizm.newsfeedapp;

import android.graphics.Bitmap;
import android.preference.PreferenceFragment;

/**
 * Created by pms on 2016. 10. 31..
 */

public class News {

    private String mTitle;
    private String mContent;
    private long mPublicationDate;
    private String mType;
    private String mUrl;
    private Bitmap mThumbnail;

    public News(String vTitle, long vPublicationDate, String vType, String vUrl) {
        mTitle = vTitle;
        mPublicationDate = vPublicationDate;
        mType = vType;
        mUrl = vUrl;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getContent() {
        return mContent;
    }

    public long getPublicationDDate() {
        return mPublicationDate;
    }

    public String getType() {
        return mType;
    }

    public String getUrl() {
        return mUrl;
    }

    public Bitmap getThumbnail() {
        return mThumbnail;
    }

    public void setThumbnail(Bitmap vBm) {
        mThumbnail = vBm;
    }
    public void setContent(String vContent) {
        mContent = vContent;
    }
}
