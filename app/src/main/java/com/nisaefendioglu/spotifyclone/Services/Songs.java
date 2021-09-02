package com.nisaefendioglu.spotifyclone.Services;

import android.content.Context;
import android.content.SharedPreferences;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.nisaefendioglu.spotifyclone.Data.Artists;
import com.nisaefendioglu.spotifyclone.Data.AsyncHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Songs {
    private ArrayList<Artists> artists = new ArrayList<Artists>();
    private SharedPreferences sp;
    private RequestQueue q;

    public Songs(Context context){
        sp = context.getSharedPreferences("SPOTIFY", 0);
        q = Volley.newRequestQueue(context);
    }

    public  ArrayList<Artists> getArtists(){
        return artists;
    }

    public ArrayList<Artists> getTopArtists(final AsyncHandler callback){
        String url = "https://api.spotify.com/v1/me/top/artists";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, response -> {
            Gson gson = new Gson();
            JSONArray items = response.optJSONArray("items");
            for (int i = 0; i < items.length(); i++) {
                try{
                        JSONObject obj = items.getJSONObject(i);
                        String id = obj.getString("id");
                        String name = obj.getString("name");

                        Artists artist = new Artists(name, id);
                        artists.add(artist);

                } catch (JSONException e){ }
            }
            callback.finished();

        }, error -> getTopArtists(() -> {

        })) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError{
                Map<String, String> headers = new HashMap();
                String token = sp.getString("token", "");
                String auth = "Bearer " + token;
                headers.put("Authorization", auth);
                return headers;
            }
        };

        q.add(jsonObjectRequest);
        return artists;

    }
}
