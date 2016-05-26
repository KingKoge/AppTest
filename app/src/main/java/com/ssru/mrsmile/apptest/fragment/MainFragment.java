package com.ssru.mrsmile.apptest.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.ssru.mrsmile.apptest.R;
import com.ssru.mrsmile.apptest.adapter.BloggerListAdapter;
import com.ssru.mrsmile.apptest.dao.BloggerDao;
import com.ssru.mrsmile.apptest.manager.BloggerDaoManager;
import com.ssru.mrsmile.apptest.manager.Contextor;
import com.ssru.mrsmile.apptest.manager.HttpManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by nuuneoi on 11/16/2014.
 */
public class MainFragment extends Fragment {

    private ListView listView;
    private BloggerListAdapter listAdapter;
    private BloggerDaoManager daoManager;

    public MainFragment() {
        super();
    }

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        initInstances(rootView);
        return rootView;
    }

    private void initInstances(View rootView) {
        daoManager = new BloggerDaoManager();
        // Init 'View' instance(s) with rootView.findViewById here
        listAdapter = new BloggerListAdapter();
        listView = (ListView) rootView.findViewById(R.id.listView);
        listView.setAdapter(listAdapter);

        reloadData();
    }

    private void reloadData() {
        String blogId = "2112378201659339351";
        String key = "AIzaSyBzL7-wKQl-bOHg7EyFxYrSWDrqIqGbt4Y";
        boolean fetchBodies = false;
        boolean fetchImages = true;
        int maxResults = 30;

        Call<BloggerDao> call = HttpManager.getInstance()
                .getService()
                .loadBlogger(
                        blogId,
                        key,
                        fetchBodies,
                        fetchImages,
                        maxResults
                );

        call.enqueue(new Callback<BloggerDao>() {
            @Override
            public void onResponse(Call<BloggerDao> call, Response<BloggerDao> response) {
                if (response.isSuccessful()) {
                    BloggerDao dao = response.body();
                    daoManager.setDao(dao);
                    listAdapter.setDao(dao);
                    listAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<BloggerDao> call, Throwable t) {

            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    /*
     * Save Instance State Here
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save Instance State here
    }

    /*
     * Restore Instance State Here
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            // Restore Instance State here
        }
    }
}
