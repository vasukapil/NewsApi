package com.example.user.newsapi;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by user on 10-May-18.
 */

public class CategoryActivity extends AppCompatActivity {

    ListView lv;
    Context context;

    public static int[] categoryImages = {R.drawable.busine, R.drawable.tech, R.drawable.entertain, R.drawable.game, R.drawable.general, R.drawable.music, R.drawable.anim, R.drawable.sport};
    public static String[] categoryNames = {"Business", "Technology", "Entertainment", "Gaming", "General", "Music", "Science-and-nature", "Sport"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        context = this;

        lv = (ListView) findViewById(R.id.categoryList);


        lv.setAdapter(new CategoryAdaper(this, categoryNames, categoryImages));

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(CategoryActivity.this, GridViewActivity.class);

                intent.putExtra("category", categoryNames[i]);


                //Start details activity
                startActivity(intent);
            }
        });


    }
}

