package com.example.movieapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class videoPage extends AppCompatActivity {
    MediaController mediaController;
    VideoView videoView;
    Button button;
    public String path;


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.videolayout);
        videoView=findViewById(R.id.videoView);

         Bundle extras = getIntent().getExtras();
        path=extras.getString(MainActivity.path);
        mediaController=new MediaController(this);

        Uri url=Uri.parse(path);
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(url);
        videoView.start();






    }
}