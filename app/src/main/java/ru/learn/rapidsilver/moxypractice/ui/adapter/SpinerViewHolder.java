package ru.learn.rapidsilver.moxypractice.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import ru.learn.rapidsilver.moxypractice.R;
import ru.learn.rapidsilver.moxypractice.mvp.model.entity.recyclervieventity.DataListItem;
import ru.learn.rapidsilver.moxypractice.mvp.model.entity.recyclervieventity.SelectorItem;

import java.util.ArrayList;
import java.util.List;


public class SpinerViewHolder extends RecyclerView.ViewHolder implements IViewHolder {
    private Spinner spinner;
    private Button button;
    private TextView textView;
    private Context context;
    private DataListItem item;
    private List<Integer> id;
    private List<String> text;


    public SpinerViewHolder(@NonNull View itemView, Context context, DataListItem item) {
        super(itemView);
        spinner = itemView.findViewById(R.id.spinerview);
        button = itemView.findViewById(R.id.spinerbutton);
        textView = itemView.findViewById(R.id.spinertextview);
        this.context = context;
        this.item = item;
    }

    public void bind (){
            setSelectorItem(item);
    }

    private void setSelectorItem(DataListItem item) {
        SelectorItem selectorItem = (SelectorItem) item;
        id = new ArrayList<>(selectorItem.getId());
        text = new ArrayList<>(selectorItem.getText());
        ArrayAdapter<String> adapter = new ArrayAdapter<>(context,R.layout.selectortextview,
                text);
        spinner.setAdapter(adapter);
        button.setOnClickListener(v -> {
            getID();
        });
    }

    private void getID(){
        int field = 0;
        String selecteditem = String.valueOf(spinner.getSelectedItem());
        for (int i = 0; i < text.size(); i++) {
            if (text.get(i).equals(selecteditem)){
                field = i;
            }
        }
        String result ="id: " + id.get(field).toString() + " text: " + selecteditem;
        textView.setText(result);
    }
}
