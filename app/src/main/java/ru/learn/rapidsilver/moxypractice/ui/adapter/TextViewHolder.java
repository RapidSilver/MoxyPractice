package ru.learn.rapidsilver.moxypractice.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import ru.learn.rapidsilver.moxypractice.R;
import ru.learn.rapidsilver.moxypractice.mvp.model.entity.recyclervieventity.DataListItem;
import ru.learn.rapidsilver.moxypractice.mvp.model.entity.recyclervieventity.TextItem;

public class TextViewHolder extends RecyclerView.ViewHolder implements IViewHolder {
    private TextView textView;
    private DataListItem item;

    public TextViewHolder(@NonNull View itemView, DataListItem item) {
        super(itemView);
        textView = itemView.findViewById(R.id.textitemview);
        this.item = item;
    }

    public void bind(){
            setTextItem(item);
    }

    private void setTextItem(DataListItem item) {
        TextItem textItem = (TextItem) item;
        textView.setText(textItem.getItemText());
    }
}
