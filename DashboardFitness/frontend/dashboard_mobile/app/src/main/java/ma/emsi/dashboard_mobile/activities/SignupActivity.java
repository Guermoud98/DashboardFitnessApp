package ma.emsi.dashboard_mobile.activities;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import ma.emsi.dashboard_mobile.MainActivity;
import ma.emsi.dashboard_mobile.R;

public class SignupActivity extends AppCompatActivity {
    private EditText etSignupNom, etSignupPrenom, etSignupEmail, etSignupPassword, etSignupPoids, etSignupTaille;
    private Button btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etSignupNom = findViewById(R.id.etSignupNom);
        etSignupPrenom = findViewById(R.id.etSignupPrenom);
        etSignupEmail = findViewById(R.id.etSignupEmail);
        etSignupPassword = findViewById(R.id.etSignupPassword);
        etSignupPoids = findViewById(R.id.etSignupPoids);
        etSignupTaille = findViewById(R.id.etSignupTaille);
        btnSignup = findViewById(R.id.btnSignup);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signupUser();
            }
        });
    }

    private void signupUser() {
        String nom = etSignupNom.getText().toString().trim();
        String prenom = etSignupPrenom.getText().toString().trim();
        String email = etSignupEmail.getText().toString().trim();
        String password = etSignupPassword.getText().toString().trim();
        String poids = etSignupPoids.getText().toString().trim();
        String taille = etSignupTaille.getText().toString().trim();

        if (nom.isEmpty() || prenom.isEmpty() || email.isEmpty() || password.isEmpty() || poids.isEmpty() || taille.isEmpty()) {
            Toast.makeText(SignupActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        String url = "http://localhost:8085/api/Utilisateurs/create";

        JSONObject userJson = new JSONObject();
        try {
            userJson.put("nom", nom);
            userJson.put("prenom", prenom);
            userJson.put("email", email);
            userJson.put("password", password);
            userJson.put("poids", Double.parseDouble(poids));
            userJson.put("taille", Double.parseDouble(taille));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RequestQueue queue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, userJson,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            // Handle successful response
                            if (response.getString("status").equals("SUCCESS")) {
                                Toast.makeText(SignupActivity.this, "Signup Successful", Toast.LENGTH_SHORT).show();
                                // Navigate to login activity
                                Intent intent = new Intent(SignupActivity.this, MainActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(SignupActivity.this, "Signup Failed", Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(SignupActivity.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Handle error
                Toast.makeText(SignupActivity.this, "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        queue.add(jsonObjectRequest);
    }
}
