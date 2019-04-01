package ru.learn.rapidsilver.moxypractice.mvp.model.entity;

import java.util.ArrayList;
import java.util.List;

public class JSONSample {
    private List<Data> data;
    private ArrayList<String> view;

    public JSONSample(List<Data> data, ArrayList<String> view) {
        this.data = data;
        this.view = view;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public List<String> getView() {
        return view;
    }

    public void setView(ArrayList<String> view) {
        this.view = view;
    }
}
