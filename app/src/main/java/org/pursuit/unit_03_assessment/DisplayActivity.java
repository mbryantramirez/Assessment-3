package org.pursuit.unit_03_assessment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.pursuit.unit_03_assessment.R;

public class DisplayActivity extends AppCompatActivity {
    private TextView nameTextView;
    private TextView numberTextView;
    private TextView imageTextView;

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

    }
