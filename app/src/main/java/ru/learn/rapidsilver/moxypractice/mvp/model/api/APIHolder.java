package ru.learn.rapidsilver.moxypractice.mvp.model.api;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIHolder {
    private DataSource api;

    private static APIHolder instance = new APIHolder();

    public static APIHolder getInstance() {
        if (instance == null){
            instance = new APIHolder();
        }
        return instance;
    }

    private APIHolder() {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        api = new Retrofit.Builder()
                .baseUrl("https://prnk.blob.core.windows.net/tmp/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(DataSource.class);
    }

    public DataSource getApi() {
        return api;
    }
}
