package com.example.hito_juegoclicker_sergio;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {

    private int tapCount = 0;
    private TextView tvTapCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        tvTapCount = findViewById(R.id.tv_tap_count);
        Button btnTap = findViewById(R.id.btn_tap);
        Button btnSaveScore = findViewById(R.id.btn_save_score);
        Button btnBackToMenu = findViewById(R.id.btn_back_to_menu);  // Botón para volver al menú principal

        // Incrementar taps
        btnTap.setOnClickListener(v -> {
            tapCount++;
            tvTapCount.setText("Taps: " + tapCount);
        });

        // Guardar puntuación al finalizar
        btnSaveScore.setOnClickListener(v -> {
            String username = getIntent().getStringExtra("username");
            if (username != null && !username.isEmpty()) {
                new Thread(() -> {
                    DataManager.saveScore(this, username, tapCount);
                    runOnUiThread(() -> Toast.makeText(this, "Score saved!", Toast.LENGTH_SHORT).show());
                }).start();
            } else {
                Toast.makeText(this, "Username not found!", Toast.LENGTH_SHORT).show();
            }
        });

        // Volver al menú principal
        btnBackToMenu.setOnClickListener(v -> {
            Intent intent = new Intent(GameActivity.this, MainActivity.class);
            startActivity(intent);
            finish();  // Finaliza la actividad actual
        });
    }
}
