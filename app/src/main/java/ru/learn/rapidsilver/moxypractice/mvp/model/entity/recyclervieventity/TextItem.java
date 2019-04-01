package ru.learn.rapidsilver.moxypractice.mvp.model.entity.recyclervieventity;

public class TextItem implements DataListItem {
    private String itemText;

    public TextItem(String itemText) {
        this.itemText = itemText;
    }

    public String getItemText() {
        return itemText;
    }

    public void setItemText(String itemText) {
        this.itemText = itemText;
    }
}
