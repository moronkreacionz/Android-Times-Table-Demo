package com.moronkreacionz.timestable20170315;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // setting up the seekbar
        final SeekBar timesTableSeekBar= (SeekBar) findViewById(R.id.timesTableSeekBar);

        timesTableSeekBar.setMax(20);
        int initialTimesTableValue = 10;
        timesTableSeekBar.setProgress(initialTimesTableValue);

        timesTableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                int min = 1 ;
                int timesTable ;
                if (progress < min ) {
                    timesTable = min;
                    timesTableSeekBar.setProgress(timesTable);
                }else{
                    timesTable = progress;
                }
                Log.i("seekbar progress",Integer.toString(timesTable));
                generateTimesTable(timesTable);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        generateTimesTable(initialTimesTableValue);

    }

    public void generateTimesTable(int input){

        ArrayList<String> timesTableContent = new ArrayList<String>();
        for (int i = 1 ; i <= 20 ; i++ )
        {
            timesTableContent.add(Integer.toString(input) + " * " + Integer.toString(i)+ " = "+ Integer.toString(input * i));
        }

        ArrayAdapter<String> arrayAdapterTimeTableContent = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                timesTableContent);

        // setting up the listview for content
        ListView timesTableListView = (ListView) findViewById(R.id.timesTableListView);
        timesTableListView.setAdapter(arrayAdapterTimeTableContent);

    }
}
