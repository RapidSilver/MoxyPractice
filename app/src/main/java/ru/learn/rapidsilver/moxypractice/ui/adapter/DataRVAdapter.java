package ru.learn.rapidsilver.moxypractice.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import ru.learn.rapidsilver.moxypractice.R;
import ru.learn.rapidsilver.moxypractice.mvp.model.entity.recyclervieventity.DataListItem;

import java.util.List;

public class DataRVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<DataListItem> dataListItems;
    private List<String> displaysequence;
    private int position;

    public final String TEXT_TYPE = "hz";
    public final String IMAGE_TYPE = "picture";
    public final String SELECTOR_TYPE = "selector";

    public DataRVAdapter (List<DataListItem> dataListItems, List<String> displaysequence){
        this.dataListItems = dataListItems;
        this.displaysequence = displaysequence;
        this.position = 0;
    }
//вот это жуткий костыль, для этого должен быть какойто стандартный способ, но я его не нашел...
    public void positionCounter(){
        position++;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        System.out.println("onCreateViewHolder" + position);
        DataListItem item = dataListItems.get(position);
        Context context = viewGroup.getContext();
        View itemLayoutView = chooseView(viewGroup, position);
        RecyclerView.ViewHolder vievHolder = chooseVievHolder(position,item,context,itemLayoutView);

        positionCounter();
        return vievHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        IViewHolder iViewHolder = (IViewHolder) viewHolder;
        iViewHolder.bind();
    }

    @Override
    public int getItemCount() {
        return dataListItems.size();
    }

    public RecyclerView.ViewHolder chooseVievHolder (int position, DataListItem item, Context context, View view) {
        RecyclerView.ViewHolder viewHolder = null;
        if (displaysequence.get(position).contains(TEXT_TYPE)){
            viewHolder = new TextViewHolder(view, item);
        } else if (displaysequence.get(position).contains(IMAGE_TYPE)){
            viewHolder = new ImageViewHolder(view, item, context);
        } else if (displaysequence.get(position).contains(SELECTOR_TYPE)){
            viewHolder = new SpinerViewHolder(view,context,item);
        }
        System.out.println(position);
        return viewHolder;
    }

    public View chooseView(ViewGroup viewGroup, int position){
        View view;
        if (displaysequence.get(position).contains(TEXT_TYPE)){
            view = LayoutInflater.from(viewGroup.getContext()).inflate(
                    R.layout.textitem_cardview,viewGroup,false);
        } else if (displaysequence.get(position).contains(IMAGE_TYPE)){
            view = LayoutInflater.from(viewGroup.getContext()).inflate(
                    R.layout.imageitem_cardview,viewGroup,false);
        } else if (displaysequence.get(position).contains(SELECTOR_TYPE)){
            view = LayoutInflater.from(viewGroup.getContext()).inflate(
                    R.layout.selectoritem_cardview,viewGroup,false);
        } else {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(
                    R.layout.notsuported_cardview,viewGroup,false);
        }
        return view;
    }
}
