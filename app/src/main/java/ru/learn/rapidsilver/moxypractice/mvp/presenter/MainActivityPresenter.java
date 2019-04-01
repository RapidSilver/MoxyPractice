package ru.learn.rapidsilver.moxypractice.mvp.presenter;

import android.net.Uri;
import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import io.reactivex.Scheduler;
import ru.learn.rapidsilver.moxypractice.mvp.model.entity.JSONSample;
import ru.learn.rapidsilver.moxypractice.mvp.model.entity.Variants;
import ru.learn.rapidsilver.moxypractice.mvp.model.entity.recyclervieventity.DataListItem;
import ru.learn.rapidsilver.moxypractice.mvp.model.entity.recyclervieventity.ImageItem;
import ru.learn.rapidsilver.moxypractice.mvp.model.entity.recyclervieventity.SelectorItem;
import ru.learn.rapidsilver.moxypractice.mvp.model.entity.recyclervieventity.TextItem;
import ru.learn.rapidsilver.moxypractice.mvp.model.repo.DataRepo;
import ru.learn.rapidsilver.moxypractice.mvp.view.MainActivityView;
import ru.learn.rapidsilver.moxypractice.ui.adapter.DataRVAdapter;

import java.util.ArrayList;
import java.util.List;

@InjectViewState
public class MainActivityPresenter extends MvpPresenter<MainActivityView> {

    private Scheduler mainThredScheduler;
    private DataRepo dataRepo;
    private List<String> displaySequence;
    private List<DataListItem> dataListItems;
    private DataRVAdapter dataRVAdapter;


    public MainActivityPresenter(Scheduler mainThredScheduler) {
        this.mainThredScheduler = mainThredScheduler;
        this.dataRepo = new DataRepo();
        dataListItems = new ArrayList<>();

    }

    public boolean getData(){
        dataRepo.getData()
                .observeOn(mainThredScheduler)
                .subscribe(jsonSample -> {
                    displaySequence = new ArrayList<>(jsonSample.getView());
                    for (int i = 0; i < displaySequence.size(); i++) {
                        if (displaySequence.get(i).contains("hz")){
                            dataListItems.add(getTextItem(jsonSample));
                        } else if (displaySequence.get(i).contains("picture")){
                            dataListItems.add(getImageItem(jsonSample));
                        } else if (displaySequence.get(i).contains("selector")){
                            dataListItems.add(getSelectorItem(jsonSample));
                        }
                    }
                    dataRVAdapter = new DataRVAdapter(dataListItems,displaySequence);
                    getViewState().setAdapter(dataRVAdapter);
                }, throwable -> {

                });
        return true;
    }

    public SelectorItem getSelectorItem (JSONSample jsonSample){
        List<Variants> variants = jsonSample.getData().get(2).getDataElement().getVariants();
        List<Integer> id = new ArrayList<>();
        List<String> text = new ArrayList<>();
        for (int i = 0; i < variants.size(); i++) {
            id.add(variants.get(i).getId());
            text.add(variants.get(i).getText());
        }
        return new SelectorItem(id, text);
    }

    public ImageItem getImageItem (JSONSample jsonSample){
        Uri uri = Uri.parse(jsonSample.getData().get(1).getDataElement().getUrl());
        String text = jsonSample.getData().get(1).getDataElement().getText();
        return new ImageItem(uri,text);
    }

    public TextItem getTextItem (JSONSample jsonSample){
        return new TextItem(jsonSample.getData().get(0).getDataElement().getText());
    }

    public DataRVAdapter getDataRVAdapter (){
       return dataRVAdapter;
    }
}
