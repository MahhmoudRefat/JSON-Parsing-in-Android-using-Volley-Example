package com.example.webservice_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonParsing extends AppCompatActivity {


    TextView mTextViewparse;
    RequestQueue mRequestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_parsing);

        mTextViewparse=findViewById(R.id.tv_parse);
        Button button = findViewById(R.id.btn_parse);

        mRequestQueue = Volley.newRequestQueue(JsonParsing.this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jsonparse();
            }
        });
    }

    private void jsonparse(){
        String url ="https://api.myjson.com/bins/kp9wz";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONArray jsonArray = response.getJSONArray("employees");
                            for(int i = 0 ;i< jsonArray.length();i++)
                            {
                                JSONObject employee = jsonArray.getJSONObject(i);

                                String firstname = employee.getString("firstname");
                                int age = employee.getInt("age");
                                String mail = employee.getString("mail");

                                mTextViewparse.append(firstname + ","+ String.valueOf(age) + ","+ mail+"\n\n");

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
            mRequestQueue.add(request);

    }
}
