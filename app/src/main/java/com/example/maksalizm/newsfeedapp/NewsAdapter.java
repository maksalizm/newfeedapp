package com.example.maksalizm.newsfeedapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;




/**
 * Created by pms on 2016. 10. 31..
 */

public class NewsAdapter extends ArrayAdapter <News> {

    public NewsAdapter(Activity context, ArrayList<News> newses ) {
        super(context, 0, newses);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;

        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        News currentNews = getItem(position);

        TextView newsTitleTextView = (TextView) listItemView.findViewById(R.id.news_title);

        newsTitleTextView.setText(currentNews.getTitle());

        TextView newsTypeTextView = (TextView) listItemView.findViewById(R.id.news_type);

        newsTypeTextView.setText(currentNews.getType());

        Date dateObject = new Date(currentNews.getPublicationDDate());

        TextView newsPubicationDateView = (TextView) listItemView.findViewById(R.id.news_date);

        String formattedPublicationDate = formatPulicationDate(dateObject);

        newsPubicationDateView.setText(formattedPublicationDate);




        return listItemView;
    }

    private String formatPulicationDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }
}
