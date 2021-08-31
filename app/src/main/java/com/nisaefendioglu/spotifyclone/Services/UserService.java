package com.nisaefendioglu.spotifyclone.Services;
import android.content.SharedPreferences;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.nisaefendioglu.spotifyclone.Data.AsyncHandler;
import com.nisaefendioglu.spotifyclone.Model.User;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;

public class UserService {
    private static final String ENDPOINT = "https://api.spotify.com/v1/me";
    private SharedPreferences msharedPreferences;
    private RequestQueue q;
    private User user;

    public UserService(RequestQueue queue, SharedPreferences sharedPreferences) {
        q = queue;
        msharedPreferences = sharedPreferences;
    }

    public User getUser() {
        return user;
    }
    public void get(final AsyncHandler callBack) {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, ENDPOINT, null, response -> {
            Gson gson = new Gson();
            user = gson.fromJson(response.toString(), User.class);
            callBack.finished();
        }, error -> get(() -> {

        })) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                String token = msharedPreferences.getString("token", "");
                String auth = "Bearer " + token;
                headers.put("Authorization", auth);
                return headers;
            }
        };
        q.add(jsonObjectRequest);
    }

}
