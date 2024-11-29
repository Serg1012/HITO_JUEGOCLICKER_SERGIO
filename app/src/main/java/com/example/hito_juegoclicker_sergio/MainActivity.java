package com.example.hito_juegoclicker_sergio;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referencia del campo de texto para el nombre de usuario
        EditText etUsername = findViewById(R.id.et_username);

        // Configuración del botón "Start"
        findViewById(R.id.btn_start).setOnClickListener(view -> {
            String username = etUsername.getText().toString().trim();
            if (username.isEmpty()) {
                etUsername.setError("Username cannot be empty!");
                Toast.makeText(this, "Enter a valid username", Toast.LENGTH_SHORT).show();
            } else {
                // Mensaje de bienvenida al usuario
                Toast.makeText(this, "Welcome, " + username + "!", Toast.LENGTH_SHORT).show();
            }
        });

        // Configuración del botón "Play" para abrir GameActivity
        findViewById(R.id.btn_play).setOnClickListener(view -> {
            String username = etUsername.getText().toString().trim();
            if (!username.isEmpty()) {
                Intent intent = new Intent(this, GameActivity.class);
                intent.putExtra("username", username);  // Pasar el nombre de usuario
                startActivity(intent);
            } else {
                Toast.makeText(this, "Please enter a username", Toast.LENGTH_SHORT).show();
            }
        });

        // Configuración del botón "Scores" para abrir ScoresActivity
        findViewById(R.id.btn_scores).setOnClickListener(view -> {
            startActivity(new Intent(this, ScoresActivity.class));
        });

        // Configuración del botón "Contact" para abrir ContactActivity
        findViewById(R.id.btn_contact).setOnClickListener(view -> {
            startActivity(new Intent(this, ContactActivity.class));
        });
    }
}
