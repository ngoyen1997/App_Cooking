package com.example.app_cooking.fragment;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.app_cooking.R;
import com.example.app_cooking.Service.API_Retrofit;
import com.example.app_cooking.activity.Cooking;
import com.example.app_cooking.activity.CookingListRespose;
import com.example.app_cooking.adapter.Cooking_Adapter;

import java.io.IOException;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Cooking_Fragment extends Fragment {
    private RecyclerView recyclerView;
    private Cooking_Adapter cookAdapter;
    private List<Cooking> cookList = new ArrayList<>();
    Date date=null;


    public static Cooking_Fragment newInstance(int id) {

        Bundle args = new Bundle();
        args.putInt("id",id);
        Cooking_Fragment fragment = new Cooking_Fragment();
        fragment.setArguments(args);
        return fragment;
    }
    private int idGR;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        idGR = getArguments().getInt("id");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_eat,container,false);
        recyclerView = view.findViewById(R.id.recyclerView);

//        Format fm = new SimpleDateFormat("yyyy-MM-dd");
//        String dateStr="2011/03/07";
//        try {
//            date=((SimpleDateFormat) fm).parse(dateStr);
//        }catch (ParseException e){
//            e.printStackTrace();
//        }

        loadData();
        cookAdapter = new Cooking_Adapter(getContext(),cookList);


//

        Configuration configuration =getResources().getConfiguration();

        if ( configuration.orientation==Configuration.ORIENTATION_LANDSCAPE){
          RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(getContext());
            recyclerView.setLayoutManager(layoutManager1);
        }else {
            RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(),2);
            recyclerView.setLayoutManager(layoutManager);
        }
        recyclerView.setAdapter(cookAdapter);


        return view;
    }


    private void loadData() {
//        Cooking a = new Cooking(R.drawable.ic_launcher_background,1,"Mon1","abc",date,"abcdas","Mon ngon moi");
//        cookList.add(a);
//        Cooking b = new Cooking(R.drawable.ic_launcher_background,1,"Mon2","abc",date,"abcdas","Mon ngon moi");
//        cookList.add(b);
//        Cooking c = new Cooking(R.drawable.ic_launcher_background,1,"Mon3","abc",date,"abcdas","Mon ngon moi");
//        cookList.add(c);
//        Cooking d = new Cooking(R.drawable.ic_launcher_background,1,"Mon4","abc",date,"abcdas","Mon ngon moi");
//        cookList.add(d);
//        Cooking e = new Cooking(R.drawable.ic_launcher_background,1,"Mon5","abc",date,"abcdas","Mon ngon moi");
//        cookList.add(e);
//        Cooking f = new Cooking(R.drawable.ic_launcher_background,1,"Mon6","abc",date,"abcdas","Mon ngon moi");
//        cookList.add(f);
//        Cooking g = new Cooking(R.drawable.ic_launcher_background,1,"Mon7","abc",date,"abcdas","Mon ngon moi");
//        cookList.add(g);

        // Su dung API de load du lieu tren mang.
        API_Retrofit.getRetrofit().create(API_Retrofit.Data_Service.class)
                .getCookingList("nty",idGR)
                    .enqueue(new Callback<CookingListRespose>() {
                        @Override
                        public void onResponse(Call<CookingListRespose> call, Response<CookingListRespose> response) {
                                //
                                if (response.isSuccessful()){
//                                    try {
//                                        Log.e("getCooking List",response.body().string());
//                                    } catch (IOException e) {
//                                        Log.e("getCooking List Err0 ",e.getMessage());
//                                        e.printStackTrace();
//                                    }
                                    cookList.clear();
                                    cookList.addAll(response.body().getCookList());
                                    cookAdapter.notifyDataSetChanged();
                                }else {
                                    Log.e("getCooking Error 1",response.message());
                                }
                        }

                        @Override
                        public void onFailure(Call<CookingListRespose> call, Throwable throwable) {
                            Log.e("getCooking False Erro 2", throwable.getMessage());
                            throwable.printStackTrace();
                        }
                    });
    }
}
