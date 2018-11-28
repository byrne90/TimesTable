package com.example.byras.timestable;

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

        final ListView listView = findViewById(R.id.multiplyList);
        SeekBar mysSeekBar = findViewById(R.id.multiplySeekBar);

        final ArrayList<Integer> multiplyArray = new ArrayList<Integer>();

        for (int i = 1; i <= 10; i++) {
            multiplyArray.add(i);
        }

        final ArrayAdapter<Integer> myAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, multiplyArray);
        listView.setAdapter(myAdapter);

        mysSeekBar.setMax(20);
        mysSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("ProgressSeek", Integer.toString(progress));
                for (int i = 0; i < multiplyArray.size(); i++) {
                    multiplyArray.set(i, i + 1);
                    multiplyArray.set(i, multiplyArray.get(i) * progress);
                }
                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
