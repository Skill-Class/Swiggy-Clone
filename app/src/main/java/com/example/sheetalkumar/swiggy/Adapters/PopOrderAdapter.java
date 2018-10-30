package com.example.sheetalkumar.swiggy.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.sheetalkumar.swiggy.R;

import java.util.ArrayList;


public class PopOrderAdapter extends RecyclerView.Adapter<PopOrderAdapter.ViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";
    //private static final Date LayoutInflater = ;

    //vars
    //  private ArrayList<String> mNames = new ArrayList<>();
   private ArrayList<Integer> popImages = new ArrayList<>();
    //private ArrayList<String> mTime = new ArrayList<>();
    private Context mContext;

    public PopOrderAdapter(ArrayList<Integer> popImages, Context mContext) {
        this.popImages = popImages;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_layout_for_popscreen, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        holder.image.setImageResource(popImages.get(position));

        // holder.name.setText(mNames.get(position));
        // holder.time.setText(mTime.get(position));

        //   Glide.with(mContext).asBitmap().load(mImageUrls.get(position)).into(holder.image);
        // holder.image.setImageResource(mImageUrls.get(position));


    }

    @Override
    public int getItemCount() {
        return popImages.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        // TextView name;
        // TextView time;

        public ViewHolder(View itemView) {
            super(itemView);
           image = itemView.findViewById(R.id.imageView13);
            //    name = itemView.findViewById(R.id.textView2);
            //  time = itemView.findViewById(R.id.textView3);
        }
    }
}