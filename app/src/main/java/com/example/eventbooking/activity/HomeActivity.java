package com.example.eventbooking.activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eventbooking.model.Event;
import com.example.eventbooking.adapter.EventAdapter;
import com.example.eventbooking.R;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private EventAdapter eventAdapter;
    private ArrayList<Event> eventsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getSupportActionBar().setTitle(R.string.str_home_screen);

        recyclerView = findViewById(R.id.recyclerViewEvents);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

       eventListDataSet();

        eventAdapter = new EventAdapter(eventsList, event -> {
            Intent intent = new Intent(HomeActivity.this, EventDetailsActivity.class);
            intent.putExtra("event", event);
            startActivity(intent);
        });

        recyclerView.setAdapter(eventAdapter);
    }

    private void eventListDataSet(){
        eventsList = new ArrayList<>();
        eventsList.add(new Event(getString(R.string.str_event1), getString(R.string.str_event_1_description), R.drawable.calendar));
        eventsList.add(new Event(getString(R.string.str_event2), getString(R.string.str_event_2_description), R.drawable.calendar));
        eventsList.add(new Event(getString(R.string.str_event3), getString(R.string.str_event_3_description), R.drawable.calendar));
        eventsList.add(new Event(getString(R.string.str_event4), getString(R.string.str_event_4_description), R.drawable.calendar));
        eventsList.add(new Event(getString(R.string.str_event5), getString(R.string.str_event_5_description), R.drawable.calendar));
        eventsList.add(new Event(getString(R.string.str_event6), getString(R.string.str_event_6_description), R.drawable.calendar));
    }

}