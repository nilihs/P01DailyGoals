package com.myapplicationdev.android.p01_dailygoals;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DailyGoalsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_goals);

        Intent i = getIntent();

        String[] answer = i.getStringArrayExtra("goal");

        TextView tv1 = findViewById(R.id.textView);

        tv1.setText("Read up on materials before class: " + answer[0] + "\n" +
        "Arrive on time so as not to miss important part of the lesson: " + answer[1] + "\n" +
                "Attempt the problem myself: " + answer[2] + "\n" +
                "Reflection: " + answer[3]);

        Button btnClose = findViewById(R.id.buttonFinish);

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

            }
        });

    }
}
