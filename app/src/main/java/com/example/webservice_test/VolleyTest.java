package com.example.webservice_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Map;

public class VolleyTest extends AppCompatActivity {
    TextView tv_loaddatavolly;
   /* json_model[] Json_model_array;
    ListView listView;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley_test);
        tv_loaddatavolly = findViewById(R.id.content_tv);

        /*listView=findViewById(R.id.json_container);
       Gson gson = new Gson();
        Json_model_array = gson.fromJson(Json_model_array.toString(),json_model[].class);

        ArrayList<String> taskdata = new ArrayList<>();
        for (json_model json_model : Json_model_array){
            taskdata.add(json_model.getTitle());

        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(VolleyTest.this,android.R.layout.simple_list_item_1,taskdata);
            listView.setAdapter(adapter);*/
    }

    public void LoadData(View view) {
        String Link = "https://jsonplaceholder.typicode.com/posts";
        StringRequest request = new StringRequest(Link, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
            tv_loaddatavolly.setText(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Volley Error",error.getLocalizedMessage());
            }
        });

        Volley.newRequestQueue(this).add(request);

    }
}
