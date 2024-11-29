package com.example.hito_juegoclicker_sergio;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class ContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        Button btnBackToMenu = findViewById(R.id.btn_back_to_menu);  // Botón para volver al menú principal

        // Volver al menú principal
        btnBackToMenu.setOnClickListener(v -> {
            Intent intent = new Intent(ContactActivity.this, MainActivity.class);
            startActivity(intent);
            finish();  // Finaliza la actividad actual
        });
    }
}


