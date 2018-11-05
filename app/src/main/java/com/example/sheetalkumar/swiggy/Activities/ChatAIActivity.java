package com.example.sheetalkumar.swiggy.Activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.speech.RecognizerIntent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.sheetalkumar.swiggy.R;
import com.google.gson.JsonElement;

import java.util.ArrayList;
import java.util.Map;

import ai.api.AIListener;
import ai.api.android.AIConfiguration;
import ai.api.android.AIService;
import ai.api.model.AIError;
import ai.api.model.AIResponse;
import ai.api.model.Result;

public class ChatAIActivity extends AppCompatActivity implements AIListener {

    private FloatingActionButton floatingActionButton;
    private TextView textView_result, textView_back, textView_query;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatai);

        floatingActionButton = findViewById(R.id.floatingActionButton);
        textView_result = findViewById(R.id.textView_result);
        textView_back = findViewById(R.id.textView32);
        textView_query = findViewById(R.id.textView_query);

        textView_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChatAIActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


        int permission = ContextCompat.checkSelfPermission(this,
                Manifest.permission.RECORD_AUDIO);

        if (permission != PackageManager.PERMISSION_GRANTED) {

            createRequest();
        }

        final AIConfiguration config = new AIConfiguration("@@@@@@@",
                AIConfiguration.SupportedLanguages.English,
                AIConfiguration.RecognitionEngine.System);
        final AIService aiService = AIService.getService(this, config);
        aiService.setListener(this);


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aiService.startListening();
            }
        });


    }

    private void createRequest() {
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.RECORD_AUDIO},
                1);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {

                if (grantResults.length == 0
                        || grantResults[0] !=
                        PackageManager.PERMISSION_GRANTED) {
                } else {

                }
                return;
            }
        }
    }

    @Override
    public void onResult(AIResponse result) {

        Result result1 = result.getResult();
        String parameterString = "";
        if (result1.getParameters() != null && !result1.getParameters().isEmpty()) {
            for (final Map.Entry<String, JsonElement> entry : result1.getParameters().entrySet()) {
                parameterString += "(" + entry.getKey() + ", " + entry.getValue() + ") ";
            }
        }

        textView_query.setText(result1.getResolvedQuery());
        textView_result.setText(result1.getFulfillment().getSpeech());

    }


    @Override
    public void onError(AIError error) {

    }

    @Override
    public void onAudioLevel(float level) {

    }

    @Override
    public void onListeningStarted() {

    }

    @Override
    public void onListeningCanceled() {

    }

    @Override
    public void onListeningFinished() {

    }
}
