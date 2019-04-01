package ru.learn.rapidsilver.moxypractice.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;
import ru.learn.rapidsilver.moxypractice.R;
import ru.learn.rapidsilver.moxypractice.mvp.model.entity.recyclervieventity.DataListItem;
import ru.learn.rapidsilver.moxypractice.mvp.model.entity.recyclervieventity.ImageItem;

public class ImageViewHolder extends RecyclerView.ViewHolder implements IViewHolder {
    private ImageView imageView;
    private DataListItem item;
    private Context context;

    public ImageViewHolder(@NonNull View itemView, DataListItem item, Context context) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageview);
        this.item = item;
        this.context = context;
    }

    public void bind (){
            setImageItem(item);
    }

    public void setImageItem(DataListItem item){
        ImageItem imageItem = (ImageItem) item;
        Picasso.with(context).load(imageItem.getImageUri()).into(imageView);
    }
}

