package com.ssru.mrsmile.apptest.manager.http;

import com.ssru.mrsmile.apptest.dao.BloggerDao;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Mr.Smile on 5/21/2016.
 */
public interface ApiService {

    @GET("blogger/v3/blogs/{blogId}/posts")
    Call<BloggerDao> loadBlogger(@Path("blogId") String blogId,
                                 @Query("key") String key,
                                 @Query("fetchBodies") boolean fetchBodies,
                                 @Query("fetchImages") boolean fetchImages,
                                 @Query("maxResults") int maxResults);
}
