package ru.learn.rapidsilver.moxypractice.mvp.model.repo;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import ru.learn.rapidsilver.moxypractice.mvp.model.api.APIHolder;
import ru.learn.rapidsilver.moxypractice.mvp.model.entity.JSONSample;

public class DataRepo {

    public Single<JSONSample> getData(){
        return APIHolder.getInstance().getApi().getJSONSample().subscribeOn(Schedulers.io());
    }
}
