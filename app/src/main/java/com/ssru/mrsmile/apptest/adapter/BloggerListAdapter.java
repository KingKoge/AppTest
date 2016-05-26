package com.ssru.mrsmile.apptest.adapter;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;

import com.ssru.mrsmile.apptest.R;
import com.ssru.mrsmile.apptest.dao.BloggerDao;
import com.ssru.mrsmile.apptest.dao.BloggerItem;
import com.ssru.mrsmile.apptest.views.BloggerListItem;

import java.util.Collections;

/**
 * Created by Mr.Smile on 5/21/2016.
 */
public class BloggerListAdapter extends BaseAdapter {

    private int lastPosition;

    private BloggerDao dao;

    private String title = "";

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
        if (dao.getLabels().size() != 0){
            String label = dao.getLabels().get(0);

            if (position == 0) {
                item.setTitleText(label);
                item.showTitleText();
            }else {
                BloggerItem beforeDao = (BloggerItem) getItem(position-1);
                if (label.equalsIgnoreCase(beforeDao.getLabels().get(0))) {
                    item.hiddenTitleText();
                } else {
                    item.setTitleText(label);
                    item.showTitleText();
                }
            }
        }

        item.setNameText(dao.getTitle());
        if (dao.getImages().size() != 0)
            item.setImageUrl(dao.getImages().get(0).getUrl());

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
}
