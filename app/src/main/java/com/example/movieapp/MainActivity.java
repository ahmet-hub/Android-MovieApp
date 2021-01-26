package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Layout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.MissingFormatArgumentException;

public class MainActivity extends AppCompatActivity {

    public static String path="path";

    List<movieModel> movieModels;

    String jsonUrl;
    ListView listView;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
        imageView = findViewById(R.id.movieImage);
        movieModels=new ArrayList<movieModel>();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView= findViewById(R.id.listView1);

         jsonUrl="https://raw.githubusercontent.com/HerocypheR/andoridClass/main/filmJSON";
         getJsonData(new CallBack() {
             @Override
             public void finish() {
                 movieAdapter movieAdapter=new movieAdapter(MainActivity.this, movieModels);
                 listView.setAdapter(movieAdapter);

             }
         });


         listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

              Intent intent=new Intent(MainActivity.this,videoPage.class);
              intent.putExtra("path",movieModels.get(position).movieThumb);



              startActivity(intent);

             }
         });
    }




    public interface CallBack{

        void finish();

    }

    public void getJsonData( final CallBack callBack ){
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, jsonUrl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("data");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String movieName = jsonObject.getString("filmAdi");
                        String movieDate = jsonObject.getString("filmYil");
                        String movieThumb = jsonObject.getString("filmThumb");
                        movieModels.add(new movieModel(movieName,movieDate,movieThumb));

                    }
                    callBack.finish();
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

        requestQueue.add(jsonObjectRequest);

    }
}