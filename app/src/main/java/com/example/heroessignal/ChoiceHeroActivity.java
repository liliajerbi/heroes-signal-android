package com.example.heroessignal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.heroessignal.Model.Hero;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ChoiceHeroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_hero);

        final List<Hero> heroRv = new ArrayList<>();
        RequestQueue requestQueue = Volley.newRequestQueue(ChoiceHeroActivity.this);
        String url = "https://akabab.github.io/superhero-api/api/all.json";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject detailsDep = response.getJSONObject(i);
                                String name = detailsDep.getString("nom");
                                String code = detailsDep.getString("code");
                                Department department = new Department(name, code);
                                departments.add(department);
                            }
                            final RecyclerView rvListDepartments = findViewById(R.id.rvListDepartments);
                            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(UserDetailsActivity.this, LinearLayoutManager.VERTICAL, false);
                            rvListDepartments.setLayoutManager(layoutManager);
                            final ListDepartmentAdapter adapter = new ListDepartmentAdapter(departments);
                            rvListDepartments.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Afficher l'erreur
                        Log.d("VOLLEY_ERROR", "onErrorResponse: " + error.getMessage());
                    }
                }
        );
        requestQueue.add(jsonArrayRequest);
    }
}
