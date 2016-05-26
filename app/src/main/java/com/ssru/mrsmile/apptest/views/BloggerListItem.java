package com.ssru.mrsmile.apptest.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.ssru.mrsmile.apptest.R;
import com.ssru.mrsmile.apptest.views.state.BundleSavedState;


/**
 * Created by nuuneoi on 11/16/2014.
 */
public class BloggerListItem extends BaseCustomViewGroup {

    public BloggerListItem(Context context) {
        super(context);
        initInflate();
        initInstances();
    }

    public BloggerListItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        initInflate();
        initInstances();
        initWithAttrs(attrs, 0, 0);
    }

    public BloggerListItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initInflate();
        initInstances();
        initWithAttrs(attrs, defStyleAttr, 0);
    }

    @TargetApi(21)
    public BloggerListItem(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initInflate();
        initInstances();
        initWithAttrs(attrs, defStyleAttr, defStyleRes);
    }

    private void initInflate() {
        inflate(getContext(), R.layout.list_item_blogs, this);
    }

    private ImageView ivImg;
    private TextView tvName;
    private TextView tvTitle;

    private void initInstances() {
        // findViewById here
        ivImg = (ImageView) findViewById(R.id.ivImg);
        tvName = (TextView) findViewById(R.id.tvName);
        tvTitle = (TextView) findViewById(R.id.tvTitle);
    }

    private void initWithAttrs(AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        /*
        TypedArray a = getContext().getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.StyleableName,
                defStyleAttr, defStyleRes);

        try {

        } finally {
            a.recycle();
        }
        */
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();

        BundleSavedState savedState = new BundleSavedState(superState);
        // Save Instance State(s) here to the 'savedState.getBundle()'
        // for example,
        // savedState.getBundle().putString("key", value);

        return savedState;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        BundleSavedState ss = (BundleSavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());

        Bundle bundle = ss.getBundle();
        // Restore State from bundle here
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = width * 2 / 3;

        int newHeightMeasureSpec = MeasureSpec.makeMeasureSpec(
                height,
                MeasureSpec.EXACTLY
        );

        // child Views
        super.onMeasure(widthMeasureSpec, newHeightMeasureSpec);

        //self
        setMeasuredDimension(width , height);  // it a px type
    }

    public void setTitleText(String text){
        tvTitle.setText(text);
    }

    public void showTitleText(){
        tvTitle.setVisibility(VISIBLE);
    }

    public void hiddenTitleText(){
        tvTitle.setVisibility(GONE);
    }

    public void setNameText(String text){
        tvName.setText(text);
    }

    public void setImageUrl(String url){
        Glide.with(getContext())
                .load(url)
                .placeholder(R.drawable.loading)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(ivImg);
    }
}
