package com.borqs.demounittest.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.borqs.demounittest.R;
import com.borqs.demounittest.view.adapter.RecyclerViewTestAdapter;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);

        List<String> movieList = new ArrayList<>();

        for(int i = 0; i< 300; i++) {
            movieList.add("MovieName " + i);
        }
        recyclerView.setAdapter(new RecyclerViewTestAdapter(movieList));
    }
}
