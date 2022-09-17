package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ListView cityList;
    ArrayAdapter<String> cityAdapter;
    ArrayList<String> dataList;
    EditText addCityText;
    Button addCityButton;
    Button confirmCityButton;

    @Override
    public void onClick(View view) {
        if (view.getId() == addCityButton.getId()){
            addCityText.setVisibility(addCityText.VISIBLE);
            confirmCityButton.setVisibility(confirmCityButton.VISIBLE);
        }

        if (view.getId() == confirmCityButton.getId()) {
            String city = addCityText.getText().toString();
            dataList.add(city);
            cityAdapter.notifyDataSetChanged();
            addCityText.setVisibility(addCityText.GONE);
            confirmCityButton.setVisibility(confirmCityButton.GONE);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityList = findViewById(R.id.cityList);

        String []cities = {"Edmonton", "Toronto", "Vancouver"};

        dataList = new ArrayList<>();
        dataList.addAll(Arrays.asList(cities));

        cityAdapter = new ArrayAdapter<>(this, R.layout.content, dataList);

        cityList.setAdapter(cityAdapter);

        addCityButton = findViewById(R.id.addCityButton);

        addCityText = findViewById(R.id.addCityText);
        addCityText.setVisibility(addCityText.GONE);

        confirmCityButton = findViewById(R.id.confirmCityButton);
        confirmCityButton.setVisibility(confirmCityButton.GONE);

        addCityButton.setOnClickListener(this);
        confirmCityButton.setOnClickListener(this);

        //listview.onItemClickListen
        //button.setItemOnListener
    }
}