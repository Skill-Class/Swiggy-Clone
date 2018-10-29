package com.example.sheetalkumar.swiggy.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.sheetalkumar.swiggy.Adapters.ItemAdapter;
import com.example.sheetalkumar.swiggy.Adapters.OfferAdapter;
import com.example.sheetalkumar.swiggy.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Integer> OfferImages = new ArrayList<>();
    private ArrayList<Integer> itemImages = new ArrayList<>();
    private ArrayList<String> itemName = new ArrayList<>();

    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
 
        getImages();
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



            
        
        initRecycleterView();
    }

    private void initRecycleterView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView offterRecyclerView = findViewById(R.id.offter_recyclerView);
        offterRecyclerView.setLayoutManager(layoutManager);
        OfferAdapter adapter = new OfferAdapter(this, OfferImages);
        offterRecyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManagerForItems = new LinearLayoutManager(this, LinearLayoutManager. VERTICAL, false);
        RecyclerView itemRecyclerView = findViewById(R.id.items_recyclerView);
        itemRecyclerView.setLayoutManager(layoutManagerForItems);
        ItemAdapter adapterforItem = new ItemAdapter(this, itemImages,itemName);
        itemRecyclerView.setAdapter(adapterforItem);
    }
}
