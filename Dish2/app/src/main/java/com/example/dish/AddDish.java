package com.example.dish;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddDish extends AppCompatActivity {

    AppDatabase appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dish);

        Button submit=findViewById(R.id.submitBtnId);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText nameDish=findViewById(R.id.dishNameId);
                EditText priceDish=findViewById(R.id.dishPriceId);
                EditText ingredientDish=findViewById(R.id.dishInGredientsId);
                String name=nameDish.getText().toString();
                int price = Integer.parseInt(priceDish.getText().toString());
                String gredient =ingredientDish.getText().toString();

                Dish dish=new Dish(name,price,gredient);

                appDatabase = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"trando").allowMainThreadQueries().build();

                DishDao dishDao=appDatabase.dishDao();
                dishDao.insertAll(dish);
            }
        });
    }
}