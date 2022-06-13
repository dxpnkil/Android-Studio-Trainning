package com.example.mail_app_ui;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Item> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        items = new ArrayList<>();
        items.add(new Item("Alex McGonagal", "The new iconic creator heare !", "Announcing the all-new creator, builder in..."));
        items.add(new Item("Alex McGonagal", "The new iconic creator heare !", "Announcing the all-new creator, builder in..."));
        items.add(new Item("Alex McGonagal", "The new iconic creator heare !", "Announcing the all-new creator, builder in..."));
        items.add(new Item("Alex McGonagal", "The new iconic creator heare !", "Announcing the all-new creator, builder in..."));
        items.add(new Item("Alex McGonagal", "The new iconic creator heare !", "Announcing the all-new creator, builder in..."));
        items.add(new Item("Alex McGonagal", "The new iconic creator heare !", "Announcing the all-new creator, builder in..."));
        items.add(new Item("Alex McGonagal", "The new iconic creator heare !", "Announcing the all-new creator, builder in..."));
        items.add(new Item("Alex McGonagal", "The new iconic creator heare !", "Announcing the all-new creator, builder in..."));
        items.add(new Item("Alex McGonagal", "The new iconic creator heare !", "Announcing the all-new creator, builder in..."));
        items.add(new Item("Alex McGonagal", "The new iconic creator heare !", "Announcing the all-new creator, builder in..."));
        items.add(new Item("Alex McGonagal", "The new iconic creator heare !", "Announcing the all-new creator, builder in..."));
        items.add(new Item("Alex McGonagal", "The new iconic creator heare !", "Announcing the all-new creator, builder in..."));
        items.add(new Item("Alex McGonagal", "The new iconic creator heare !", "Announcing the all-new creator, builder in..."));
        items.add(new Item("Alex McGonagal", "The new iconic creator heare !", "Announcing the all-new creator, builder in..."));
        items.add(new Item("Alex McGonagal", "The new iconic creator heare !", "Announcing the all-new creator, builder in..."));
        items.add(new Item("Alex McGonagal", "The new iconic creator heare !", "Announcing the all-new creator, builder in..."));

        ItemAdapter adapter = new ItemAdapter(items);

        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }
}