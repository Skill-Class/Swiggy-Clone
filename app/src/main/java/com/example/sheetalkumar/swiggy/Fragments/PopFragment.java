package com.example.sheetalkumar.swiggy.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sheetalkumar.swiggy.Adapters.PopOrderAdapter;
import com.example.sheetalkumar.swiggy.Adapters.PreviousOrderAdapter;
import com.example.sheetalkumar.swiggy.R;

import java.util.ArrayList;


public class PopFragment extends Fragment {


    private ArrayList<Integer> popImages = new ArrayList<>();

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
            getImages();
    }

    private void getImages() {
        popImages.add(R.drawable.popone);
        popImages.add(R.drawable.poptwo);
        popImages.add(R.drawable.popthree);
        popImages.add(R.drawable.popfour);
        popImages.add(R.drawable.popfive);
        popImages.add(R.drawable.popsix);
        popImages.add(R.drawable.popone);
        popImages.add(R.drawable.poptwo);
        popImages.add(R.drawable.popthree);
        popImages.add(R.drawable.popfour);
        popImages.add(R.drawable.popfive);
        popImages.add(R.drawable.popsix);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_pop, container, false);

      /*  GridLayoutManager layoutManagerForItems = new GridLayoutManager(getActivity(), 6);
        RecyclerView itemRecyclerView = rootView.findViewById(R.id.pop_recyclerView);

        itemRecyclerView.setLayoutManager(layoutManagerForItems);

        PopOrderAdapter adapterforItem = new PopOrderAdapter(getContext());
        itemRecyclerView.setAdapter(adapterforItem);
        R
*/
      RecyclerView recyclerView = rootView.findViewById(R.id.pop_recyclerView);
        PopOrderAdapter adapterforItem = new PopOrderAdapter(popImages,getContext());
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 3);
        recyclerView.setLayoutManager(mLayoutManager);

       // recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(8), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapterforItem);
        recyclerView.setNestedScrollingEnabled(false);


        return rootView;
    }

}
