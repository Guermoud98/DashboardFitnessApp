package ma.emsi.dashboard_mobile.activities;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import ma.emsi.dashboard_mobile.R;

public class DashboardActivity  extends AppCompatActivity {

    private TextView  tvWorkouts, tvNutritions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        tvWorkouts = findViewById(R.id.tvWorkouts);
        tvNutritions = findViewById(R.id.tvNutritions);

        // Assuming the email and password are passed from the login activity
        String email = getIntent().getStringExtra("email");
        String password = getIntent().getStringExtra("password");


        loadSuggestedWorkouts(email, password);
        loadNutritions();
    }



    private void loadSuggestedWorkouts(String email, String password) {
        String url = "http://localhost:8085/api/Utilisateurs/GetSuggestedEntrainement?email=" + email + "&password=" + password;

        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            StringBuilder workouts = new StringBuilder();
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject workout = response.getJSONObject(i);
                                workouts.append(workout.getString("nom")).append("\n");
                            }
                            tvWorkouts.setText(workouts.toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Handle error
            }
        });

        queue.add(jsonArrayRequest);
    }

    private void loadNutritions() {
        String url = "http://localhost:8085/api/Utilisateurs/nutritions/afficherTous";

        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            StringBuilder nutritions = new StringBuilder();
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject nutrition = response.getJSONObject(i);
                                nutritions.append(nutrition.getString("nomNutrition")).append("\n");
                            }
                            tvNutritions.setText(nutritions.toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Handle error
            }
        });

        queue.add(jsonArrayRequest);
    }
}
