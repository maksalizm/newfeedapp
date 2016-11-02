package com.example.maksalizm.newsfeedapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.content.AsyncTaskLoader;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

/**
 * Created by pms on 2016. 11. 1..
 */

public class NewsLoader extends AsyncTaskLoader<List<News>> {

    private static final String LOG_TAG = NewsLoader.class.getName();

    private String mUrl;

    public NewsLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<News> loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        List <News> newses = QueryUtils.fetchNewsData(mUrl);

        for(int i = 0; i < newses.size(); i++) {
            News currentNews = newses.get(i);
            try {
                Document doc = Jsoup.connect(currentNews.getUrl()).get();
                Elements content = doc.select("div.content__article-body > p");
                currentNews.setContent(content.text());

                String thumbnailSrc = doc.select("meta[name='thumbnail']").attr("src");

                try {
                    InputStream in = new URL(thumbnailSrc).openStream();
                    Bitmap thumbnail = BitmapFactory.decodeStream(in);
                    currentNews.setThumbnail(thumbnail);
                } catch (IOException e) {
                    Log.e("Error", e.getMessage());
                }
            } catch(IOException e){
                Log.e(LOG_TAG, "parsing error",e);
            }
        }

        return newses;
    }
}
