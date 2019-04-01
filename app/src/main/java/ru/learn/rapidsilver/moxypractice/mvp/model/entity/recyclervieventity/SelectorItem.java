package ru.learn.rapidsilver.moxypractice.mvp.model.entity.recyclervieventity;

import java.util.List;

public class SelectorItem implements DataListItem {
    List<Integer> id;
    List<String> text;

    public SelectorItem(List<Integer> id, List<String> text) {
        this.id = id;
        this.text = text;
    }

    public List<Integer> getId() {
        return id;
    }

    public void setId(List<Integer> id) {
        this.id = id;
    }

    public List<String> getText() {
        return text;
    }

    public void setText(List<String> text) {
        this.text = text;
    }
}
