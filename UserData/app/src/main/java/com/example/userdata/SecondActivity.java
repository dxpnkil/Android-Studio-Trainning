package com.example.userdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

public class SecondActivity extends AppCompatActivity {
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            String studentId = bundle.getString("studentId");
            String fullName = bundle.getString("fullName");
            String id = bundle.getString("id");
            String phone = bundle.getString("phone");
            String email = bundle.getString("email");
            String town = bundle.getString("town");
            String place = bundle.getString("place");
            String major = bundle.getString("major");
            String date = bundle.getString("date");
            List<String> languages = bundle.getStringArrayList("languages");
            Log.d("ABC", languages.toString());
            text = findViewById(R.id.text);
            text.setText("studentId: "+ studentId + "\n"
                    + " fullName: " + fullName + "/\n"
                    + " id: " + id + "\n"
                    + " phone: " + phone + "\n"
                    + " email: " + email + "\n"
                    + " town: " + town + "\n"
                    + " place: " + place + "\n"
                    + " major: " + major + "\n"
                    + " date: " + date);
        }
    }
}
