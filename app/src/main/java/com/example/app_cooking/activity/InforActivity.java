package com.example.app_cooking.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import android.widget.Toast;
import android.widget.VideoView;
import android.app.ProgressDialog;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;

import com.example.app_cooking.R;
import com.example.app_cooking.Service.API_Retrofit;

public class InforActivity extends AppCompatActivity {
    public static  String key_link="link";
    public  static String key_moTa="moTa";
    public  static String key_ten="ten";


    private  VideoView txtvideo;
    private TextView txtMoTa,txtTen;
    private Button btn_like,btn_dislike;
    private Button btn_share;
    private MediaController mediaController;
//    private Toolbar toolbar;

    private  String Key_domain ="https://app-music2.000webhostapp.com/";

    @SuppressLint("RestrictedApi")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infor);

//////        Bat su kien cho nut back
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//                txtvideo.stopPlayback();
//            }
//        });

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        anhxa();
        Intent i = this.getIntent();
        String moTa = i.getStringExtra(key_moTa);
        final String ten = i.getStringExtra(key_ten);
        String link = i.getStringExtra(key_link);
        txtTen.setText(ten);
        txtMoTa.setText("Review :  \n \n "+moTa);

       // Uri video = Uri.parse("http://192.168.56.1:8080/BTL_Android/link/N%E1%BA%A5u%20%C4%83n%20kh%C3%B4ng%20kh%C3%B3%20%C4%91%C3%A3%20c%C3%B3%20Feedy-%20Feedy%20VN.mp4");
        Uri video = Uri.parse(Key_domain+link);
        txtvideo.setVideoURI(video);
        txtvideo.requestFocus();
        txtvideo.start();

        if (mediaController == null) {
            mediaController = new MediaController(this);

            // Neo vị trí của MediaController với VideoView.
            mediaController.setAnchorView(txtvideo);


            // Sét đặt bộ điều khiển cho VideoView.
            txtvideo.setMediaController(mediaController);
        }

        try {
            // ID của file video.
            txtvideo.setVideoURI(video);
            Log.e("Co video","Co video ma");

        } catch (Exception e) {
            Log.e("Error khong co video", e.getMessage());
            e.printStackTrace();
        }
        txtvideo.requestFocus();


//        bắt sự kiện cho các button
        btn_like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(InforActivity.this, ten, Toast.LENGTH_SHORT).show();

               // API_Retrofit.Data_Service data_service = API_Retrofit.getRetrofit();
            }
        });



        btn_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });


    }

    private void anhxa() {
        //toolbar = findViewById(R.id.mytoolbar);
        txtvideo = (VideoView)findViewById(R.id.videoView);
        txtTen = (TextView)findViewById(R.id.tv_txtTen);
        txtMoTa = (TextView)findViewById(R.id.tv_txtMota);
        btn_like =(Button)findViewById(R.id.btn_like);
        btn_dislike=(Button)findViewById(R.id.dislike);
        btn_share=(Button) findViewById(R.id.btn_share);
    }
}
