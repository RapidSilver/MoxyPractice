package ru.learn.rapidsilver.moxypractice.mvp.model.api;

import io.reactivex.Single;
import retrofit2.http.GET;
import ru.learn.rapidsilver.moxypractice.mvp.model.entity.JSONSample;

public interface DataSource {
    @GET("JSONSample.json")
    Single<JSONSample> getJSONSample();
}
