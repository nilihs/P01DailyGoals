package com.myapplicationdev.android.p01_dailygoals;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnOK = findViewById(R.id.button);
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Get the RadioGroup object
                RadioGroup rg1 = findViewById(R.id.RadioGroup1);
                RadioGroup rg2 = findViewById(R.id.RadioGroup2);
                RadioGroup rg3 = findViewById(R.id.RadioGroup3);


                // Get the ID of the selected radio button in the RadioGroup
                int selectedButtonId1 = rg1.getCheckedRadioButtonId();
                int selectedButtonId2 = rg2.getCheckedRadioButtonId();
                int selectedButtonId3 = rg3.getCheckedRadioButtonId();


                // Get the radio button object from the ID we had gotten above
                RadioButton rb1 = findViewById(selectedButtonId1);
                RadioButton rb2 = findViewById(selectedButtonId2);
                RadioButton rb3 = findViewById(selectedButtonId3);

                EditText etReflection = findViewById(R.id.editTextReflection);


                String[] answer = {rb1.getText().toString(), rb2.getText().toString(), rb3.getText().toString(), etReflection.getText().toString()};

                Intent i = new Intent(MainActivity.this, DailyGoalsActivity.class);

                i.putExtra("goal", answer);

                startActivity(i);

            }
        });

    }

    protected void onPause() {
        super.onPause();

        EditText etReflection = findViewById(R.id.editTextReflection);

        // Get the RadioGroup object
        RadioGroup rg1 = findViewById(R.id.RadioGroup1);
        RadioGroup rg2 = findViewById(R.id.RadioGroup2);
        RadioGroup rg3 = findViewById(R.id.RadioGroup3);


        String strReflection = etReflection.getText().toString();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        SharedPreferences.Editor prefEdit = prefs.edit();

        prefEdit.putString("reflection", strReflection);
        prefEdit.putInt("r1", rg1.getCheckedRadioButtonId());
        prefEdit.putInt("r2", rg2.getCheckedRadioButtonId());
        prefEdit.putInt("r3", rg3.getCheckedRadioButtonId());

        prefEdit.commit();


    }

    protected void onResume() {
        super.onResume();

        EditText etReflection = findViewById(R.id.editTextReflection);

        // Get the RadioGroup object
        RadioGroup rg1 = findViewById(R.id.RadioGroup1);
        RadioGroup rg2 = findViewById(R.id.RadioGroup2);
        RadioGroup rg3 = findViewById(R.id.RadioGroup3);


        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        String strReflection = prefs.getString("reflection", "");

        int radio1 = prefs.getInt("r1",1);
        int radio2 = prefs.getInt("r2",1);
        int radio3 = prefs.getInt("r3",1);

        rg1.check(radio1);
        rg2.check(radio2);
        rg3.check(radio3);

        etReflection.setText(strReflection);

    }
}
