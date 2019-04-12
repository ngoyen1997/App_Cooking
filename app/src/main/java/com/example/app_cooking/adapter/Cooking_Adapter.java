package com.example.app_cooking.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.app_cooking.R;
import com.example.app_cooking.activity.Cooking;
import com.example.app_cooking.activity.InforActivity;
import com.squareup.picasso.Picasso;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Cooking_Adapter extends RecyclerView.Adapter<Cooking_Adapter.ViewAdapter> {
    private Context ct;
    private LayoutInflater layoutInflater;
    private List<Cooking> ArrCook = new ArrayList<>();

    private  String Key_anh ="https://app-music.000webhostapp.com/";

    public Cooking_Adapter(Context ct, List<Cooking> arrCook) {
        this.ct = ct;
        this.layoutInflater = LayoutInflater.from(ct);
        ArrCook = arrCook;
    }

    @NonNull
    @Override
    public ViewAdapter onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = layoutInflater.inflate(R.layout.list_eat, viewGroup, false);
        return new ViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewAdapter viewAdapter, int i) {
        Cooking ck = ArrCook.get(i);
        // viewAdapter.tvanh.setImageResource(ck.getAnh());

        if (!TextUtils.isEmpty(ck.getAnh())) {
            Picasso.with(ct).load(Key_anh+ck.getAnh()).resize(500, 500).into(viewAdapter.tvanh);
            //  Log.e("True ","Co anh ");
        } else {
            Log.e("Err anh", "Khong co anh");
        }


        viewAdapter.tvten.setText(ck.getTen());
        Format fm1 = new SimpleDateFormat("dd-MM-yyyy");
        viewAdapter.tvgio.setText(fm1.format(ck.getNgay()));
        viewAdapter.tvmoTa.setText(ck.getMoTa());
        //  String videoUrl="http://www.youtubemaza.com/files/data/366/Tom%20And%20Jerry%20055%20Casanova%20Cat%20(1951).mp4";
//        Uri video = Uri.parse(ck.getLink());
//        viewAdapter.tvlink.setVideoURI(video);

//        Bat su kien
    }

    @Override
    public int getItemCount() {
        return ArrCook.size();
    }

    public class ViewAdapter extends RecyclerView.ViewHolder {
        ImageView tvanh;
        TextView tvten, tvgio, tvmoTa;
        VideoView tvlink;

        public ViewAdapter(@NonNull View itemView) {
            super(itemView);
            tvanh = itemView.findViewById(R.id.ivAnh);
            tvten = itemView.findViewById(R.id.tvTen);
            tvgio = itemView.findViewById(R.id.tvNgay);
            tvmoTa = itemView.findViewById(R.id.tvMoTa);
            tvlink = itemView.findViewById(R.id.tvLink);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   // Toast.makeText(ct,"a",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(ct, InforActivity.class);
                   // Gui du lieu
                    int vitri = getAdapterPosition();
                    i.putExtra("moTa",ArrCook.get(vitri).getMoTa());
                    i.putExtra("link",ArrCook.get(vitri).getLink());
                    i.putExtra("ten",ArrCook.get(vitri).getTen());
                    ct.startActivity(i);
                }
            });
        }
    }


}
