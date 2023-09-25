package com.example.amwell;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class HouseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house);

        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username =  sharedPreferences.getString("username","").toString();
        Toast.makeText(getApplicationContext(), "Welcome"+username, Toast.LENGTH_LONG).show();

        CardView exit = findViewById(R.id.cardExit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor =  sharedPreferences.edit();
                editor.clear();
                editor.apply();
                startActivity(new Intent(HouseActivity.this, MainActivity.class));
            }
        });

        CardView findDoctor = findViewById(R.id.cardFindDocter);
        findDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HouseActivity.this, FindDoctorActivity.class));

            }
        });
        CardView labTest = findViewById(R.id.cardLabTest);
        labTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HouseActivity.this, LabTestActivity.class));
            }
        });
        CardView orderDetails =  findViewById(R.id.cardOrderDetails);
        orderDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HouseActivity.this, OrderDetailsActivity.class));
            }
        });
        CardView BuyMedicine =  findViewById(R.id.cardBuyMedicine);
        BuyMedicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HouseActivity.this, BuyMedicineActivity.class));
            }
        });
        CardView health =  findViewById(R.id.cardHealthDocter);
        health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HouseActivity.this, HealthArticalesDetailesActivity.class));
            }
        });

    }
}