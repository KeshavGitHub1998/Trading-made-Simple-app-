package com.example.shubh.dummy;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;

import java.util.ArrayList;
import java.util.List;

public class selling extends AppCompatActivity {

    //a list to store all the products
   public List<Product> productList;

    //the recyclerview
   public RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selling);
        //getting the recyclerview from xml
        recyclerView = (RecyclerView) findViewById(R.id.rview);
        //  recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //recyclerView.setOnClickListener();

        //initializing the productlist
        productList = new ArrayList<>();

        int i = 0;


        //adding some items to our list
      /*  productList.add(
                new Product(
                        ++i,
                        "a",
                        "assa",
                        4.3,
                        i,
                        R.drawable.common_google_signin_btn_icon_dark)


        );

        productList.add(
                new Product(
                        ++i,
                        "fss",
                        "1as",
                        1.3,
                        60000,
                        R.drawable.common_google_signin_btn_icon_dark_focused));

        productList.add(
                new Product(
                        ++i,
                        "Mi)",
                        "kg",
                        "4.3",
                        "60",
                        R.drawable.common_full_open_on_phone));

        //creating recyclerview adapter
        ProductAdapter adapter = new ProductAdapter(this, productList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);

        //recyclerView.addOnItem
    }*/


    }
}
