package com.example.eventbooking.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.eventbooking.model.Event;
import com.example.eventbooking.R;
import com.squareup.picasso.Picasso;


public class EventDetailsActivity extends AppCompatActivity {

    private TextView eventTitleDetail, eventDescriptionDetail;
    private Button bookNowButton;
    private ImageView eventDetailImage;
    private Event event;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.str_event_details_screen);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        eventTitleDetail = findViewById(R.id.eventTitleDetail);
        eventDescriptionDetail = findViewById(R.id.eventDescriptionDetail);
        bookNowButton = findViewById(R.id.bookNowButton);
        eventDetailImage = findViewById(R.id.eventDetailImage);

        event = (Event) getIntent().getSerializableExtra("event");

        assert event != null;
        eventTitleDetail.setText(event.getTitle());
        eventDescriptionDetail.setText(event.getDescription());

        // Assuming you're using Picasso for image loading
        Picasso.get().load(event.getImageResId()).into(eventDetailImage);

        bookNowButton.setOnClickListener(v -> {
            Intent intent = new Intent(EventDetailsActivity.this, BookingActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }
}