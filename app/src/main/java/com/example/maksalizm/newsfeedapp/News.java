package com.example.maksalizm.newsfeedapp;

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
    private String mThumbnail;

    public News(String vTitle, String vContent, long vPublicationDate, String vType, String vUrl, String vThumbnail) {
        mTitle = vTitle;
        mContent = vContent;
        mPublicationDate = vPublicationDate;
        mType = vType;
        mUrl = vUrl;
        mThumbnail = vThumbnail;
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

    public String getThumbnail() {
        return mThumbnail;
    }
}
