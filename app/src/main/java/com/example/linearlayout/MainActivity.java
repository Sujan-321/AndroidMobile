package com.example.linearlayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.example.linearlayout.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.relative_layout);//activity_main
//        setContentView(R.layout.activity_main);//activity_main

        //for planets
        Spinner spinner = (Spinner) findViewById(R.id.planets);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.planets_array,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        //for days
        Spinner spi = (Spinner) findViewById(R.id.days);

        ArrayAdapter<CharSequence> adp = ArrayAdapter.createFromResource(
                this,
                R.array.weekday,
                android.R.layout.simple_spinner_item
        );
        adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spi.setAdapter(adp);

    }
}