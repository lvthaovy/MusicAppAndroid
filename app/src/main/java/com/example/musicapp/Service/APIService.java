package com.example.musicapp.Service;

public class APIService {
//    private static String base_url = "https://music4b.000webhostapp.com/Server/";
private static String base_url = "https://mp3zing-android.000webhostapp.com/server/";
    public static Dataservice getService(){
        return APIRetrofitClient.getClient(base_url).create(Dataservice.class);
    }
}
