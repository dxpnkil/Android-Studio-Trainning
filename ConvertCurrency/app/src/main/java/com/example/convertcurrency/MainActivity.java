package com.example.convertcurrency;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerCategory, spinnerCategoryConvert;
    private CategoryAdapter categoryAdapter;
    private EditText number;
    private TextView result;
    private String s1 = "Convert";
    private String s2 = "Convert";
    private int dec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerCategory = findViewById(R.id.spinner_category);
        spinnerCategoryConvert = findViewById(R.id.spinner_category_convert);
        categoryAdapter = new CategoryAdapter(this, R.layout.item_selected, getListCategory());
        number = findViewById(R.id.number1);
        result = findViewById(R.id.number2);

        spinnerCategory.setAdapter(categoryAdapter);
        spinnerCategoryConvert.setAdapter(categoryAdapter);
        spinnerCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                s1 = categoryAdapter.getItem(i).getName();

                if (s1.equals("USD")) {
                    dec =  Integer.parseInt(number.getText().toString()) * 23159;
                } else if (s1.equals("EURO")) {
                    dec =  Integer.parseInt(number.getText().toString()) * 24180;
                } else if (s1.equals("VND")) {
                    dec =  Integer.parseInt(number.getText().toString());
                }

                if(s2.equals("USD")) {
                    result.setText(Integer.toString (dec / 23159));
                } else if (s2.equals("EURO")) {
                    result.setText(Integer.toString (dec / 24180));
                } else if (s2.equals("VND")) {
                    result.setText(Integer.toString(dec));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinnerCategoryConvert.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (s1.equals("USD")) {
                    dec =  Integer.parseInt(number.getText().toString()) * 23159;
                } else if (s1.equals("EURO")) {
                    dec =  Integer.parseInt(number.getText().toString()) * 24180;
                } else if (s1.equals("VND")) {
                    dec =  Integer.parseInt(number.getText().toString());
                }

                s2 = categoryAdapter.getItem(i).getName();

                if(s2.equals("USD")) {
                    result.setText(Integer.toString (dec / 23159));
                } else if (s2.equals("EURO")) {
                    result.setText(Integer.toString (dec / 24180));
                } else if (s2.equals("VND")) {
                    result.setText(Integer.toString(dec));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private List<Category> getListCategory() {
        List<Category> list = new ArrayList<>();
        list.add(new Category("Convert"));
        list.add(new Category("USD"));
        list.add(new Category("EURO"));
        list.add(new Category("VND"));
        list.add(new Category("GBP"));

        return list;
    }
}