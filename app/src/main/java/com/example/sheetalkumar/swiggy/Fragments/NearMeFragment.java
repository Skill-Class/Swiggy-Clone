package com.example.sheetalkumar.swiggy.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sheetalkumar.swiggy.Adapters.ItemAdapter;
import com.example.sheetalkumar.swiggy.Adapters.OfferAdapter;
import com.example.sheetalkumar.swiggy.R;

import java.util.ArrayList;


public class NearMeFragment extends Fragment {

    private ArrayList<Integer> OfferImages = new ArrayList<>();
    private ArrayList<Integer> itemImages = new ArrayList<>();
    private ArrayList<String> itemName = new ArrayList<>();



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getImages();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_near_me, container, false);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);

        RecyclerView offterRecyclerView = rootView.findViewById(R.id.offter_recyclerView);
        offterRecyclerView.setLayoutManager(layoutManager);
        OfferAdapter adapter = new OfferAdapter(getContext(), OfferImages);
        offterRecyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManagerForItems = new LinearLayoutManager(getActivity(), LinearLayoutManager. VERTICAL, false);
        RecyclerView itemRecyclerView = rootView.findViewById(R.id.items_recyclerView);
        itemRecyclerView.setLayoutManager(layoutManagerForItems);
        ItemAdapter adapterforItem = new ItemAdapter(getContext(), itemImages,itemName);
        itemRecyclerView.setAdapter(adapterforItem);

        return rootView;

    }

    private void getImages() {
        OfferImages.add(R.drawable.offerimageone);
        OfferImages.add(R.drawable.offerimagetwo);
        OfferImages.add(R.drawable.offerimageone);
        OfferImages.add(R.drawable.offerimagetwo);
        OfferImages.add(R.drawable.offerimageone);
        OfferImages.add(R.drawable.offerimagetwo);


        itemImages.add(R.drawable.itemone);
        itemImages.add(R.drawable.itemtwo);
        itemImages.add(R.drawable.itemthree);
        itemImages.add(R.drawable.itemfour);
        itemImages.add(R.drawable.itemone);
        itemImages.add(R.drawable.itemtwo);
        itemImages.add(R.drawable.itemthree);
        itemImages.add(R.drawable.itemfour);
        itemImages.add(R.drawable.itemone);
        itemImages.add(R.drawable.itemtwo);
        itemImages.add(R.drawable.itemthree);
        itemImages.add(R.drawable.itemfour);

        itemName.add("Panjabi Rasoi");
        itemName.add("Hello meal");
        itemName.add("Brijwaasi");
        itemName.add("34 Chawringhee Lane");
        itemName.add("Panjabi Rasoi");
        itemName.add("Hello meal");
        itemName.add("Brijwaasi");
        itemName.add("34 Chawringhee Lane");
        itemName.add("Panjabi Rasoi");
        itemName.add("Hello meal");
        itemName.add("Brijwaasi");
        itemName.add("34 Chawringhee Lane");

    }

}
