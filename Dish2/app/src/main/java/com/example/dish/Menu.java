package com.example.dish;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class Menu extends AppCompatActivity {
AppDatabase appDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // Array list for test if recycel working fine or not
//        ArrayList<Dish> items=new ArrayList<Dish>();
//
//        items.add(new Dish("osama",12,"teastey"));
//        items.add(new Dish("ahma",12,"teastey"));
//        items.add(new Dish("alali",12,"teastey"));


        appDatabase = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"trando").allowMainThreadQueries().build();
        List<Dish> listDish=appDatabase.dishDao().getAll();

        RecyclerView recyclerViewItem=findViewById(R.id.dishItemsRecycleView);

        recyclerViewItem.setLayoutManager(new LinearLayoutManager(this));
         // set for adabter
        recyclerViewItem.setAdapter(new DishAdabter(listDish));


        Button home=findViewById(R.id.homeBtnId);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goAddDish=new Intent(Menu.this,MainActivity.class);
                startActivity(goAddDish);
            }
        });

    }
}