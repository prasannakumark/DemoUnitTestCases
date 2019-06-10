package com.borqs.demounittest.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.borqs.demounittest.R;

import java.util.List;

public class RecyclerViewTestAdapter extends RecyclerView.Adapter<RecyclerViewTestAdapter.MyViewHolder>{

    private List<String> moviesList;

    public RecyclerViewTestAdapter(List<String> moviesList) {
        this.moviesList = moviesList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.textView);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_view, viewGroup, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.title.setText(moviesList.get(i));
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}
