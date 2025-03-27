package com.example.eventbooking.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.eventbooking.R;

public class BookingActivity extends AppCompatActivity {

    private EditText editTextName, editTextEmail, editTextPhone;
    private Button submitBookingButton;
    String emailRegex = "[a-zA-Z0-9._-]+@[a-z]+\\.[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.str_booking_screen);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPhone = findViewById(R.id.editTextPhone);
        submitBookingButton = findViewById(R.id.submitBookingButton);

        submitBookingButton.setOnClickListener(v -> {
           if(validation()){
               String name = editTextName.getText().toString();
               String email = editTextEmail.getText().toString();
               String phone = editTextPhone.getText().toString();

               // Logic for submitting booking (e.g., saving to a database or API call)

               Toast.makeText(BookingActivity.this, getString(R.string.str_booking_confirmation_message) + name, Toast.LENGTH_SHORT).show();
               Intent intent = new Intent(BookingActivity.this, HomeActivity.class);
               intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
               startActivity(intent);
               finish();
           }
        });
    }

    private boolean validation(){
        if(!editTextName.getText().toString().isEmpty()){
            if(!editTextEmail.getText().toString().isEmpty() &&  Patterns.EMAIL_ADDRESS.matcher(editTextEmail.getText().toString()).matches()){
                if(!editTextPhone.getText().toString().isEmpty() && android.util.Patterns.PHONE.matcher(editTextPhone.getText().toString()).matches()){
                    return true;
                }else {
                    Toast.makeText(BookingActivity.this, getString(R.string.str_validation_phone_message), Toast.LENGTH_SHORT).show();
                    return false;
                }
            }else {
                Toast.makeText(BookingActivity.this, getString(R.string.str_validation_email_message), Toast.LENGTH_SHORT).show();
                return false;
            }
        }else {
            Toast.makeText(BookingActivity.this, getString(R.string.str_validation_name_message), Toast.LENGTH_SHORT).show();
            return false;
        }
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