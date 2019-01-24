package org.pursuit.unit_03_assessment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.pursuit.unit_03_assessment.ViewHolder.MyViewHolder;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private List<Planet> planetList;

    public MyAdapter(List<Planet> planetList) {
        this.planetList = planetList;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context;
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.activity_display, viewGroup, false);
        return new MyViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
MyViewHolder.onBind(planetList.get(position));

    }

    @Override
    public int getItemCount() {
        return planetList.size();
    }
}
