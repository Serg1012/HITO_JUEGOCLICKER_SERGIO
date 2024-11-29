package com.example.hito_juegoclicker_sergio;

import android.content.Context;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class DataManager {

    private static final String FILENAME = "scores.json";

    // Cargar puntuaciones desde JSON
    public static List<String> getScores(Context context) {
        List<String> scores = new ArrayList<>();
        try {
            InputStream is = context.openFileInput(FILENAME);
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            is.close();

            String json = new String(buffer, StandardCharsets.UTF_8);
            JSONObject obj = new JSONObject(json);
            JSONArray scoresArray = obj.getJSONArray("scores");
            for (int i = 0; i < scoresArray.length(); i++) {
                JSONObject scoreObj = scoresArray.getJSONObject(i);
                scores.add(scoreObj.getString("username") + ": " + scoreObj.getInt("score"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scores;
    }

    // Guardar puntuación en JSON
    public static void saveScore(Context context, String username, int score) {
        try {
            JSONObject obj = new JSONObject();
            JSONArray scoresArray;

            // Leer archivo existente o crear nuevo
            try {
                InputStream is = context.openFileInput(FILENAME);
                byte[] buffer = new byte[is.available()];
                is.read(buffer);
                is.close();

                String json = new String(buffer, StandardCharsets.UTF_8);
                obj = new JSONObject(json);
                scoresArray = obj.getJSONArray("scores");
            } catch (Exception e) {
                scoresArray = new JSONArray();
            }

            // Agregar nueva puntuación
            JSONObject newScore = new JSONObject();
            newScore.put("username", username);
            newScore.put("score", score);
            scoresArray.put(newScore);

            obj.put("scores", scoresArray);

            // Guardar archivo
            FileOutputStream fos = context.openFileOutput(FILENAME, Context.MODE_PRIVATE);
            fos.write(obj.toString().getBytes(StandardCharsets.UTF_8));
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
