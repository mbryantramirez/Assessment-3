package org.pursuit.unit_03_assessment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import org.pursuit.unit_03_assessment.Model.ArrayList_Planets;
import org.pursuit.unit_03_assessment.Network.Service_Planet;
import org.pursuit.unit_03_assessment.R;
import org.pursuit.unit_03_assessment.Singleton.Singleton_Retrofit;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DisplayActivity extends AppCompatActivity {
    private TextView nameTextView;
    private TextView numberTextView;
    private TextView imageTextView;
    RecyclerView recyclerView;
    MyAdapter adapter;
    private List<Planet> planets = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        Intent intent = getIntent();
        intent.getAction(LoginActivity.class, this);

        nameTextView = findViewById(R.id.textview_name_display);
        numberTextView = findViewById(R.id.textview_number_display);
        imageTextView = findViewById(R.id.textview_itemview_display);


        nameTextView.setText(getIntent().getStringExtra("name"));
        numberTextView.setText(getIntent().getStringExtra("number"));
        imageTextView.setText(getIntent().getStringExtra("image"));


//        * TODO 2. Create a TextView instance for the Planet Name
//        * TODO 3. Create a TextView instance for the Planet Number count
//        * TODO 4. Create an ImageView for the image url
//        * TODO 5. Display each value in views - Strings for TextViews, and Picasso for the ImageView
//        */

//retrofit instance
        Retrofit retrofit = Singleton_Retrofit.retrofitInstance();
//.enqueue makes the retrofit run on the back thread
        retrofit.create(Service_Planet.class)
                .getPlanet()
                .enqueue(new Callback<ArrayList_Planets>() {
                    @Override
                    public void onResponse(Call<ArrayList_Planets> call, Response<ArrayList_Planets> response) {
                        Log.d("TAG", "onResponse: " + response.body()
                                .getPlanets()
                                .get(0)// first object of the Json arraylist
                                .getName()); // the name element of the Json object
                        for (int i = 0; i < response.body().getPlanets().size(); i++) {
                            planets.add(response.body().getPlanets().get(i));
                        }
                        Log.d("TAG", "size: " + planets.size());

                        recyclerView.setAdapter(adapter);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    }


                    @Override
                    public void onFailure(Call<ArrayList_Planets> call, Throwable t) {
                        Log.d("TAG", "onResponse: " + t.toString());
                    }
                });

    }
}
