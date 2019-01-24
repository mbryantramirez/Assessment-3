package org.pursuit.unit_03_assessment.ViewHolder;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.pursuit.unit_03_assessment.DisplayActivity;
import org.pursuit.unit_03_assessment.MyAdapter;
import org.pursuit.unit_03_assessment.Planet;

public class MyViewHolder extends RecyclerView.ViewHolder {
    private TextView planetNameTextView;
    private TextView planetNumberTextView;
    private TextView planetImageTextView;
    private RecyclerView recyclerView;

    private MyAdapter adapter;


    public MyViewHolder(@NonNull View itemView, MyAdapter adapter) {
        super(itemView);
        this.planetNameTextView = (TextView) itemView.findViewById(R.id.textview_name_display;
        this.planetNumberTextView = (TextView) itemView.findViewById(R.id.textview_number_display);
        this.planetImageTextView = (TextView) itemView.findViewById(R.id.textview_itemview_display);
        this.recyclerView = itemView.findViewById(R.id.myrecyclerview_layout)
        this.adapter = adapter;
    }


    public  void onBind(final Planet planet) {

        planetNameTextView.setText(planet.getName());
        planetNumberTextView.setText(planet.getNumber());
        planetImageTextView.setText(planet.getImage());
        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(v.getContext(), DisplayActivity.class);
                intent.putExtra("name", planet.getName());
                intent.putExtra("number", planet.getNumber());
                intent.putExtra("image", planet.getImage());
                v.getContext().startActivity(intent);
            }
        });
    }
}
