package com.example.sheetalkumar.swiggy.Activities;

import android.content.Intent;
import android.support.annotation.NonNull;

import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


import com.example.sheetalkumar.swiggy.Fragments.AccountFragment;
import com.example.sheetalkumar.swiggy.Fragments.CartFragment;
import com.example.sheetalkumar.swiggy.Fragments.ExploreFragment;
import com.example.sheetalkumar.swiggy.Fragments.NearMeFragment;
import com.example.sheetalkumar.swiggy.Fragments.PopFragment;
import com.example.sheetalkumar.swiggy.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private FloatingActionButton floatingActionButton2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        floatingActionButton2 = findViewById(R.id.floatingActionButton2);
        floatingActionButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ChatAIActivity.class);
                startActivity(intent);
            }
        });
        bottomNavigationView = findViewById(R.id.navigation);
        loadFragment(new NearMeFragment());

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment;
                switch (menuItem.getItemId()) {
                    case R.id.near_me:
                        fragment = new NearMeFragment();
                        loadFragment(fragment);
    //                    Toast.makeText(MainActivity.this, "Near Me", Toast.LENGTH_LONG).show();
                        return true;
                    case R.id.explore:
      //                  Toast.makeText(MainActivity.this, "Explore", Toast.LENGTH_LONG).show();
                        fragment = new ExploreFragment();
                        loadFragment(fragment);
                        return true;
                    case R.id.pop:
        //                Toast.makeText(MainActivity.this, "POP", Toast.LENGTH_LONG).show();
                        fragment = new PopFragment();
                        loadFragment(fragment);
                        return true;
                    case R.id.cart:
          //              Toast.makeText(MainActivity.this, "Cart", Toast.LENGTH_LONG).show();
                        fragment = new CartFragment();
                        loadFragment(fragment);
                        return true;
                    case R.id.account:
                        fragment = new AccountFragment();
                        loadFragment(fragment);
            //            Toast.makeText(MainActivity.this, "Account", Toast.LENGTH_LONG).show();
                        return true;
                }
                return false;
            }
        });


        // calling getImages function to take all static data.
        //getImages();
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }
}
