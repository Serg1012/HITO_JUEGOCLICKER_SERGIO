package com.example.hito_juegoclicker_sergio;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

public class ScoresActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);

        TextView scoresView = findViewById(R.id.tv_scores);
        List<String> scores = DataManager.getScores(this);

        StringBuilder sb = new StringBuilder();
        for (String score : scores) {
            sb.append(score).append("\n");
        }

        scoresView.setText(sb.toString());

        Button btnBackToMenu = findViewById(R.id.btn_back_to_menu);  // Botón para volver al menú principal

        // Volver al menú principal
        btnBackToMenu.setOnClickListener(v -> {
            Intent intent = new Intent(ScoresActivity.this, MainActivity.class);
            startActivity(intent);
            finish();  // Finaliza la actividad actual
        });
    }
}
