package ru.learn.rapidsilver.moxypractice.mvp.model.entity;

import com.google.gson.annotations.SerializedName;

public class Data {
    private String name;
    @SerializedName("data")
    private DataElement dataElement;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DataElement getDataElement() {
        return dataElement;
    }

    public void setDataElement(DataElement dataElement) {
        this.dataElement = dataElement;
    }
}
