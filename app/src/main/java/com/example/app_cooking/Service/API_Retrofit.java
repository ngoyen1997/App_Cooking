package com.example.app_cooking.Service;

import com.example.app_cooking.activity.CookingListRespose;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public class API_Retrofit {

//
    private  static  Retrofit retrofit=null;
  public static String DOMAIN="https://app-music.000webhostapp.com/"  ;
    //public static String DOMAIN="https://192.168.56.1:8080/"  ;
    public static String BaseURL=DOMAIN + "serverCode/"  ;

    //    Cau hinh cho retrofit
    public  static Retrofit getRetrofit(){
        OkHttpClient okHttpClient= new OkHttpClient.Builder().readTimeout(15000, TimeUnit.MILLISECONDS)
                .writeTimeout(15000,TimeUnit.MILLISECONDS)
                .connectTimeout(15000,TimeUnit.MILLISECONDS)
                .retryOnConnectionFailure(true)
                .protocols(Arrays.asList(Protocol.HTTP_1_1))
                .build();


        Gson gson = new GsonBuilder().setLenient().create();
            if (retrofit==null){
                retrofit=new Retrofit.Builder()
                        .baseUrl(BaseURL)
                        .client(okHttpClient)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build();
            }


        return retrofit;
    }

    public interface Data_Service {
        @GET("index.php?action=get")
        // public ResponseBody getCookingList(@Query("token") String token);
        public Call<CookingListRespose> getCookingList(@Query("token") String usertoken,@Query("id") int idGR);

//        @FormUrlEncoded
//       @POST("UpdateLuotThich.php")
//        Call<String>  UpdateLuotLike(@Field("luotthich ") int luotthich,@Field("idVideo ") int idVideo);


    }

}
