package com.ssru.mrsmile.apptest.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;

import com.ssru.mrsmile.apptest.R;
import com.ssru.mrsmile.apptest.dao.BloggerDao;
import com.ssru.mrsmile.apptest.dao.BloggerItem;
import com.ssru.mrsmile.apptest.views.BloggerListItem;

/**
 * Created by Mr.Smile on 5/21/2016.
 */
public class BloggerListAdapter extends BaseAdapter {

    private int lastPosition;

    private BloggerDao dao;

    public void setDao(BloggerDao dao) {
        this.dao = dao;
    }

    @Override
    public int getCount() {
        if (dao == null)
            return 0;
        if (dao.getBloggerItems() == null)
            return 0;
        return dao.getBloggerItems().size();
    }

    @Override
    public Object getItem(int position) {
        return dao.getBloggerItems().get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        // return count type view group
        return 1;
    }

    @Override
    public int getItemViewType(int position) {
        // return position type view group
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        BloggerListItem item;
        if (convertView != null) {
            item = (BloggerListItem) convertView;
        } else {
            // the parent is viewGroup , viewGroup have Context
            item = new BloggerListItem(parent.getContext());
        }

        BloggerItem dao = (BloggerItem) getItem(position);
        item.setNameText(dao.getTitle());
        item.setImageUrl(dao.getAuthor().getImage().getUrl());

        if (position > lastPosition) {
            Animation anim = AnimationUtils.loadAnimation(
                    parent.getContext(),
                    R.anim.up_from_bottom
            );
            item.startAnimation(anim);
            lastPosition = position;
        }

        return item;
    }

    public void increaseLastPosition(int amount) {
        lastPosition += amount;
    }
}
