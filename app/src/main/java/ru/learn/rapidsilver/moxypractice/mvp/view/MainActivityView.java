package ru.learn.rapidsilver.moxypractice.mvp.view;

import com.arellomobile.mvp.MvpView;
import ru.learn.rapidsilver.moxypractice.ui.adapter.DataRVAdapter;

public interface MainActivityView extends MvpView {
    void setAdapter(DataRVAdapter dataRVAdapter);
}
