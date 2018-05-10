package com.example.user.newsapi;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Html;
import android.support.annotation.DrawableRes;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import static android.view.View.GONE;

/**
 * Created by user on 10-May-18.
 */

public class ArticlesViewAdapter extends ArrayAdapter<ArticlesItem> {

    private Context mContext;
    private int layoutResourceId;

    private ArrayList<ArticlesItem> mListData = new ArrayList<ArticlesItem>();


    public ArticlesViewAdapter(Context mContext, int layoutResourceId, ArrayList<ArticlesItem> mListData) {
        super(mContext,layoutResourceId,mListData);
        this.layoutResourceId = layoutResourceId;
        this.mContext = mContext;
        this.mListData = mListData;

    }
    public void setListData(ArrayList<ArticlesItem> mListData) {
        this.mListData = mListData;
        notifyDataSetChanged();
    }


    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;

        ArticlesViewAdapter.ViewHolder holder;

        if (row == null) {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent,false);
            holder = new ArticlesViewAdapter.ViewHolder();
            holder.titleTextView = (TextView) row.findViewById(R.id.list_item_title);
            holder.imageView = (ImageView) row.findViewById(R.id.list_item_image);
            holder.descriptionTextView = (TextView) row.findViewById(R.id.list_item_description);
            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }



        ArticlesItem item = mListData.get(position);

        if (!TextUtils.isEmpty(Html.fromHtml(item.getTitle()))) {

            holder.titleTextView.setText(Html.fromHtml(item.getTitle()));

        } else {

            holder.titleTextView.setVisibility(GONE);
        }

        if ((item.getDescription()).toString() != "null") {

            holder.descriptionTextView.setText(Html.fromHtml(item.getDescription()));

        } else {
            holder.descriptionTextView.setVisibility(GONE);

        }

        if ((item.getImage()).toString() != "null" && !TextUtils.isEmpty(item.getImage())) {

            Picasso.with(mContext).load(item.getImage()).into(holder.imageView);


        } else {

            holder.imageView.setImageResource(R.drawable.background);
        }



        return row;

    }

    static class ViewHolder {
        TextView titleTextView;
        ImageView imageView;
        TextView descriptionTextView;
    }
}
