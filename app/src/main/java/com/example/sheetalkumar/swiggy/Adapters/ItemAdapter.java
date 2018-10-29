package com.example.sheetalkumar.swiggy.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sheetalkumar.swiggy.R;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";
    //private static final Date LayoutInflater = ;

    //vars
    //  private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<Integer> ItemImages = new ArrayList<>();
    private ArrayList<String> ItemName = new ArrayList<>();
    //private ArrayList<String> mTime = new ArrayList<>();
    private Context mContext;

    public ItemAdapter(Context context, ArrayList<Integer> imageUrls,ArrayList<String> itemname) {
        // mNames = names;
        ItemImages = imageUrls;
        //  mTime = time;
        ItemName=itemname;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_layout_for_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        holder.image.setImageResource(ItemImages.get(position));
        holder.itemName.setText(ItemName.get(position));

        // holder.name.setText(mNames.get(position));
        // holder.time.setText(mTime.get(position));

        //   Glide.with(mContext).asBitmap().load(mImageUrls.get(position)).into(holder.image);
        // holder.image.setImageResource(mImageUrls.get(position));


    }

    @Override
    public int getItemCount() {
        return ItemImages.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView itemName;
        // TextView name;
        // TextView time;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.custom_itemImages);
            itemName = itemView.findViewById(R.id.item_name);
            //    name = itemView.findViewById(R.id.textView2);
            //  time = itemView.findViewById(R.id.textView3);
        }
    }
}