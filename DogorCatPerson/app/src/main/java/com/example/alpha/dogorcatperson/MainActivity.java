package com.example.alpha.dogorcatperson;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioGroup canineRadioGroup;
    private RadioButton canineRadioButton;
    private SeekBar seekBar;
    private TextView seekBarTextView;
    private CheckBox cutestCheckBoxDog, cutestCheckBoxCat, cutestCheckBoxParrot;
    private RadioGroup droolRadioGroup;
    private RadioButton droolRadioButton;
    private Button showResultButton;
    private int dogCounter;
    private int catCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // call setUp()
        setUp();

        // seekbar
        seekBar = (SeekBar) findViewById(R.id.seekBarFeline);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                seekBarTextView.setText("Comfortableness: " + i + "/" + seekBar.getMax());
                catCounter += i;
                dogCounter = seekBar.getMax() - i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void setUp() {
        dogCounter = 0;
        catCounter = 0;

        canineRadioGroup = (RadioGroup) findViewById(R.id.radioGroupCanine);
        droolRadioGroup = (RadioGroup) findViewById(R.id.radioGroupDrool);
        seekBarTextView = (TextView) findViewById(R.id.seekBarProgressTextView);

        // check boxes
        cutestCheckBoxCat = (CheckBox) findViewById(R.id.checkboxCutestCat);
        cutestCheckBoxDog = (CheckBox) findViewById(R.id.checkboxCutestDog);
        cutestCheckBoxParrot = (CheckBox) findViewById(R.id.checkboxCutestParrot);

        // call methods
        processCutest(cutestCheckBoxDog, cutestCheckBoxCat, cutestCheckBoxParrot);
        processDrool(droolRadioGroup);
        processCanines(canineRadioGroup);

        showResultButton = (Button) findViewById(R.id.showResults);
        showResultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Toast.makeText(getApplicationContext(), catCounter + " " + dogCounter, Toast.LENGTH_LONG).show();

                Intent i = new Intent(MainActivity.this, ResultActivity.class);
                i.putExtra("catCounter", catCounter);
                i.putExtra("dogCounter", dogCounter);
                startActivity(i);
            }
        });
    }

    public void processCutest(CheckBox dog, CheckBox cat, CheckBox parrot) {
        if (dog.isChecked() && !cat.isChecked() && !parrot.isChecked()) {
            dogCounter += 5;
        } else if (cat.isChecked() && !dog.isChecked() && !parrot.isChecked()) {
            catCounter += 5;
        } else {
            // nobody gets points
        }
    }

    public void processDrool(RadioGroup radioGroup) {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int radioId = radioGroup.getCheckedRadioButtonId();

                droolRadioButton = (RadioButton) findViewById(radioId);

                if (droolRadioButton.getText().equals("Yes")) {
                    dogCounter += 5;
                } else {
                    catCounter += 5;
                }
            }
        });
    }

    public void processCanines(RadioGroup radioGroup) {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int radioId = radioGroup.getCheckedRadioButtonId();

                canineRadioButton = (RadioButton) findViewById(radioId);

                if (canineRadioButton.getText().equals("Yes")) {
                    dogCounter += 5;
                } else {
                    catCounter += 5;
                }
            }
        });
    }
}
