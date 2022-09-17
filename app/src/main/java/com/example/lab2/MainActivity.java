package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
    Button deleteCityButton;

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

        if (view.getId() == cityList.getId()) {
            String city = String.valueOf(cityList.getSelectedItem());
            dataList.add(city);
            cityAdapter.notifyDataSetChanged();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String []cities = {"Edmonton", "Toronto", "Vancouver"};
        cityList = findViewById(R.id.cityList);
        dataList = new ArrayList<>();
        dataList.addAll(Arrays.asList(cities));
        cityAdapter = new ArrayAdapter<>(this, R.layout.content, dataList);
        cityList.setAdapter(cityAdapter);

        addCityButton = findViewById(R.id.addCityButton);
        deleteCityButton = findViewById(R.id.deleteCityButton);

        addCityText = findViewById(R.id.addCityText);
        addCityText.setVisibility(addCityText.GONE);

        confirmCityButton = findViewById(R.id.confirmCityButton);
        confirmCityButton.setVisibility(confirmCityButton.GONE);

        addCityButton.setOnClickListener(this);
        confirmCityButton.setOnClickListener(this);

        cityList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);
                deleteCityButton.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v) {
                        dataList.remove(selectedItem);
                        cityAdapter.notifyDataSetChanged();
                    }
                });
            }
        });

        //listview.onItemClickListen
        //button.setItemOnListener
    }
}