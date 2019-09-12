package com.example.crudmahasiswa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class DashboardActivity extends AppCompatActivity {

    ImageView imageViewLihatData;
    ImageView imageViewInputData;
    ImageView imageViewInformasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        imageViewLihatData = findViewById(R.id.imageLihatData);
        imageViewInputData = findViewById(R.id.imageInputData);
        imageViewInformasi = findViewById(R.id.imageInformasi);

        imageViewLihatData.setOnClickListener(new Listener());
        imageViewInputData.setOnClickListener(new Listener());
        imageViewInformasi.setOnClickListener(new Listener());


    }

    class Listener implements View .OnClickListener{
        Intent intent;
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.imageLihatData:
                    intent = new Intent(DashboardActivity.this, ListDataActivity.class);
                    break;
                case R.id.imageInputData:
                    intent = new Intent(DashboardActivity.this, InputDataActivity.class);
                    break;
                case R.id.imageInformasi:
                    intent = new Intent(DashboardActivity.this, ListDataActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}
