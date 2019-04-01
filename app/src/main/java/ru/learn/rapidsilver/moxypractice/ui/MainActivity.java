package ru.learn.rapidsilver.moxypractice.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import ru.learn.rapidsilver.moxypractice.R;
import ru.learn.rapidsilver.moxypractice.mvp.presenter.MainActivityPresenter;
import ru.learn.rapidsilver.moxypractice.mvp.view.MainActivityView;
import ru.learn.rapidsilver.moxypractice.ui.adapter.DataRVAdapter;

public class MainActivity extends MvpAppCompatActivity implements MainActivityView {

    @InjectPresenter
    MainActivityPresenter mainActivityPresenter;
    @ProvidePresenter
    public MainActivityPresenter provideMainActivityPresenter(){
        return new MainActivityPresenter(AndroidSchedulers.mainThread());
    }

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivityPresenter.getData();
        initUI();
}

    private void initUI (){
        recyclerView = findViewById(R.id.recyclerview_main);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void setAdapter(DataRVAdapter dataRVAdapter) {
        recyclerView.setAdapter(mainActivityPresenter.getDataRVAdapter());
    }
}
