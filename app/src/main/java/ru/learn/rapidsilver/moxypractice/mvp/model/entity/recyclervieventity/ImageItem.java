package ru.learn.rapidsilver.moxypractice.mvp.model.entity.recyclervieventity;

import android.net.Uri;

public class ImageItem implements DataListItem {
    private Uri imageUri;
    private String text;

    public ImageItem(Uri imageUri, String text) {
        this.imageUri = imageUri;
        this.text = text;
    }

    public Uri getImageUri() {
        return imageUri;
    }

    public void setImageUri(Uri imageUri) {
        this.imageUri = imageUri;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
